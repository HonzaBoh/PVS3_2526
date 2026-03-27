package filing.serials.playlists;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    private static final String CATALOGUE_PATH = "data/MoviesPractice.txt";
    static List<Movie> catalogue = new ArrayList<>();
    static List<Playlist> playlists = new ArrayList<>();

    static void printLegend(){
        System.out.println("1 - Seznam filmů    2 - Seznam Playlistů");
        System.out.println("3 - Nový Playlist   4 - Edit Playlistů");
        System.out.println("0 - Ukončit         -1 - Neuložit stav");
    }

    static boolean loadCatalogue(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(CATALOGUE_PATH));
            String[] tokens;
            for (String line : lines){
                tokens = line.split(";");
                catalogue.add(new Movie(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3])
                ));
            }
            return true;
        } catch (IOException e) {
            System.out.println("Chyba pri zpracovani zdrojoveho souboru, ukoncuji program...");
            return false;
        }
    }

    static void printCatalogue(){
        System.out.println("===========");
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println(i + ": " + catalogue.get(i));
        }
        System.out.println("===========");
    }

    static void createPlaylist(Scanner inputs){
        int choice;
        List<Movie> selectedMovies = new ArrayList<>();
        while (true){
            printCatalogue();
            System.out.println("Zadej cislo filmu, ktery chces pridat do playlistu");
            System.out.println("Zadanim -1 ukoncis vyber a vytvoris playlist");
            choice = inputs.nextInt();
            if (choice < 0 || choice >= catalogue.size()) break;
            selectedMovies.add(catalogue.get(choice));
        }
        playlists.add(new Playlist(selectedMovies, "Playlist " + (playlists.size() + 1)));
    }

    static void hub(Scanner inputs){
        int userInput;
        while (true){
            System.out.println("Zvolte akci");
            printLegend();
            userInput = inputs.nextInt();
            switch (userInput) {
                case -1 -> {
                    System.out.println("Konec...");
                    return;
                }
                case 0 -> {
                    System.out.println("Ukladani...");
                    // TODO: 13.03.2026 Vymysli ulozeni
                    return;
                }
                case 1 -> printCatalogue();
                case 3 -> createPlaylist(inputs);
            }
        }
    }

    public static void main(String[] args) {
        if (loadCatalogue()){
            Scanner userInputs = new Scanner(System.in);
            hub(userInputs);
        }
    }
}
