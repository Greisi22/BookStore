package Test.IntegrationTest;

import com.example.Model.Bills.BillFunctionalitiess;
import com.example.Model.Books.BookFunctionalities;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BillfunctionalitiesIntegrationtest {

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
    public void checkOutOfStock()
    {
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


        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(bookService);
        billFunctionalitiess.setPath(tempFile.getPath());

        Books books = new Books();
        books.setQuanity(2);
        books.setISBN("3");

        boolean actual = BillFunctionalitiess.checkOutOfStock(books);


        ArrayList<Books> booksFromFile = bookService.getBooks(tempFile.getPath());
        assertEquals( booksListt.size(), booksFromFile.size());

        if(booksFromFile.size()>0){
            assertEquals(true,actual);
        }
    }



    @Test
    void updateQuantity() {
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

        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(bookService);
        billFunctionalitiess.setPath(tempFile.getPath());

        Books books = new Books();
        books.setQuanity(2);
        books.setISBN("3");

        Books book4 = BillFunctionalitiess.updateQuantity(books);
        int actual = book4.getQuanity();

        ArrayList<Books> booksFromFile = bookService.getBooks(tempFile.getPath());
        assertEquals( booksListt.size(), booksFromFile.size());

        if(booksFromFile.size()>0){
            assertEquals(booksFromFile.get(0).getQuanity()-1,actual );
        }

    }

}
