package Test.Librarian.Books;

import Librarian.Zh_MyDate;
import Librarian.Gender;
import Librarian.V_Author;
import Librarian.Zh_Books;
import Librarian.Zh_Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;


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
    void getGenresS(){
        ArrayList<Zh_Genre> genres = new ArrayList<>();
        genres.add(Zh_Genre.FANTASY);
        genres.add(Zh_Genre.ACTION);
        Zh_Books book = new Zh_Books();
        book.setGenres(genres);
        ArrayList<Zh_Genre> genres1 = book.getGenres();
        assertEquals(genres.size(),genres1.size() );
        assertEquals(genres.get(0),genres1.get(0));
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
        V_Author author = new V_Author("Era","Mulla", Gender.Female);
        Zh_Books book = new Zh_Books();
        book.setAuthor(author);
        V_Author author1 = book.getAuthor();
        assertEquals(author.getFirstName(),author1.getFirstName());

    }

    @Test
    void setAuthor() {

    }


   @ParameterizedTest
   @CsvSource ({
           "true,true",
           "false,false"

   })
    void isPaperback(boolean actual,boolean expected) {
        Zh_Books book = new Zh_Books();
        book.setPaperback(actual);
        actual = book.isPaperback();
        assertEquals(expected,actual);



    }

    @Test
    void setPaperback() {
    }

    @Test
    void getQuanity() {
        Zh_Books book= new Zh_Books();
        book.setQuanity(3);
        int actual=book.getQuanity();
        assertEquals(3,actual);
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