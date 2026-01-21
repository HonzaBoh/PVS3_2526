package filing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NamesReader {

    static void namePrinter(String filePathBase, int amount, String fileType){
        String longestNameTotal = "";
        String fileName;
        for (int i = 0; i < amount; i++) {
            try {
                fileName = filePathBase + (i+1) + fileType;
                List<String> lines = Files.readAllLines(Paths.get(fileName));
                String longestNameLocal = "";
                for (String line : lines){
                    if (line.length() > longestNameLocal.length()){
                        longestNameLocal = line;
                    }
                }

                if (longestNameLocal.length() > longestNameTotal.length()){
                    longestNameTotal = longestNameLocal;
                }
                System.out.println(fileName + ": " + longestNameLocal);
            } catch (IOException e) {
                System.out.println("Chyba pri praci se souborem: " + e.getMessage());;
            }
        }

        System.out.println("Total longest name: " + longestNameTotal);
    }

    public static void main(String[] args) {
        namePrinter("data\\AllNames\\names", 30, ".txt");
    }
}
