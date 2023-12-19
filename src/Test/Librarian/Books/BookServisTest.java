package Test.Librarian.Books;

import Librarian.BookFunctionalities;
import Librarian.Zh_Books;
import Mock.Books.BooksSreviceMock;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;



class BookServisTest {




    @Test
    public void testUpdateBook() {
        ArrayList <Zh_Books> booksListt = new ArrayList<>();
        Zh_Books book1 = new Zh_Books();
        Zh_Books book2 = new Zh_Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        booksListt.add(book1);
        booksListt.add(book2);
        BookFunctionalities coverConstuctor = new BookFunctionalities();
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(booksListt);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksSreviceMock);
        Zh_Books books = new Zh_Books();
        books.setISBN("2");
        books.setQuanity(2);
        ArrayList<Zh_Books> updatedBooks =   bookFunctionalities.UpdateBook(books);
        assertEquals(updatedBooks.get(0).getQuanity(),books.getQuanity() );
    }


    @Test
    public void testUpdateBookWhereBookDoesNotExist() {
        ArrayList <Zh_Books> booksListt = new ArrayList<>();
        Zh_Books book1 = new Zh_Books();
        Zh_Books book2 = new Zh_Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        booksListt.add(book1);
        booksListt.add(book2);
        BookFunctionalities coverConstuctor = new BookFunctionalities();
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(booksListt);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksSreviceMock);
        Zh_Books books = new Zh_Books();
        books.setISBN("1");
        books.setQuanity(2);
        ArrayList<Zh_Books> updatedBooks =   bookFunctionalities.UpdateBook(books);
        assertEquals(updatedBooks.get(0).getQuanity(),books.getQuanity() );
    }

    @Test
    public void testUpdateBookFileEmpty() {
        ArrayList <Zh_Books> booksListt = new ArrayList<>();
        BookFunctionalities coverConstuctor = new BookFunctionalities();
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(booksListt);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksSreviceMock);
        Zh_Books books = new Zh_Books();
        books.setISBN("1");
        books.setQuanity(2);
        ArrayList<Zh_Books> updatedBooks =   bookFunctionalities.UpdateBook(books);
        assertTrue(updatedBooks.isEmpty());
    }





}