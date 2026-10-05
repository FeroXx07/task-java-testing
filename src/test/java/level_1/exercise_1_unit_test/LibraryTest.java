package level_1.exercise_1_unit_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        String actualTitle = library.getBookTitleAt(expectedIndex);
        assertEquals(expectedTitle, actualTitle);
    }

}