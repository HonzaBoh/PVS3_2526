package filing.serials.playlists;

import java.io.Serial;
import java.io.Serializable;

public class Movie implements Serializable {
    String name;
    int yearOfRelease;
    double rating;
    int duration;
    @Serial
    private static final long serialVersionUID = 1L;

    public Movie(String name, int yearOfRelease, double rating, int duration) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duration = duration;
    }

    @Override
    public String toString(){
        return name + " (" + yearOfRelease + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}