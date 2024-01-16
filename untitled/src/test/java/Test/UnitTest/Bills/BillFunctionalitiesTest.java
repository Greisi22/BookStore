package Test.UnitTest.Bills;


import Mock.Books.BooksSreviceMock;
import com.example.Model.Bills.BillFunctionalitiess;
import com.example.Model.Books.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class BillFunctionalitiesTest {
    @Test
    void testBookInStock() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(books);
        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(booksSreviceMock);
        Books book = new Books();
        book.setISBN("3");
        boolean actual = billFunctionalitiess.checkOutOfStock(book);
        assertEquals(true, actual);
    }


    @Test
    void testBookOutOfStock() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(books);
        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(booksSreviceMock);
        Books book = new Books();
        book.setISBN("2");
        boolean actual = billFunctionalitiess.checkOutOfStock(book);
        assertEquals(false, actual);
    }

    @Test
    void testBookNotInList() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(books);
        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(booksSreviceMock);
        Books book = new Books();
        book.setISBN("5");
        boolean actual = billFunctionalitiess.checkOutOfStock(book);
        assertEquals(false, actual);
    }

    @Test
    void testEmptyBookList() {
        ArrayList<Books> books = new ArrayList<>();
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(books);
        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(booksSreviceMock);
        Books book = new Books();
        book.setISBN("1");
        boolean actual = billFunctionalitiess.checkOutOfStock(book);
        assertEquals(false, actual);
    }

    @Test
    void testNullInputBook() {
        ArrayList<Books> books = new ArrayList<>();
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(books);
        BillFunctionalitiess billFunctionalitiess = new BillFunctionalitiess(booksSreviceMock);
        boolean actual = billFunctionalitiess.checkOutOfStock(null);
        assertEquals(false, actual);
    }


    //........................................................................
    @Test
    void testPositivePrices() {
        Books b1 = new Books();
        b1.setPrice(1);
        Books b2 = new Books();
        b2.setPrice(1);
        double expectedTotal = 2.0;
        ArrayList<Books> selectedBooks = new ArrayList<>();
        selectedBooks.add(b1);
        selectedBooks.add(b2);
        double actual = BillFunctionalitiess.CalculateTotalPrice(selectedBooks);
        double delta = 0.001;
        assertEquals(expectedTotal, actual, delta);
    }

    @Test
    void testMixedPrices() {
        Books b1 = new Books();
        b1.setPrice(2);
        Books b2 = new Books();
        b2.setPrice(3);
        double expectedTotal = 5.0;
        ArrayList<Books> selectedBooks = new ArrayList<>();
        selectedBooks.add(b1);
        selectedBooks.add(b2);
        double actual = BillFunctionalitiess.CalculateTotalPrice(selectedBooks);
        double delta = 0.001;
        assertEquals(expectedTotal, actual, delta);
    }

    @Test
    void testZeroPrices() {
        Books b1 = new Books();
        b1.setPrice(0);
        Books b2 = new Books();
        b2.setPrice(0);
        double expectedTotal = 0.0;
        ArrayList<Books> selectedBooks = new ArrayList<>();
        selectedBooks.add(b1);
        selectedBooks.add(b2);
        double actual = BillFunctionalitiess.CalculateTotalPrice(selectedBooks);
        double delta = 0.001;
        assertEquals(expectedTotal, actual, delta);
    }

    @Test
    void testNegativePrices() {
        Books b1 = new Books();
        b1.setPrice(-1);
        Books b2 = new Books();
        b2.setPrice(1);
        double expectedTotal = 0.0;
        ArrayList<Books> selectedBooks = new ArrayList<>();
        selectedBooks.add(b1);
        selectedBooks.add(b2);
        double actual = BillFunctionalitiess.CalculateTotalPrice(selectedBooks);
        double delta = 0.001;
        assertEquals(expectedTotal, actual, delta);
    }

    @Test
    void testNegativeAndPositivePrices() {
        Books b1 = new Books();
        b1.setPrice(5);
        Books b2 = new Books();
        b2.setPrice(-2);
        double expectedTotal = 3.0;
        ArrayList<Books> selectedBooks = new ArrayList<>();
        selectedBooks.add(b1);
        selectedBooks.add(b2);
        double actual = BillFunctionalitiess.CalculateTotalPrice(selectedBooks);
        double delta = 0.001;
        assertEquals(expectedTotal, actual, delta);
    }



    //..........................................................................

    @Test
    void testGetBookNames() {
        ArrayList<Books> books = new ArrayList<>();
        Books b1 = new Books();
        b1.setTitle("A");
        Books b2 = new Books();
        b2.setTitle("B");
        books.add(b1);
        books.add(b2);
        ArrayList<String> result = BillFunctionalitiess.getBookNames(books);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "B"));
        assertEquals(expected, result);
    }

    @Test
    void testEmptyBookListForBookNames() {
        ArrayList<Books> emptyBooks = new ArrayList<>();
        ArrayList<String> result = BillFunctionalitiess.getBookNames(emptyBooks);
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, result);
    }

    @Test
    void testBooksWithNullTitle() {
        ArrayList<Books> booksWithNullTitle = new ArrayList<>();
        Books b1 = new Books();
        b1.setTitle(null);
        Books b2 = new Books();
        b2.setTitle("B");
        booksWithNullTitle.add(b1);
        booksWithNullTitle.add(b2);
        ArrayList<String> result = BillFunctionalitiess.getBookNames(booksWithNullTitle);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(null, "B"));
        assertEquals(expected, result);
    }

    @Test
    void testBooksWithEmptyTitle() {
        ArrayList<Books> booksWithEmptyTitle = new ArrayList<>();
        Books b1 = new Books();
        b1.setTitle("");
        Books b2 = new Books();
        b2.setTitle("B");
        booksWithEmptyTitle.add(b1);
        booksWithEmptyTitle.add(b2);
        ArrayList<String> result = BillFunctionalitiess.getBookNames(booksWithEmptyTitle);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("", "B"));
        assertEquals(expected, result);
    }

    @Test
    void testBooksWithSameTitles() {
        ArrayList<Books> booksWithSameTitles = new ArrayList<>();
        Books b1 = new Books();
        b1.setTitle("A");
        Books b2 = new Books();
        b2.setTitle("A");
        booksWithSameTitles.add(b1);
        booksWithSameTitles.add(b2);
        ArrayList<String> result = BillFunctionalitiess.getBookNames(booksWithSameTitles);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "A"));
        assertEquals(expected, result);
    }



    //...........................................................................

    @Test
    void testUpdateQuantityValidBookDecrease() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Books book = new Books();
        book.setISBN("3");
        book.setQuanity(2);

        Books actual = billFunctionalities.updateQuantity(book);

        Books expected = new Books();
        expected.setISBN("3");
        expected.setQuanity(1);
        assertEquals(expected, actual);
    }

    @Test
    void testUpdateQuantityZeroQuantity() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Books book = new Books();
        book.setISBN("2");
        book.setQuanity(0);

        Books actual = billFunctionalities.updateQuantity(book);

        assertEquals(null, actual);
    }

    @Test
    void testUpdateQuantityNonExistingBook() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Books book = new Books();
        book.setISBN("5");
        book.setQuanity(3);

        Books actual = billFunctionalities.updateQuantity(book);

        assertEquals(null, actual);
    }

    @Test
    void testUpdateQuantityNegativeQuantity() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Books book = new Books();
        book.setISBN("3");
        book.setQuanity(-1);

        Books actual = billFunctionalities.updateQuantity(book);

        assertEquals(null, actual);
    }

    @Test
    void testUpdateQuantityNullIsbn() {
        ArrayList<Books> books = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Books book = new Books();
        book.setISBN(null);
        book.setQuanity(5);

        Books actual = billFunctionalities.updateQuantity(book);

        assertEquals(null, actual);
    }



    @ParameterizedTest
    @CsvSource({

            "4,0,0,4",

    })
    void updateQuantityEmptyListTest(String isbn, int initialQuantity, int expectedQuantity,String Isbn) {

        ArrayList<Books> books = new ArrayList<>();

        System.out.println("lol");

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        BillFunctionalitiess billFunctionalities = new BillFunctionalitiess(booksServiceMock);

        Books book = new Books();
        book.setISBN(isbn);
        book.setQuanity(initialQuantity);

        Books actual = billFunctionalities.updateQuantity(book);

        Books expected = new Books();

        assertNull(actual);


    }




}