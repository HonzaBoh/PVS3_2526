package filing;

import generics.Practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Appendix {
    public static void main(String[] args) {
        //try-with resources
        Random r = new Random();
        String path = "added.txt";
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            for (int i = 0; i < 20; i++) {
                pw.println(r.nextInt(100, 1000000));
            }
            //automaticky da close() na veci uvnitr try (*zde*){...}
        } catch (IOException exception) {
            System.out.println("Chyba pri praci se souborem: " + exception.getMessage());
        }
        System.out.println("Happy ending - gen");

        try (PrintWriter another = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
            another.println("test");
        } catch (IOException e) {
            System.out.println("Troble: " + e.getMessage());
        }
        System.out.println("Happy ending - append");
    }
}
