package Librarian;

import java.util.ArrayList;

public class BookService {
    static BookFunctionalities bookFunctionalities;
    private static final String path = "src/EncodedInformation/Books.dat";
    BookService(){

    }
    public BookService(BookFunctionalities bookFunctionalities){
        this.bookFunctionalities = bookFunctionalities;
    }
    public static ArrayList<Zh_Books> UpdateBook(Zh_Books bookupdate) {
        ArrayList<Zh_Books> books = bookFunctionalities.getBooks(path);
        for (int i=0;i<books.size();i++){
            if (books.get(i).getISBN().equals(bookupdate.getISBN())) {
                books.set(i, bookupdate);
            }
        }
        bookFunctionalities.writeBooksInFile(books);
        return books;
    }
}
