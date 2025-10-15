package oop.interfaces;

import fileworks.DataImport;

import java.util.*;

public class Book implements Comparable<Book> {

    String name;
    String author;
    int year;
    int pages;

    final static Comparator<Book> BY_PAGES = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return Integer.compare(o1.pages, o2.pages);
        }
    };

    final static Comparator<Book> BY_YEAR = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };

    public Book(String name, String author, int year, int pages) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }


    public static void main(String[] args) {
        DataImport di = new DataImport("books.txt");

        ArrayList<Book> books = new ArrayList<>();

        while (di.hasNext()) {
            String[] parts = di.readLine().split(";");

            Book b = new Book(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            books.add(b);
        }
        System.out.println(books);

        Collections.sort(books);
//        Collections.sort(books, Book.BY_YEAR);
        books.sort(Book.BY_YEAR.reversed());

        System.out.println(books);

        di.finishImport();
    }
}
