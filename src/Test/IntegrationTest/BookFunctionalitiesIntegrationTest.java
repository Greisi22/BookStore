package Test.IntegrationTest;

import Mock.Books.BooksSreviceMock;
import Model.Books.BookFunctionalities;
import Model.Books.BookService;
import Model.Books.Zh_Books;
import Model.Users.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookFunctionalitiesIntegrationTest {
    private static File tempFile;
    private String path = "src/EncodedInformation/Books.dat";

    @TempDir
    static File tempFolder;

    @BeforeEach
    void createFile() {
        tempFile = new File(tempFolder, "testUsers.dat");
    }

    @AfterEach
    void destroyFile() {
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }
    @Test
    public void testUpdateBook() {

        ArrayList<Zh_Books> booksListt = new ArrayList<>();
        Zh_Books book1 = new Zh_Books();
        Zh_Books book2 = new Zh_Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        booksListt.add(book1);
        booksListt.add(book2);

        BookService bookService = new BookService();
        bookService.writeBooksInFile(booksListt, tempFile.getPath());

        BookFunctionalities bookFunctionalities = new BookFunctionalities(bookService);
        Zh_Books books = new Zh_Books();
        books.setQuanity(3);
        books.setISBN("3");
        bookFunctionalities.setPath(tempFile.getPath());
        bookFunctionalities.UpdateBook(books);
        ArrayList<Zh_Books> updatedBooks = bookService.getBooks(tempFile.getPath());
        assertEquals( booksListt.size(), updatedBooks.size());
        if(updatedBooks.size()>0){
            assertEquals(updatedBooks.get(0).getQuanity(),books.getQuanity() );
        }

    }
}
