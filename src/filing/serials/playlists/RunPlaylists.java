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
    private static final String SER_PATH = "data\\playListSave.ser";


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
            System.out.println("0: konec programu (save)");
            System.out.println("-1: konec programu (ne-save)");

            userInput = sc.nextInt();
            switch (userInput) {
                case 1 -> printCatalogue();
                case 2 -> printPlaylists();
                case 3 -> createPlaylist(sc);
                case 0 -> {
                    saveState();
                    return;
                }
                case -1 -> {
                    return;
                }
                default -> {
                    System.out.println("Neimplementovano....");
                }
            }
        }
    }

    static void saveState(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SER_PATH))) {
            oos.writeObject(playlists);
            System.out.println("Uspesne zapasno: " + new File(SER_PATH).getAbsolutePath());
        } catch (IOException e){
            System.out.println("Chyba pri ukladani souboru: " + e.getMessage());
        }
    }

    static void loadState(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SER_PATH))) {
            playlists = (ArrayList<Playlist>) ois.readObject();
            System.out.println("Uspesne nacteno: " + new File(SER_PATH).getAbsolutePath());
        } catch (IOException e){
            System.out.println("Chyba pri cteni souboru: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Trida nee: " + e.getMessage());
        }
    }

    private static void printPlaylists() {
//        for (Playlist p : playlists){
//            System.out.println(p);
//        }
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println(i + ": " + playlists.get(i));
        }
//        System.out.println(playlists.toString());
    }

    static void createPlaylist(Scanner inputReader){
        Playlist p = new Playlist("Playlist #" + (playlists.size()+1));
        printCatalogue();
        System.out.println("Zadavej index filmu, ktere chces pridat. Zadavani ukoncis -1");
        int input;
        while ((input = inputReader.nextInt())  != -1){
            p.programme.add(catalogue.get(input));
            System.out.println("Do playlistu pridano: " + catalogue.get(input));
        }
        playlists.add(p);
    }

    static void printCatalogue(){
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println(i +": "+ catalogue.get(i));
        }
    }

    public static void main(String[] args) {
        if (loadCatalogue()){
            if (new File(SER_PATH).exists()){
                loadState();
            }
            hub();
        } else {
            System.out.println("Ukoncuji program...");
        }
    }
}
