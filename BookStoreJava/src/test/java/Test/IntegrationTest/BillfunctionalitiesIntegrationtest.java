package Test.IntegrationTest;

import com.example.Model.Bills.BillFunctionalitiess;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

     BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess();
     Books book3 = new Books();
     book3 = book2;
     boolean actual = billFunctionalitiess.checkOutOfStock(book3);
     assertEquals(actual,false);

 }

 @Test
    void calcuateTotalCost()
 {
     ArrayList<Books> booksListt = new ArrayList<>();
     Books book1 = new Books();
     Books book2 = new Books();
     book1.setISBN("3");
     book1.setQuanity(2);
     book1.setPrice(12);
     book2.setISBN("2");
     book2.setQuanity(0);
     book2.setPrice(12);
     booksListt.add(book1);
     booksListt.add(book2);


     BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess();
     double actual=billFunctionalitiess.CalculateTotalPrice(booksListt);
     assertEquals(actual,24);
 }
}
