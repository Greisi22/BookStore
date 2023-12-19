package Test.Librarian.Bills;

import Model.Bills.BillFunctionalitiess;
import Model.Books.BookService;
import Librarian.Zh_Books;
import Mock.Books.BooksSreviceMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BillFunctionalitiesTest {


    @ParameterizedTest
    @CsvSource({
            "3,true",
            "2,false",
            "5,false"

    })
    void checkQuantityTest(String ISBN, boolean expected) {

        BillFunctionalitiess Just_To_Test_Constructor = new BillFunctionalitiess();
        ArrayList<Zh_Books> books = new ArrayList<>();
        Zh_Books book1 = new Zh_Books();
        Zh_Books book2 = new Zh_Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);

        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();

        booksSreviceMock.setBooks(books);

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

            "3,2,1,3",

    })
    void updateQuantityTest(String isbn, int initialQuantity, int expectedQuantity,String Isbn) {

        ArrayList<Zh_Books> books = new ArrayList<>();
        Zh_Books book1 = new Zh_Books();
        Zh_Books book2 = new Zh_Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);


        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Zh_Books book = new Zh_Books();
        book.setISBN(isbn);
        book.setQuanity(initialQuantity);

        Zh_Books actual = billFunctionalities.updateQuantity(book);

        Zh_Books expected = new Zh_Books();
        if(actual == null){
            assertEquals(expected, null);
        }
        else{
            expected.setISBN(Isbn);
            expected.setQuanity(expectedQuantity);
            assertEquals(expected, actual);
        }

    }


    @ParameterizedTest
    @CsvSource({

            "4,0,0,4",

    })
    void updateQuantityEmptyListTest(String isbn, int initialQuantity, int expectedQuantity,String Isbn) {

        ArrayList<Zh_Books> books = new ArrayList<>();



        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Zh_Books book = new Zh_Books();
        book.setISBN(isbn);
        book.setQuanity(initialQuantity);

        Zh_Books actual = billFunctionalities.updateQuantity(book);

        Zh_Books expected = new Zh_Books();

            assertNull(actual);


    }

    @Test
    void Prova()
    {
        BookService bookService = new BookService();
        ArrayList<Zh_Books> books = bookService.getBooks( "src/EncodedInformation/Books.dat");
        for(Zh_Books books1:books)
        {
            System.out.println(books1.getTitle());
        }
    }


}





