package Mock.Bills;

import Librarian.BookService;
import Librarian.Zh_Books;

import java.util.ArrayList;

public class BillServiceMock extends BookService {

    @Override
    public <E> ArrayList<E> getBooks(String path){


        Zh_Books b1 = new Zh_Books();
        Zh_Books b2 = new Zh_Books();

        b1.setISBN("11");
        b1.setQuanity(20);

        b2.setISBN("22");
        b2.setQuanity(21);

        ArrayList<Zh_Books> mockList = new ArrayList<>();

        mockList.add(b1);
        mockList.add(b2);

        return (ArrayList<E>) mockList;
    }
}
