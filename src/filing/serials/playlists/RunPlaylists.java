package filing.serials.playlists;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunPlaylists {
    public static ArrayList<Movie> catalogue = new ArrayList<>();
    public static ArrayList<Playlist> playlists = new ArrayList<>();
    private static final String CAT_PATH = "data\\MoviesPractice.txt";


    static boolean loadCatalogue(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(CAT_PATH));
            String[] parts;
            for (String line : lines){
                parts = line.split(";");
                catalogue.add(new Movie(
                        parts[0],
                        Integer.parseInt(parts[1]),
                        Double.parseDouble(parts[2]),
                        Integer.parseInt(parts[3])
                ));
            }
            return true;
        } catch (IOException e) {
            System.out.println("Nepodarilo se nacist katalog...");
            return false;
        }
    }

    static void hub(){
        int userInput;
        Scanner sc = new Scanner(System.in);
        for(;;){
            //vypis a zeptej se uzivatele
            System.out.println("Legenda:");
            System.out.println("1: vypis filmy          2: vypis playlisty");
            System.out.println("3: novy playlist        4: Edit playlistu");
            System.out.println("0: konec programu");

            userInput = sc.nextInt();
            switch (userInput) {
                case 1 -> printCatalogue();
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Neimplementovano....");
                }
            }
        }
    }


    static void printCatalogue(){
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println(i +": "+ catalogue.get(i));
        }
    }

    public static void main(String[] args) {
        if (loadCatalogue()){
//            System.out.println(catalogue);
//            System.out.println("Pokracji...");

            hub();
        } else {
            System.out.println("Ukoncuji program...");
        }
    }
}
