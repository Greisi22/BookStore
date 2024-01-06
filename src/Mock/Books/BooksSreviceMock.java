package Mock.Books;

import Model.Books.BookService;
import Model.Books.Books;

import java.util.ArrayList;

public class BooksSreviceMock extends BookService {
    private ArrayList<Books>books;
    public String path;
@Override
    public  <E> ArrayList<E> getBooks(String path) {

        return (ArrayList<E>) books;
    }
    @Override
    public  void writeBooksInFile(ArrayList<Books> newBooks1, String path) {

    }

    public void setBooks(ArrayList<Books>books){
    this.books = books;
    }
    public void setPath( String path){
        this.path = path;
    }
    public String getPath(){
       return path;
    }

}