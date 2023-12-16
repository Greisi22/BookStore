package Mock.Books;

import Librarian.BookService;
import Librarian.Zh_Books;

import java.util.ArrayList;

public class BooksSreviceMock extends BookService {
    @Override
    public  <E> ArrayList<E> getBooks(String path) {
        ArrayList<Zh_Books> books = new ArrayList<>();
        Zh_Books book1 = new Zh_Books();
        Zh_Books book2 = new Zh_Books();
        book1.setISBN("1");
        book1.setQuanity(1);
        book2.setISBN("2");
        book2.setQuanity(0);
        books.add(book1);
        books.add(book2);

        return (ArrayList<E>) books;
    }
    @Override
    public  void writeBooksInFile(ArrayList<Zh_Books> newBooks1) {

    }

}
