package filing;

import fileworks.DataImport;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class ReadingDemo {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "data/books.txt";
        File f = new File(path);
//        // způsob 0
//        DataImport di = new DataImport(path);
//        while(di.hasNext()){
//            System.out.print(di.readChar());
//        }

//        di.finishImport();

        // způsob 0.5
        Scanner sc = new Scanner(f);
        sc.useLocale(Locale.US);
        sc.useDelimiter(",");

        double d = sc.nextDouble();
//        while (sc.hasNext()) {
//            // System.out.print(sc.next());
//        }
//        sc.close();


        try {

            // FileReader fr = new FileReader(path);

            if (!f.isFile()) {
                return;
            }
            // způsob 1
            FileReader fr2 = new FileReader(f);

            int input;
            while((input = fr2.read()) != -1){
                System.out.print((char) input);
            }


            // Způsob 2
            // BufferedReader br = new BufferedReader(new FileReader(new File("data/books.txt")));
            BufferedReader br = new BufferedReader(fr2);
            String line;

//            while((line = br.readLine()) != null){
//                System.out.println(line);
//            }

            fr2.close();
            br.close();

            List<String> lines = Files.readAllLines(Paths.get(path));
            for(String l : lines){
                System.out.println(l);
            }


            FileInputStream inputStream = new FileInputStream(path);
            int a;
            while ((a = inputStream.read()) != -1){
                System.out.println((char) a);
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException io){
            System.out.println("Something wrong!");
        }


    }
}
