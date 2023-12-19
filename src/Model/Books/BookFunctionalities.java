package Model.Books;

import Test.Librarian.Books.Zh_Books;

import java.util.ArrayList;

public class BookFunctionalities {



    static BookService bookService = new BookService();

    private static String path = "src/EncodedInformation/Books.dat";
    public BookFunctionalities(){

    }
    public BookFunctionalities(BookService bookService){
        this.bookService = bookService;
    }
    public  static  ArrayList<Zh_Books> UpdateBook(Zh_Books bookupdate) {


        ArrayList<Zh_Books> books = bookService.getBooks(path);
        for (int i=0;i<books.size();i++){
            if (books.get(i).getISBN().equals(bookupdate.getISBN())) {
                books.set(i, bookupdate);
            }
        }
        bookService.writeBooksInFile(books, path);
        return books;
    }


}
