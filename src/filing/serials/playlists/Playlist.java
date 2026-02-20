package filing.serials.playlists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Kolekce vsech filmu v playlistu
 * @author bohac
 * @version 20-2-2026
 */
public class Playlist implements Serializable {

    /**
     * Kolekce vsech filmu v playlistu
     */
    List<Movie> programme;
    /**
     * Jmeno pro playlist filmu
     */
    String name;

    /**
     * Konstruktor pro vytvoreni playlistu rovnou s nejakou sadou filmu
     * @param name nazev pro playlist
     * @param programme pocatecni list, do kteroho lze vkladat
     */
    public Playlist(List<Movie> programme, String name){
        this.name = name;
        this.programme = programme;
    }

    /**
     * Konstruktor pro vytvoreni prazdneho playlistu
     * @param name nazev pro playlist
     */
    public Playlist(String name){
        this.name = name;
        this.programme = new ArrayList<>();
    }


    @Override
    public String toString(){
        return name + "(" + (getTotalDuration()/60) + ":" + (getTotalDuration()%60) + "), movies: " + programme.size();
    }

    /**
     * Metoda pro celkove doby trvani ve vterinach
     * @return
     */
    public int getTotalDuration(){
        int totalDuration = 0;
        for (Movie movie : programme){
            totalDuration += movie.getDuration();
        }
        return totalDuration;
    }
}