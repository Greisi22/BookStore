package Test.Librarian.Bills;

import Librarian.BillFunctionalitiess;
import Librarian.Zh_Books;
import Mock.Books.BooksSreviceMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BillFunctionalitiesTest {


    @ParameterizedTest
    @CsvSource({
            "1,true",
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

//Mos harro negative prices, ose case  tjera pyte chatin ka than davidi
   @Test
    void calculateTest()
    {
        Zh_Books b1 = new Zh_Books();
        b1.setPrice(1);

        Zh_Books b2 = new Zh_Books();
        b2.setPrice(1);

        ArrayList<Zh_Books> selectedBooks = new ArrayList<>();

        selectedBooks.add(b1);
        selectedBooks.add(b2);

        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess();
       double actual = BillFunctionalitiess.CalculateTotalPrice(selectedBooks);


        double delta = 0.001;

        assertEquals(2.0, actual,delta);


    }

}
