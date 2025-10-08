package oop.interfaces;

import java.util.Comparator;

public class DurationComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        return o1.durationSeconds - o2.durationSeconds;
    }
}
