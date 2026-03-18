package exams.serialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

// TODO: make it serializable
public class BookList {
    private List<Book> books;
    private double avgRating;

    @Override
    public String toString() {
        return "BookList{" +
                "books=" + books +
                ", avgRating=" + avgRating +
                '}';
    }
}
