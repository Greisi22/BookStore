package Test.Manager;

import Mock.Books.BooksSreviceMock;
import Model.Bills.BillFunctionalitiess;
import Model.Bills.BillService;
import Model.Books.BookService;
import Model.Manager.OutOFStock;
import Test.Librarian.Books.Zh_Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Books_out_of_StockTest {

    @Test
    void outOfStockTest() {

        Zh_Books book = new Zh_Books();
        book.setQuanity(4);

        Zh_Books book1 = new Zh_Books();
        book1.setQuanity(7);


        ArrayList<Zh_Books> books = new ArrayList<>();


        books.add(book);
        books.add(book1);

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);


        OutOFStock outOFStock = new OutOFStock(booksServiceMock);

        ArrayList<Zh_Books> actual = outOFStock.checkIfOutOfStock("BookOutOfStock.dat");

        assertEquals(1,actual.size());





    }
}