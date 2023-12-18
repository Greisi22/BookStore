package Test.Librarian.Books;

import Librarian.BookService;
import Librarian.Zh_Books;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {
    @TempDir
    static File tempFolder;

    @AfterEach
    void cleanup() {
        tempFolder.delete();
    }
    @Test
    void gitestGetBooks() throws IOException {
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

}
