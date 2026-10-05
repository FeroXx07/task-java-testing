package level_1.exercise_1_unit_test;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;

    public Book(String title) {
        validateTitle(title);
        this.title = title;
    }

    public String getTitle() { return title; }

    private void validateTitle(String title){
        if(title == null){
            throw new IllegalArgumentException("Title cannot be null!");
        }
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank or empty!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }
}
