package Mock.Books;

import Librarian.BookService;
import Librarian.Zh_Books;

import java.util.ArrayList;

public class BooksSreviceMock extends BookService {
    private ArrayList<Zh_Books>books;
    public String path;
@Override
    public  <E> ArrayList<E> getBooks(String path) {


        return (ArrayList<E>) books;
    }
    @Override
    public  void writeBooksInFile(ArrayList<Zh_Books> newBooks1, String path) {

    }

    public void setBooks(ArrayList<Zh_Books>books){
    this.books = books;
    }
    public void setPath( String path){
        this.path = path;
    }
    public String getPath(){
       return path;
    }

}