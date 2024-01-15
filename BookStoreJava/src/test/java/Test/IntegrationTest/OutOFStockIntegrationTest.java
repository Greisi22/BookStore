package Test.IntegrationTest;

import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import com.example.Model.Manager.OutOFStock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutOFStockIntegrationTest {

    private static File tempFile;

    @TempDir
    static File tempFolder;

    @BeforeEach
    void createFile() {
        tempFile = new File(tempFolder, "testBooks.dat");
    }

    @AfterEach
    void destroyFile() {
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void outOfStock() {
        ArrayList<Books> booksList = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(5);
        booksList.add(book1);
        booksList.add(book2);

        BookService bookService = new BookService();
        bookService.writeBooksInFile(booksList, tempFile.getPath());

        OutOFStock outOFStock = new OutOFStock(bookService);
        ArrayList<Books> actual = outOFStock.checkIfOutOfStock(tempFile.getPath());

        assertEquals(1, actual.size());

    }
}
