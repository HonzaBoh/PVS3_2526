package filing;

import fileworks.DataExport;

import java.io.*;
import java.util.Random;

public class WritingDemo {
    public static void main(String[] args) {
        String fileName = "coords.txt";
        Random r = new Random();
        //znamy zpusob:
        DataExport de = new DataExport(fileName);
        for (int i = 0; i < 10000; i++) {
            de.writeLine(r.nextInt(-10000,10001) + "," + r.nextInt(-10000,10001));
        }
//        de.finishExport();

        //psani do souboru: po znacich = po bytech
        try {
            //tohle rovnou vytrvori prazdny soubor
            FileWriter fw = new FileWriter(fileName);
//            fw.write("hello\n");
//            fw.write("World");
            for (int i = 0; i < 10000; i++) {
//                fw.write(r.nextInt(-10000,10001));
                fw.write(String.valueOf(r.nextInt(-10000,10001)));
                fw.write(',');
//                fw.write(r.nextInt(-10000,10001));
                fw.write(String.valueOf(r.nextInt(-10000,10001)));
                fw.write('\n');
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Chyba pri praci se souborem: " + e.getMessage());
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//            bw.write("hello");
//            bw.newLine();
//            bw.write("world");
            for (int i = 0; i < 10000; i++) {
                bw.write(r.nextInt(-10000, 10001) + "," + r.nextInt(-10000, 10001));
                bw.newLine();
            }

//            bw.close();
        } catch (IOException e) {
            System.out.println("Chyba pri praci se souborem: " + e.getMessage());
        }

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (int i = 0; i < 100000; i++) {
                pw.println(r.nextInt(-10000, 10001) + "," + r.nextInt(-10000, 10001));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Chyba pri praci se souborem: " + e.getMessage());
        }
    }
}
