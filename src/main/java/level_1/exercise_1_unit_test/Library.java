package level_1.exercise_1_unit_test;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public List<Book> getCollection(){ return books; }

    public void addBook(String title) throws TitleAlreadyTaken {
        if (books.stream().anyMatch(b -> b.getTitle().equals(title))){
            throw new TitleAlreadyTaken("Title already exists");
        }
        books.add(new Book(title));
    }

    public void addBookAt(int index, String title) throws TitleAlreadyTaken{
        if (books.stream().anyMatch(b -> b.getTitle().equals(title))){
            throw new TitleAlreadyTaken("Title already exists");
        }
        books.add(index, new Book(title));
    }

    public void removeBook(String title){
        if (title == null || title.isBlank()){
            throw new TitleEmptyOrNull("Title cannot be null or blank!");
        }
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public List<Book> getBooksInsertOrder(){
        return List.copyOf(books);
    }

    public List<Book> getBooksByAZOrder(){
        return books.stream().sorted().toList();
    }

    public String getBookTitleAt(int index){
        return books.get(index).getTitle();
    }

}
