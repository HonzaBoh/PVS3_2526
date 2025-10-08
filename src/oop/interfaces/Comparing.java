package oop.interfaces;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparing {

    public static void main(String[] args) {
        ArrayList<Track> songs = new ArrayList<>();
        songs.add(new Track("Dream On", 1973, 8.9, 205));
        songs.add(new Track("Jozin z bazin", 1978, 7.0, 167));
        songs.add(new Track("Tadada", 2005, 6.54, 123));
        Collections.shuffle(songs);
        System.out.println(songs);
        //vezmi razeni
        Collections.sort(songs);
        System.out.println(songs);
//        DurationComparator dc = new DurationComparator();
//        songs.sort(dc);
//        System.out.println(songs);
        final Comparator<Track> BY_DURATION = new Comparator<Track>() {
            @Override
            public int compare(Track o1, Track o2) {
                return Integer.compare(o1.durationSeconds, o2.durationSeconds);
            }
        };

        //vezmi razeni
        songs.sort(BY_DURATION);
        System.out.println(songs);

        //vezmi razeni - vyhoda
        songs.sort(BY_DURATION.reversed());
        System.out.println(songs);
    }
}

class Track implements Comparable<Track> {
    String name;
    int year;
    double rating;
    int durationSeconds;

    final static Comparator<Track> BY_YEAR = new Comparator<Track>() {
        @Override
        public int compare(Track o1, Track o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };

    public Track(String name, int year, double rating, int durationSeconds) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String toString() {
        return name + " (" + year + ")" + ", rated: " + rating + ", duration: " + durationSeconds + " s \n";
    }

    @Override
    public int compareTo(Track o) {
        //podle roku vydani
//        return o.year - this.year;

        //podle ratingu
//        return (int) (o.rating - this.rating);

        //podle jmena
        return this.name.compareTo(o.name);
    }
}