import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.myproject.Book;
import com.myproject.Journal;
import com.myproject.Library;
import com.myproject.Literature;

public class LibraryTest {
    @Test
    public void testAddLiterature() {
        Library library = new Library();

        Book book1 = new Book("Author1", "Title1", "Genre1", 2000);
        Book book2 = new Book("Author2", "Title2", "Genre2", 2001);
        Journal journal1 = new Journal("Title1", "Topic1", 2004);
        library.addLiterature(book1);
        library.addLiterature(book2);
        library.addLiterature(journal1);

        List<Literature> expectedBooks = new ArrayList<>();
        expectedBooks.add(book1);
        expectedBooks.add(book2);
        expectedBooks.add(journal1);
        assertTrue(expectedBooks.contains(book1));
        assertTrue(expectedBooks.contains(book2));
        assertTrue(expectedBooks.contains(journal1));
    }

    @Test
    public void testGetBooksInTimeInterval() {
        Library library = new Library();
        List<Literature> request;

        Book book1 = new Book("Author1", "Title1", "Genre1", 2000);
        Book book2 = new Book("Author2", "Title2", "Genre2", 2001);
        Book book3 = new Book("Author3", "Title3", "Genre3", 2012);
        Journal journal1 = new Journal("Title1", "Topic1", 2004);
        Journal journal2 = new Journal("Title2", "Topic2", 2011);

        library.addLiterature(book1);
        library.addLiterature(book2);
        library.addLiterature(book3);
        library.addLiterature(journal1);
        library.addLiterature(journal2);

        request = library.getLiteratureByYears(1999, 2005);

        assertTrue(request.contains(journal1));
        assertFalse(request.contains(journal2));
        assertTrue(request.contains(book1));
        assertTrue(request.contains(book2));
        assertFalse(request.contains(book3));

    }

    @Test
    public void testGetAllBooks() {
        Library library = new Library();
        List<Book> expectedBooks = new ArrayList<>();

        Literature book1 = new Book("Author1", "Title1", "Genre1", 2000);
        Literature book2 = new Book("Author2", "Title2", "Genre2", 2001);
        Literature book3 = new Book("Author3", "Title3", "Genre3", 2012);

        library.addLiterature(book1);
        library.addLiterature(book2);
        library.addLiterature(book3);

        expectedBooks = library.getAllBooks();

        assertTrue(expectedBooks.contains(book1));
        assertTrue(expectedBooks.contains(book2));
        assertTrue(expectedBooks.contains(book3));
    }

    @Test
    public void testGetAllJournals() {
        Library library = new Library();
        List<Journal> expectedJournals = new ArrayList<>();

        Journal journal1 = new Journal("Title1", "Topic1", 2010);
        Journal journal2 = new Journal("Title2", "Topic2", 2011);
        Journal journal3 = new Journal("Title3", "Topic3", 2012);

        library.addLiterature(journal1);
        library.addLiterature(journal2);
        library.addLiterature(journal3);

        expectedJournals = library.getAllJournals();

        assertTrue(expectedJournals.contains(journal1));
        assertTrue(expectedJournals.contains(journal2));
        assertTrue(expectedJournals.contains(journal3));
    }
}
