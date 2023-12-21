package Test.Books;


import Model.Books.BookService;
import Model.Books.Zh_Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {


    @TempDir
    static File tempFolder;


    @Test
    void testGetBooks() throws IOException {
        File tempFile = new File(tempFolder, "testBooks.dat");
        BookService bookService = new BookService();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            Zh_Books book1 = new Zh_Books("Book 1", "Author 1", 2023);
            Zh_Books book2 = new Zh_Books("Book 2", "Author 2", 2024);
            objectOutputStream.writeObject(book1);
            objectOutputStream.writeObject(book2);
        }

        ArrayList<Zh_Books> bookList = bookService.getBooks("testBooks.dat");
        assertEquals(2, bookList.size());
        assertEquals("Book 1", bookList.get(0).getTitle());
        assertEquals("Author 2", bookList.get(1).getISBN());
        assertEquals(2024, bookList.get(1).getQuanity());
    }

    @Test
    void testWriteInFIle() throws IOException {
        Zh_Books book1 = new Zh_Books("Book 1", "Author 1", 2023);
        Zh_Books book2 = new Zh_Books("Book 2", "Author 2", 2024);
        ArrayList<Zh_Books> booksList = new ArrayList<>();
        booksList.add(book1);
        booksList.add(book2);
        BookService bookService = new BookService();
        bookService.writeBooksInFile(booksList, "testBooks.dat");
        booksList.add(book1);
        booksList.add(book2);
        ArrayList<Zh_Books> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream("testBooks.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            Zh_Books obj = new Zh_Books();
            while (true) {
                obj = ((Zh_Books) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {

            assertEquals(list.size(), booksList.size());
        }


    }

}