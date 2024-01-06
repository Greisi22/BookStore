package Test.UnitTest.Manager;


import Mock.Books.BooksSreviceMock;
import com.example.Model.Books.Books;
import com.example.Model.Manager.OutOFStock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BooksOutOfStockTest {

    @Test
    void outOfStockTest() {
        Books book = new Books();
        book.setQuanity(4);
        Books book1 = new Books();
        book1.setQuanity(7);
        ArrayList<Books> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);
        OutOFStock outOFStock = new OutOFStock(booksServiceMock);
        ArrayList<Books> actual = outOFStock.checkIfOutOfStock("BookOutOfStock.dat");

        assertEquals(1,actual.size());





    }
}