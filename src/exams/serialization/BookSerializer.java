package exams.serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookSerializer {
    public static void main(String[] args) {
        String dataPath = "data/books.txt";
        String booksSerialised = "data/books.ser";

        try {
            // načíst soubor
            List<Book> books = parseBooks(dataPath);

            // sort by rating
            Comparator<Book> BY_RATING = new Comparator<>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return Double.compare(o1.getRating(), o2.getRating());
                }
            };
            books.sort(BY_RATING.reversed());

            // vytvoření booklistu, průměr se počítá uvnitř konstruktoru
            List<Book> top10 = new ArrayList<>();
            for(int i = 0; i < 10; i++) {
                top10.add(books.get(i));
            }

            BookList bl = new BookList(top10);

            // serializace
            serializeBookList(bl, booksSerialised);

            // deserializace
            deserializeBookList(booksSerialised);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while serializing book list");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error while deserializing book list");
        }
    }

    /**
     * Metoda deserializuje soubor a vypíše jeho obsah
     * @param path cesta k souboru
     */
    public static void deserializeBookList(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        BookList books = (BookList) ois.readObject();
        System.out.println(books);
        ois.close();
    }

    public static void serializeBookList(BookList books, String outputName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputName));
        oos.writeObject(books);
        oos.close();
    }

    public static List<Book> parseBooks(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        List<Book> books = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.trim().split(";");

            String name = parts[0];
            String author = parts[1];

            int year = Integer.parseInt(parts[2]);
            int pages = Integer.parseInt(parts[3]);

            double rating = Double.parseDouble(parts[4].replace(",", "."));
            books.add(new Book(name, author, year, pages, rating));
        }

        return books;
    }
}
