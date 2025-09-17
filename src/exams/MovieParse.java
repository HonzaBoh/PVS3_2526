package exams;

import fileworks.DataImport;

public class MovieParse {

    public static void main(String[] args) {
        DataImport di = new DataImport("movieList.txt");
        String line;
        Movie currentMovie;
        String[] params;
        int thrillerCount = 0;
        Movie oldestOne = new Movie("DUMMY", Integer.MAX_VALUE, "w/e", 1.1);
        while (di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            currentMovie = new Movie(
                    params[0],
                    Integer.parseInt(params[1]),
                    params[2],
                    Double.parseDouble(params[3])
            );

            if (currentMovie.getRating() > 9.9){
                System.out.println(currentMovie);
            }

            if (currentMovie.getGenre().equals("Thriller")){
                thrillerCount++;
            }

            if (currentMovie.getYearOfRelease() < oldestOne.getYearOfRelease()){
                oldestOne = currentMovie;
            }
        }

        System.out.println("Nalezeno Thrilleru: " + thrillerCount);
        System.out.println("Nejstarsi film: " + oldestOne);
        di.finishImport();
    }

}
class Movie{
    String name;
    int yearOfRelease;
    String genre;
    double rating;

    public Movie(String name, int yearOfRelease, String genre, double rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
