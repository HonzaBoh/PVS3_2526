package streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovieStreaming {

    static ArrayList<Movie> parseMovies(String filePath){
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            ArrayList<Movie> movies = new ArrayList<>();
            String[] tokens;
            for (String line : lines){
                tokens = line.split(";");
                movies.add(new Movie(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3])
                ));
            }
            return movies;
        } catch (IOException e){
            System.out.println("Chyba se soubory: " + e.getMessage());
            return null; //nema s cim pracovat
        }
    }
    public static void main(String[] args) {
        ArrayList<Movie> movies = parseMovies("data/Movies.txt");

        movies.stream()
                .filter(m -> m.getYear() >= 2000)
                .forEach(System.out::println);
        System.out.println("======");

        movies.stream()
                .filter(m -> m.getYear() >= 2000 && m.getRating() > 7.0)
                .forEach(System.out::println);

        //ulozit pro dalsi praci: filmy do roku 2000
        List<Movie> oldies = movies.stream()
                .filter(movie -> movie.getYear() < 2000)
                .toList();

        //prumerny rating filmu po roce 2010
        double avgRating = movies.stream()
                .filter(m -> m.getYear() >= 2010)
//                .mapToDouble(Movie::getRating)
//                .mapToDouble(movie -> movie.getRating())
                .mapToDouble(movie -> movie.rating)
                .average()
                .orElse(0);

        //celkova doba trvani filmu z roku 1995
        long totalDuration = movies.stream()
                .filter(m -> m.getYear() == 1995)
                .mapToInt(movie -> movie.getDuration())
                .sum();

    }
}

class Movie {
    String name;
    int year;
    double rating;
    int duration;

    public Movie(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return getName() + " (" + getYear() + ") [" + getRating() + "/10]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
