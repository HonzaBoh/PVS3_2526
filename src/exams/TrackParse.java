package exams;

  /*
    1. Vytvořit třídu Track, která reprezentuje jednu skladbu.
        - Skladba obsahuje, Název, Rok vydání, Hodnocení a Délku v sekundách
        - Minimálně obsahuje konstruktor + toString()
    2. Načtěte všechny skladby ze souboru "tracks.txt"
    3. Zapište do nového souboru "skladby.txt" všechny skladby ve formátu
        Název skladby - délka v mm:ss
    4. Zapište do nového souboru "Top_10.txt" 10 libovolných skladeb s hodnocením >=8.5
     */

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

public class TrackParse {
    public static void main(String[] args) {
        DataImport di = new DataImport("tracks.txt");
        ArrayList<Track> playlist = new ArrayList<>();
        while (di.hasNext()) {
            String[] parts = di.readLine().split(";");
            Track t = new Track(parts[0],
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[1]),
                    Double.parseDouble(parts[2])
            );

            playlist.add(t);
        }
        DataExport de = new DataExport("songy.txt");
        for(Track t : playlist){
            de.writeLine(t.toString());
        }

        int pocet = 0;

        DataExport de2 = new DataExport("top10.txt");

        for(Track t : playlist){
            if(t.rating >= 8.5 && pocet != 10){
                de2.writeLine(t.toString());
                pocet++;
            }
        }

        de.finishExport();
        di.finishImport();
    }
}

class Track {
    String nazev;
    int lenght;
    int year;
    double rating;

    public Track(String nazev, int lenght, int year, double rating) {
        this.nazev = nazev;
        this.lenght = lenght;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return nazev + " - " + lenght / 60 + ":" + lenght % 60;
    }
}
