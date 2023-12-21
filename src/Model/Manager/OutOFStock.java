package Model.Manager;

import Model.Books.BookService;
import Model.Books.Zh_Books;

import java.util.ArrayList;

public class OutOFStock {

    private static BookService bookService = new BookService();
   public OutOFStock(BookService bookService)
   {
       this.bookService = bookService;
   }
    public static ArrayList<Zh_Books> checkIfOutOfStock(String path) {

//        path="src/EncodedInformation/Books.dat"

        ArrayList<Zh_Books> totalBooksFromFile = bookService.getBooks(path);
        ArrayList<Zh_Books> booksOutOfStock = new ArrayList<>();

        for (Zh_Books books : totalBooksFromFile) {

            if (books.getQuanity() < 5) {
                booksOutOfStock.add(books);
            }


        }
        return booksOutOfStock;
    }
}
