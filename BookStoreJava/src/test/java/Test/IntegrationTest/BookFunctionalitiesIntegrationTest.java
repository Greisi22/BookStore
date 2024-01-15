package Test.IntegrationTest;


import com.example.Model.Books.BookFunctionalities;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import org.junit.jupiter.api.AfterAll;
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
    public void cleanUp(){
        File[] files = tempFolder.listFiles();
        if(files!=null) {
            for(File f: files) {
                System.out.println(f.delete());
            }
        }
    }

    @AfterAll
    public static void deleteFolder(){
        System.out.println(tempFolder.delete());
    }
    @Test
    public void testUpdateBook() {

        ArrayList<Books> booksListt = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        booksListt.add(book1);
        booksListt.add(book2);

        BookService bookService = new BookService();
        bookService.writeBooksInFile(booksListt, tempFile.getPath());

        BookFunctionalities bookFunctionalities = new BookFunctionalities(bookService);
        Books books = new Books();
        books.setQuanity(3);
        books.setISBN("3");
        bookFunctionalities.setPath(tempFile.getPath());
        bookFunctionalities.UpdateBook(books);
        ArrayList<Books> updatedBooks = bookService.getBooks(tempFile.getPath());
        assertEquals( booksListt.size(), updatedBooks.size());
        if(updatedBooks.size()>0){
            assertEquals(updatedBooks.get(0).getQuanity(),books.getQuanity() );
        }

    }
}
