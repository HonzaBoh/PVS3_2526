package filing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovieExample {
    public static void main(String[] args) {
        String path = "data/Movies.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            List<Movie> movies = new ArrayList<>();

            for(String line : lines){
                String[] parts = line.split(";");
                movies.add(new Movie(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            }

            for(Movie m : movies){
                System.out.println(m);
            }

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}

class Movie {
    private String name;
    private int year;
    private double rating;
    private int duration;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }

    public Movie(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }
}