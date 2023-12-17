package Test.Librarian.Bills;

import Librarian.BillFunctionalitiess;
import Librarian.Zh_Books;
import Mock.Books.BooksSreviceMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class BillFunctionalitiesTest {


    @ParameterizedTest
    @CsvSource({
            "3,true",
            "2,false"

    })
    void checkQuantityTest(String ISBN, boolean expected) {

        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();

        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(booksSreviceMock);

        Zh_Books book = new Zh_Books();
        book.setISBN(ISBN);

        boolean actual = BillFunctionalitiess.checkOutOfStock(book);

        assertEquals(actual,expected);


    }


@ParameterizedTest
@CsvSource({
        "1, 1, 2.0",
        "2, 3, 5.0",
        "0, 0, 0.0",
        "-1, 1, 0.0",
        "5, -2, 3.0"
})
void calculateTest(int price1, int price2, double expectedTotal) {
    Zh_Books b1 = new Zh_Books();
    b1.setPrice(price1);

    Zh_Books b2 = new Zh_Books();
    b2.setPrice(price2);

    ArrayList<Zh_Books> selectedBooks = new ArrayList<>();
    selectedBooks.add(b1);
    selectedBooks.add(b2);

    double actual = BillFunctionalitiess.CalculateTotalPrice(selectedBooks);

    double delta = 0.001;

    assertEquals(expectedTotal, actual, delta);
}



    @Test
    void getBookNamesTest()
    {

        ArrayList<Zh_Books> books = new ArrayList<>();

        Zh_Books b1 = new Zh_Books();
        b1.setTitle("A");

        Zh_Books b2 = new Zh_Books();
        b2.setTitle("B");

        books.add(b1);
        books.add(b2);

        ArrayList<String> result = BillFunctionalitiess.getBookNames(books);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "B"));
        assertEquals(expected,result);
    }


    @ParameterizedTest
    @CsvSource({

            "3, 2, 1,3",
            "4, 0,0,4"
    })
    void updateQuantityTest(String isbn, Integer initialQuantity, Integer expectedQuantity,String Isbn) {
        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Zh_Books book = new Zh_Books();
        book.setISBN(isbn);
        book.setQuanity(initialQuantity);

        Zh_Books actual = billFunctionalities.updateQuantity(book);

        Zh_Books expected = new Zh_Books();
        expected.setISBN(Isbn);
        expected.setQuanity(expectedQuantity);

        assertEquals(expected, actual);
    }



}





