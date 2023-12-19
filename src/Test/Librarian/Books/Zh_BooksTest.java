package Test.Librarian.Books;

import Librarian.Gender;
import Librarian.V_Author;
import Librarian.Zh_Books;
import Librarian.Zh_MyDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Zh_BooksTest {

    @ParameterizedTest
    @CsvSource({
            "2, 3, 2000, 2, 3, 2000",
            "5, 10, 2022, 5, 10, 2022",
    })
    void getDate(int initialMonth, int initialDay, int initialYear, String expectedMonth, String expectedDay, String expectedYear) {
        Zh_Books book = new Zh_Books();
        book.setDate(new Zh_MyDate(initialMonth, initialDay, initialYear));
        Zh_MyDate actual = book.getDate();

        Zh_MyDate expected = null;
        if (!expectedMonth.isEmpty() && !expectedDay.isEmpty() && !expectedYear.isEmpty()) {
            expected = new Zh_MyDate(Integer.parseInt(expectedMonth), Integer.parseInt(expectedDay), Integer.parseInt(expectedYear));
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 2000, 2, 3, 2000",
            "5, 10, 2022, 5, 10, 2022",
    })
    void setDate(int initialMonth, int initialDay, int initialYear, String expectedMonth, String expectedDay, String expectedYear) {

        Zh_Books book = new Zh_Books();
        book.setDate(new Zh_MyDate(initialMonth, initialDay, initialYear));
        assertEquals(book.getDate(), new Zh_MyDate(initialMonth, initialDay, initialYear));
    }

    @Test
    void getGenresS() {
    }

    @Test
    void setGenresS() {
    }

    @Test
    void getISBN() {

        Zh_Books book = new Zh_Books();
        book.setISBN("1");
        String actual = book.getISBN();
        assertEquals("1",actual);
    }

    @Test
    void setISBN() {

    }

    @Test
    void getTitle() {
        Zh_Books book = new Zh_Books();
        book.setTitle("Ok");
        String actual = book.getTitle();
        assertEquals("Ok",actual);
    }

    @Test
    void setTitle() {
    }

    @Test
    void getDescription() {
        Zh_Books book = new Zh_Books();
        book.setDescription("Ok");
        String actual = book.getDescription();
        assertEquals("Ok",actual);
    }

    @Test
    void setDescription() {
    }

    @Test
    void getPrice() {
        Zh_Books book = new Zh_Books();
        book.setPrice(25.0);
        double actual = book.getPrice();
        assertEquals(25.0,actual);
    }

    @Test
    void setPrice() {
    }

    @Test
    void getAuthor() {

    }

    @Test
    void setAuthor() {

    }

    @Test
    void getGenres() {
    }

    @Test
    void setGenres() {
    }

    @Test
    void isPaperback() {
    }

    @Test
    void setPaperback() {
    }

    @Test
    void getQuanity() {
    }

    @Test
    void setQuanity() {
    }

    @Test
    void getSerialversionuid() {
    }

    @Test
    void addGenres() {
    }

    @Test
    void testToString() {
    }
}