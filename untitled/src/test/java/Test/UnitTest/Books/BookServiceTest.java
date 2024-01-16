package Test.UnitTest.Books;



import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {


    @TempDir
    static File tempFolder;


    @Test
    void testGetBooksFromFileWithBooks() throws IOException {
        BookService bookService = new BookService();
        File tempFile = new File(tempFolder, "testBooks.dat");
        bookService.setPath("testBooks.dat");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            Books book1 = new Books("Book 1", "ISBN1", 12);
            Books book2 = new Books("Book 2", "ISBN2", 20);
            objectOutputStream.writeObject(book1);
            objectOutputStream.writeObject(book2);
        }
        ArrayList<Books> bookList = bookService.getBooks(tempFile.getPath());
        assertEquals(2, bookList.size());
        assertEquals("Book 1", bookList.get(0).getTitle());
        assertEquals("ISBN2", bookList.get(1).getISBN());
        assertEquals(20, bookList.get(1).getQuanity());
    }

    @Test
    void testGetBooksFromFileEmpty() throws IOException {
        BookService bookService = new BookService();
        File tempFile = new File(tempFolder, "testBooks.dat");
        ArrayList<Books> bookList = bookService.getBooks(tempFile.getPath());
        assertEquals(0, bookList.size());
    }

    //...................................................

    @Test
    void testAddNewBookToExistingBooks() throws IOException {
        BookService bookService = new BookService();
        File tempFile = new File(tempFolder, "testBooks1.dat");
        ArrayList<Books> booksList = bookService.getBooks(tempFile.getPath());
        Books book = new Books("New Title", "New ISBN", 10); // Title, ISBN, and quantity
        booksList.add(book);
        bookService.writeBooksInFile(booksList, tempFile.getPath());
        ArrayList<Books> updatedBooksList = bookService.getBooks(tempFile.getPath());
        assertEquals(1, updatedBooksList.size());
        assertEquals("New Title", updatedBooksList.get(0).getTitle());
        assertEquals("New ISBN", updatedBooksList.get(0).getISBN());
        assertEquals(10, updatedBooksList.get(0).getQuanity());
    }

    @Test
    void testAddNewBookToEmptyFile() throws IOException {
        BookService bookService = new BookService();
        File tempFile = new File(tempFolder, "emptyBooks.dat");
        tempFile.createNewFile();
        ArrayList<Books> booksList = new ArrayList<>();
        Books book = new Books("New Title", "New ISBN", 10); // Title, ISBN, and quantity
        booksList.add(book);
        bookService.writeBooksInFile(booksList, tempFile.getPath());
        ArrayList<Books> updatedBooksList = bookService.getBooks(tempFile.getPath());
        assertEquals(1, updatedBooksList.size());
        assertEquals("New Title", updatedBooksList.get(0).getTitle());
        assertEquals("New ISBN", updatedBooksList.get(0).getISBN());
        assertEquals(10, updatedBooksList.get(0).getQuanity());
    }



    @Test
    void testAddNullBookToEmptyFile() throws IOException {
        BookService bookService = new BookService();
        File tempFile = new File(tempFolder, "emptyBooks11.dat");
        tempFile.createNewFile();
        ArrayList<Books> booksList = new ArrayList<>();
        booksList.add(null);
        bookService.writeBooksInFile(booksList, tempFile.getPath());
        ArrayList<Books> updatedBooksList = bookService.getBooks(tempFile.getPath());
        assertTrue(updatedBooksList.isEmpty());
    }





//    @Test
//    void testWriteBooksInFileIOExceptionWhenBookIsNull() {
//        BookService bookService = new BookService();
//        ArrayList<Books> booksList = new ArrayList<>();
//        booksList.add(null);
//        assertThrows(IOException.class, () -> bookService.writeBooksInFile(booksList, "validPath"));
//    }

}