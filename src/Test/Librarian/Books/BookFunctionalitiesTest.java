package Test.Librarian.Books;

import Librarian.BookService;
import Librarian.Zh_Books;
import Librarian.BookFunctionalities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


class BookFunctionalitiesTest {
    @TempDir
    static File tempFolder;

    @AfterEach
    void cleanup() {
        tempFolder.delete();
    }

    @Test
    void testGetBooks() throws IOException {
        File tempFile = new File(tempFolder, "testBooks.dat");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            Zh_Books book1 = new Zh_Books("Book 1", "Author 1", 2023);
            Zh_Books book2 = new Zh_Books("Book 2", "Author 2", 2024);
            objectOutputStream.writeObject(book1);
            objectOutputStream.writeObject(book2);
        }

        ArrayList<Zh_Books> bookList = BookFunctionalities.getBooks("testBooks.dat");
        assertEquals(2, bookList.size());
        assertEquals("Book 1", bookList.get(0).getTitle());
        assertEquals("Author 2", bookList.get(1).getISBN());
        assertEquals(2024, bookList.get(1).getQuanity());
    }


    @Test
    public void testUpdateBook() {
        // Mocking BookFunctionalities
        BookFunctionalities mockedFunctionalities = Mockito.mock(BookFunctionalities.class);
        ArrayList<Zh_Books> mockedBooks = new ArrayList<>();
        Zh_Books bookToUpdate = new Zh_Books("123", "Updated Title", 2);
        mockedBooks.add(new Zh_Books("123", "Title", 1)); // Adding an initial book to the mocked list

        // Cast the ArrayList<Zh_Books> to ArrayList<Object> for thenReturn method
        when(mockedFunctionalities.getBooks(Mockito.any())).thenReturn((ArrayList<Object>) mockedBooks);

        // Mock writeBooksInFile method
        doNothing().when(mockedFunctionalities).writeBooksInFile(any());

        // Using the mocked BookFunctionalities in BookService
        BookService bookService = new BookService(mockedFunctionalities);
        ArrayList<Zh_Books> result = bookService.UpdateBook(bookToUpdate);

        // Assertions
        assertEquals("Updated Title", result.get(0).getTitle()); // Check if the book title is updated

        // Verify that getBooks method is called once
        Mockito.verify(mockedFunctionalities, Mockito.times(1)).getBooks(Mockito.any());

        // Verify that writeBooksInFile method is called once
        Mockito.verify(mockedFunctionalities, Mockito.times(1)).writeBooksInFile(any());
    }



}