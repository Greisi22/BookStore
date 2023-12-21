package Test.UnitTest.Books;

import Model.Bills.Zh_MyDate;
import Model.Books.V_Author;
import Model.Books.Zh_Books;
import Model.Books.Zh_Genre;
import Model.Users.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void getGenres(){
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
    void constructerTest() {
        Zh_Books book = new Zh_Books();
        book.setTitle("SWE");
        book.setISBN("1");
        book.setQuanity(5);

        assertEquals(new Zh_Books("SWE","1",5),book);

    }

    @Test
    void constructerTest1(){
        Zh_Books book = new Zh_Books();
        Gender gender = Gender.Female;
        book.setTitle("A");
        book.setISBN("1");
        book.setQuanity(5);
        book.setDescription("B");
        book.setPrice(25.0);
        book.setAuthor(new V_Author("Era","Mulla",gender));
        book.setPaperback(true);
        assertEquals(new Zh_Books("A","1",5,"B",25.0,new V_Author("Era","Mulla",gender), true ),book);

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
    void getGENRES(){
        Zh_Books book = new Zh_Books();
        Zh_Genre g1 = Zh_Genre.ACTION;
        Zh_Genre g2 = Zh_Genre.FANTASY;
        Zh_Genre g3 = Zh_Genre.MYSTRERY;
        ArrayList<Zh_Genre> genres = new ArrayList<>();
        genres.add(g1);
        genres.add(g2);
        genres.add(g3);
        book.setGenres(genres);
        String actual = book.getGenresS();
        assertEquals("ACTION FANTASY MYSTRERY ",actual);

   }


    @Test
    void getGenresSTest() {
        Zh_Books book = new Zh_Books();

        ArrayList<Zh_Genre> genres = new ArrayList<>();
        genres.add(Zh_Genre.ACTION);
        genres.add(Zh_Genre.FANTASY);

        book.setGenres(genres);

        String result = book.getGenresS();

        String expected = "ACTION FANTASY ";

        assertEquals(expected, result);
    }


    @Test
    void setGenresSTest() {

        ArrayList<String> list = new ArrayList<>();

        ArrayList<Zh_Genre> genres = new ArrayList<>();

        Zh_Genre g1 = Zh_Genre.ACTION;
        Zh_Genre g2 = Zh_Genre.FANTASY;

        genres.add(g1);
        genres.add(g2);

        Zh_Books books = new Zh_Books();
        books.setGenresS("ACTION FANTASY");

        assertEquals(books.getGenres().get(0), g1);

    }


    }




