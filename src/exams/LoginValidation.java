package exams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoginValidation {
    static List<String> usernames;
    static List<String> pinCodes;
    static int totalValidLines = 0;
    static int totalLines = 0;

    static ArrayList<String> getValids(String fileName) throws IOException {
        ArrayList<String> validLines = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        totalLines += lines.size();
        String[] parts;
        for (String line : lines){
            parts = line.split("=");
            if (usernames.contains(parts[0]) && usernames.indexOf(parts[0]) == pinCodes.indexOf(parts[1])){
                totalValidLines++;
                validLines.add(line);
            }
        }
        System.out.println(fileName + ": " + validLines.size());
        return validLines;
    }

    public static void main(String[] args) throws IOException{
        String pinDirPath = "data\\pins\\";
        pinCodes = Files.readAllLines(Paths.get(pinDirPath+"AllPins.txt"));
        usernames = Files.readAllLines(Paths.get(pinDirPath+"usernames.txt"));

        System.out.println(pinCodes);
        System.out.println(usernames);
        ArrayList<String> toPush;
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("validLogins.txt")));
        for (int i = 1; i <= 5; i++) {
            toPush = getValids(pinDirPath + "attempts_" + i + ".txt");
            for (String line : toPush){
                pw.println(line);
            }

        }
        pw.close();

        System.out.println("Total valid lines: " + totalValidLines);
        System.out.println("Total lines: " + totalLines);
        System.out.println(((double) totalValidLines/totalLines) * 100 + " %");
    }
}