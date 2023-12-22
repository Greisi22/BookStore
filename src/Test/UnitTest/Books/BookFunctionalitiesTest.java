package Test.UnitTest.Books;

import Mock.Books.BooksSreviceMock;
import Model.Books.BookFunctionalities;
import Model.Books.Books;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



class BookFunctionalitiesTest {




    @Test
    public void testUpdateBook() {
        ArrayList <Books> booksListt = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
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
        Books books = new Books();
        books.setISBN("2");
        books.setQuanity(2);
        ArrayList<Books> updatedBooks =   bookFunctionalities.UpdateBook(books);
        assertEquals(updatedBooks.get(0).getQuanity(),books.getQuanity() );
    }


    @Test
    public void testUpdateBookWhereBookDoesNotExist() {
        ArrayList <Books> booksListt = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
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
        Books books = new Books();
        books.setISBN("1");
        books.setQuanity(2);
        ArrayList<Books> updatedBooks =   bookFunctionalities.UpdateBook(books);
        assertEquals(updatedBooks.get(0).getQuanity(),books.getQuanity() );
    }

    @Test
    public void testUpdateBookFileEmpty() {
        ArrayList <Books> booksListt = new ArrayList<>();
        BookFunctionalities coverConstuctor = new BookFunctionalities();
        BooksSreviceMock booksSreviceMock = new BooksSreviceMock();
        booksSreviceMock.setBooks(booksListt);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksSreviceMock);
        Books books = new Books();
        books.setISBN("1");
        books.setQuanity(2);
        ArrayList<Books> updatedBooks =   bookFunctionalities.UpdateBook(books);
        assertTrue(updatedBooks.isEmpty());
    }





}