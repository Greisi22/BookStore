package com.example.Model.Manager;



import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;

import java.util.ArrayList;

public class OutOFStock {

    private static BookService bookService = new BookService();
   public OutOFStock(BookService bookService)
   {
       this.bookService = bookService;
   }
    public static ArrayList<Books> checkIfOutOfStock(String path) {

        ArrayList<Books> totalBooksFromFile = bookService.getBooks(path);
        ArrayList<Books> booksOutOfStock = new ArrayList<>();

        for (Books books : totalBooksFromFile) {

            if (books.getQuanity() < 5) {
                booksOutOfStock.add(books);
            }


        }
        return booksOutOfStock;
    }
}
