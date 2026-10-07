package level_1.exercise_1_unit_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @AfterEach
    void tearDown() {
        library = null;
    }

    @Test
    void collectionNotNull() {
        assertNotNull(library.getCollection());
    }

    @Test
    void noDuplicatesAssert(){
        String expectedTitleA = "Books_1";
        String expectedTitleB = "Books_4";

        try {
            library.addBook(expectedTitleA);
            library.addBook(expectedTitleB);
        } catch (TitleAlreadyTaken e) {
            throw new RuntimeException(e);
        }

        assertThrows(TitleAlreadyTaken.class, () -> library.addBook(expectedTitleA));
        assertThrows(TitleAlreadyTaken.class, () -> library.addBook(expectedTitleB));
    }

    @Test
    void whenAdditions_thenAssertSize(){
        try {
            library.addBook("Book_1");
            library.addBook("Book_2");
            library.addBook("Book_3");
            library.addBook("Book_4");
        } catch (TitleAlreadyTaken e) {
            throw new RuntimeException(e);
        }
        assertEquals(4, library.getCollection().size());
    }

    @Test
    void whenEmplaceAdditions_thenAssertOrder(){
        int expectedIndex = 2;
        String expectedTitle = "Book_5";

        try {
            library.addBook("Book_1");
            library.addBook("Book_2");
            library.addBook("Book_3");
            library.addBook("Book_4");
            library.addBookAt(expectedIndex, expectedTitle);
        } catch (TitleAlreadyTaken e) {
            throw new RuntimeException(e);
        }

        String book2 = library.getBookTitleAt(1);
        assertEquals("Book_2", book2);

        String book3 = library.getBookTitleAt(3);
        assertEquals("Book_3", book3);

        String actualTitle = library.getBookTitleAt(expectedIndex);
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void getBookTitleAt(){
        String expectedTitleB = "Book_4";
        int expectedIndexB = 3;

        try {
            library.addBook("Book_1");
            library.addBook("Book_2");
            library.addBook("Book_3");
            library.addBook(expectedTitleB);
        } catch (TitleAlreadyTaken e) {
            throw new RuntimeException(e);
        }

        String bookTitle2 = library.getBookTitleAt(expectedIndexB);
        assertEquals(expectedTitleB, bookTitle2);
    }

    @Test
    void whenRemoval_thenAssertSize(){
        try {
            library.addBook("Book_1");
            library.addBook("Book_2");
            library.addBook("Book_3");
            library.addBook("Book_4");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        library.removeBook("Book_1");
        assertEquals(3, library.getCollection().size());

        library.removeBook("Book_2");
        assertEquals(2, library.getCollection().size());
    }

    @Test
    void getBooksByAZOrder(){
        String expectedTitleA = "A book of set Theory";
        String expectedTitleB = "Dictionary";
        String expectedTitleC = "Bible";
        String expectedTitleD = "Zoology 2026";
        String expectedTitleE = "Revised Maths";
        try {
            library.addBook(expectedTitleA);
            library.addBook(expectedTitleB);
            library.addBook(expectedTitleC);
            library.addBook(expectedTitleD);
            library.addBook(expectedTitleE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Book> books = library.getBooksByAZOrder();
        assertEquals(expectedTitleA, books.get(0).getTitle());
        assertEquals(expectedTitleC, books.get(1).getTitle());
        assertEquals(expectedTitleB, books.get(2).getTitle());
        assertEquals(expectedTitleE, books.get(3).getTitle());
        assertEquals(expectedTitleD, books.get(4).getTitle());
    }

    @Test
    void getBooksInsertOrder(){
        String expectedTitleA = "A book of set Theory";
        String expectedTitleB = "Dictionary";
        String expectedTitleC = "Bible";
        String expectedTitleD = "Zoology 2026";
        String expectedTitleE = "Revised Maths";
        try {
            library.addBook(expectedTitleA);
            library.addBook(expectedTitleB);
            library.addBook(expectedTitleC);
            library.addBook(expectedTitleD);
            library.addBook(expectedTitleE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Book> books = library.getBooksInsertOrder();
        assertEquals(expectedTitleA, books.get(0).getTitle());
        assertEquals(expectedTitleB, books.get(1).getTitle());
        assertEquals(expectedTitleC, books.get(2).getTitle());
        assertEquals(expectedTitleD, books.get(3).getTitle());
        assertEquals(expectedTitleE, books.get(4).getTitle());
    }

}