package Test.UnitTest.Manager;

import Mock.Books.BooksSreviceMock;
import Model.Books.Zh_Books;
import Model.Manager.OutOFStock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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