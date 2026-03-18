package exams.serialization;

// TODO: make it serializable
// Add getters/setters/constructor/toString

public class Book {
    public String title;
    public String author;

    public int yearOfRelease;
    public int numberOfPages;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", numberOfPages=" + numberOfPages +
                ", rating=" + rating +
                '}';
    }

    public Book(String title, String author, int yearOfRelease, int numberOfPages, double rating) {
        this.title = title;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.numberOfPages = numberOfPages;
        this.rating = rating;
    }

    public double rating; // 1.0-5.0
}