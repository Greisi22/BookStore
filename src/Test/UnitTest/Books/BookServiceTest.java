package Test.UnitTest.Books;


import Mock.Books.BooksSreviceMock;
import Model.Books.BookFunctionalities;
import Model.Books.BookService;
import Model.Books.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {


    @TempDir
    static File tempFolder;


    @Test
    void testGetBooks() throws IOException {
        File tempFile = new File(tempFolder, "testBooks.dat");
        BookService bookService = new BookService();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            Books book1 = new Books("Book 1", "Author 1", 2023);
            Books book2 = new Books("Book 2", "Author 2", 2024);
            objectOutputStream.writeObject(book1);
            objectOutputStream.writeObject(book2);
        }

        ArrayList<Books> bookList = bookService.getBooks("testBooks.dat");
        assertEquals(2, bookList.size());
        assertEquals("Book 1", bookList.get(0).getTitle());
        assertEquals("Author 2", bookList.get(1).getISBN());
        assertEquals(2024, bookList.get(1).getQuanity());
    }

    @Test
    void testWriteInFIle() throws IOException {
        Books book1 = new Books("Book 1", "Author 1", 2023);
        Books book2 = new Books("Book 2", "Author 2", 2024);
        ArrayList<Books> booksList = new ArrayList<>();
        booksList.add(book1);
        booksList.add(book2);
        BookService bookService = new BookService();
        bookService.writeBooksInFile(booksList, "testBooks.dat");
        booksList.add(book1);
        booksList.add(book2);
        ArrayList<Books> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream("testBooks.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            Books obj = new Books();
            while (true) {
                obj = ((Books) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {

            assertEquals(list.size(), booksList.size());
        }


    }

    @Test
    void testGetBooks_ClassNotFoundException() {
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksSreviceMock);


        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            bookFunctionalities.setPath("JGCE");
        });


    }

}