package Test.UnitTest.Books;


import Mock.Books.BooksSreviceMock;
import com.example.Model.Books.BookFunctionalities;
import com.example.Model.Books.Books;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



class BookFunctionalitiesTest {


    @Test
    public void testUpdateExistingBook() {
        ArrayList<Books> booksList = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        booksList.add(book1);
        booksList.add(book2);
        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(booksList);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksServiceMock);
        Books bookToUpdate = new Books();
        bookToUpdate.setISBN("2");
        bookToUpdate.setQuanity(5);
        ArrayList<Books> updatedBooks = bookFunctionalities.UpdateBook(bookToUpdate);
        assertEquals(5, updatedBooks.get(1).getQuanity());
    }


    @Test
    public void testUpdateBookWhereBookDoesNotExist() {
        ArrayList<Books> booksList = new ArrayList<>();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        book2.setISBN("2");
        book2.setQuanity(0);
        booksList.add(book1);
        booksList.add(book2);
        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(booksList);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksServiceMock);
        Books bookToUpdate = new Books();
        bookToUpdate.setISBN("1");
        bookToUpdate.setQuanity(5);
        ArrayList<Books> updatedBooks = bookFunctionalities.UpdateBook(bookToUpdate);
        assertEquals(2, updatedBooks.size());
    }

    @Test
    public void testUpdateBookFileEmpty() {
        ArrayList<Books> booksList = new ArrayList<>();
        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(booksList);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksServiceMock);
        Books bookToUpdate = new Books();
        bookToUpdate.setISBN("1");
        bookToUpdate.setQuanity(5);
        ArrayList<Books> updatedBooks = bookFunctionalities.UpdateBook(bookToUpdate);
        assertTrue(updatedBooks.isEmpty());
    }

    @Test
    public void testUpdateBookWithNullInput() {
        ArrayList<Books> booksList = new ArrayList<>();
        Books book1 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        booksList.add(book1);
        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(booksList);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksServiceMock);
        ArrayList<Books> updatedBooks = bookFunctionalities.UpdateBook(null);
        assertEquals(1, updatedBooks.size());
    }

    @Test
    public void testUpdateBookWithSingleBookInList() {
        ArrayList<Books> booksList = new ArrayList<>();
        Books book1 = new Books();
        book1.setISBN("3");
        book1.setQuanity(2);
        booksList.add(book1);
        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(booksList);
        BookFunctionalities bookFunctionalities = new BookFunctionalities(booksServiceMock);
        Books bookToUpdate = new Books();
        bookToUpdate.setISBN("3");
        bookToUpdate.setQuanity(5);
        ArrayList<Books> updatedBooks = bookFunctionalities.UpdateBook(bookToUpdate);
        assertEquals(5, updatedBooks.get(0).getQuanity());
    }



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








}