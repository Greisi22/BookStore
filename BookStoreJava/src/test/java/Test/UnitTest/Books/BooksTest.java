package Test.UnitTest.Books;


import com.example.Model.Bills.MyDate;
import com.example.Model.Books.Author;
import com.example.Model.Books.Books;
import com.example.Model.Books.Genre;
import com.example.Model.Userss.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    @ParameterizedTest
    @CsvSource({
            "2, 3, 2000, 2, 3, 2000",
            "5, 10, 2022, 5, 10, 2022",
    })
    void getDate(int initialMonth, int initialDay, int initialYear, String expectedMonth, String expectedDay, String expectedYear) {
        Books book = new Books();
        book.setDate(new MyDate(initialMonth, initialDay, initialYear));
        MyDate actual = book.getDate();

        MyDate expected = null;
        if (!expectedMonth.isEmpty() && !expectedDay.isEmpty() && !expectedYear.isEmpty()) {
            expected = new MyDate(Integer.parseInt(expectedMonth), Integer.parseInt(expectedDay), Integer.parseInt(expectedYear));
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 2000, 2, 3, 2000",
            "5, 10, 2022, 5, 10, 2022",
    })
    void setDate(int initialMonth, int initialDay, int initialYear, String expectedMonth, String expectedDay, String expectedYear) {

        Books book = new Books();
        book.setDate(new MyDate(initialMonth, initialDay, initialYear));
        assertEquals(book.getDate(), new MyDate(initialMonth, initialDay, initialYear));
    }

    @Test
    void getGenres(){
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(Genre.FANTASY);
        genres.add(Genre.ACTION);
        Books book = new Books();
        book.setGenres(genres);
        ArrayList<Genre> genres1 = book.getGenres();
        assertEquals(genres.size(),genres1.size() );
        assertEquals(genres.get(0),genres1.get(0));
    }



    @Test
    void getISBN() {

        Books book = new Books();
        book.setISBN("1");
        String actual = book.getISBN();
        assertEquals("1",actual);
    }


    @Test
    void getTitle() {
        Books book = new Books();
        book.setTitle("Ok");
        String actual = book.getTitle();
        assertEquals("Ok",actual);
    }


    @Test
    void getDescription() {
        Books book = new Books();
        book.setDescription("Ok");
        String actual = book.getDescription();
        assertEquals("Ok",actual);
    }


    @Test
    void getPrice() {
        Books book = new Books();
        book.setPrice(25.0);
        double actual = book.getPrice();
        assertEquals(25.0,actual);
    }



    @Test
    void getAuthor() {
        Author author = new Author("Era","Mulla", Gender.Female);
        Books book = new Books();
        book.setAuthor(author);
        Author author1 = book.getAuthor();
        assertEquals(author.getFirstName(),author1.getFirstName());

    }

    @Test
    void constructerTest() {
        Books book = new Books();
        book.setTitle("SWE");
        book.setISBN("1");
        book.setQuanity(5);

        assertEquals(new Books("SWE","1",5),book);

    }

    @Test
    void constructerTest1(){
        Books book = new Books();
        Gender gender = Gender.Female;
        book.setTitle("A");
        book.setISBN("1");
        book.setQuanity(5);
        book.setDescription("B");
        book.setPrice(25.0);
        book.setAuthor(new Author("Era","Mulla",gender));
        book.setPaperback(true);
        assertEquals(new Books("A","1",5,"B",25.0,new Author("Era","Mulla",gender), true ),book);

    }


   @ParameterizedTest
   @CsvSource ({
           "true,true",
           "false,false"

   })
    void isPaperback(boolean actual,boolean expected) {
        Books book = new Books();
        book.setPaperback(actual);
        actual = book.isPaperback();
        assertEquals(expected,actual);



    }


    @Test
    void getQuanity() {
        Books book= new Books();
        book.setQuanity(3);
        int actual=book.getQuanity();
        assertEquals(3,actual);
    }

   @Test
    void getGENRES(){
        Books book = new Books();
        Genre g1 = Genre.ACTION;
        Genre g2 = Genre.FANTASY;
        Genre g3 = Genre.MYSTRERY;
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(g1);
        genres.add(g2);
        genres.add(g3);
        book.setGenres(genres);
        String actual = book.getGenresS();
        assertEquals("ACTION FANTASY MYSTRERY ",actual);

   }


    @Test
    void getGenresSTest() {
        Books book = new Books();

        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);
        genres.add(Genre.FANTASY);

        book.setGenres(genres);

        String result = book.getGenresS();

        String expected = "ACTION FANTASY ";

        assertEquals(expected, result);
    }


    @Test
    void setGenresSTest() {

        ArrayList<String> list = new ArrayList<>();

        ArrayList<Genre> genres = new ArrayList<>();

        Genre g1 = Genre.ACTION;
        Genre g2 = Genre.FANTASY;

        genres.add(g1);
        genres.add(g2);

        Books books = new Books();
        books.setGenresS("ACTION FANTASY");

        assertEquals(books.getGenres().get(0), g1);

    }



    @Test
    void testEqualMethod() {
        Books book1 = new Books();

        assertTrue(book1.equals(book1));
        assertFalse(book1.equals(null));
    }



}




