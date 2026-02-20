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
    private static final String SAVE_PATH = "data\\save.ser";


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
                case 2 -> printPlaylists();
                case 3 -> createPlaylist(sc);
                case 0 -> {
                    saveState();
                    return;
                }
                default -> {
                    System.out.println("Neimplementovano....");
                }
            }
        }
    }

    static void saveState(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH))){
            oos.writeObject(playlists);
            System.out.println("Uspesne zapsano: " + new File(SAVE_PATH).getAbsolutePath());
        } catch (IOException ioe){
            System.out.println("Chyba pri ukladani souboru: " + ioe.getMessage());
        }

    }

    static void loadState(){
        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream(SAVE_PATH))){
            playlists = (ArrayList<Playlist>) oos.readObject();
            System.out.println("Uspesne zapsano: " + new File(SAVE_PATH).getAbsolutePath());
        } catch (IOException ioe){
            System.out.println("Chyba pri nacitani souboru: " + ioe.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Trida nee");
        }

    }

    static void createPlaylist(Scanner inputReader){
        Playlist p = new Playlist("Playlist #" + playlists.size()+1);
        printCatalogue();
        System.out.println("Zadavej indexy filmu, ktere chces pridat:");
        int input;
        while ((input = inputReader.nextInt()) != -1){
            p.programme.add(catalogue.get(input));
            System.out.println("Do playlistu pridano " + catalogue.get(input));
        }
        playlists.add(p);
    }

    static void printCatalogue(){
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println(i +": "+ catalogue.get(i));
        }
    }

    static void printPlaylists(){
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println(i +": "+ playlists.get(i));
        }
    }
    public static void main(String[] args) {
        if (loadCatalogue()){
//            System.out.println(catalogue);
//            System.out.println("Pokracji...");
            if (new File(SAVE_PATH).exists()){
                loadState();
            }
            hub();
        } else {
            System.out.println("Ukoncuji program...");
        }
    }
}
