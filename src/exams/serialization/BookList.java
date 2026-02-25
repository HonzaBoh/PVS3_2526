package exams.serialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

// TODO: make it serializable
public class BookList implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private List<Book> books;
    private double avgRating;

    @Override
    public String toString() {
        return "BookList{" +
                "books=" + books +
                ", avgRating=" + avgRating +
                '}';
    }

    public BookList(List<Book> books) {
        this.books = books;

        // sanity
        if(books != null && !books.isEmpty()) {

            double avg = 0.0;
            for(Book book : books) {
                avg += book.getRating();
            }
            this.avgRating = avg / books.size();
        }
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
