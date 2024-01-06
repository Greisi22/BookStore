package com.example.Model.Bills;



import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;

import java.util.ArrayList;

public class BillFunctionalitiess {

    static BookService bookService = new BookService();


    private static final String path = "src/main/java/com/example/EncodedInformation/Bills.dat";
    private static final String path1 = "src/main/java/com/example/EncodedInformation/Books.dat";

    public  BillFunctionalitiess()
    {

    }

    public BillFunctionalitiess( BookService bookService)
    {

        this.bookService = bookService;

    }



    public static boolean checkOutOfStock(Books book) {
        ArrayList<Books> booksFromFile = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");
        for(Books b:booksFromFile)
        {
            if(b.equals(book))
            {
                if (b.getQuanity()>0){
                    return true;
                }
                else {
                    return false;
                }
            }

        }
        return false;
    }


    public static double CalculateTotalPrice(ArrayList<Books> listBooks)
    {
        double totalPrice=0;
        for(Books books:listBooks)
        {
            totalPrice+=books.getPrice();
        }
        return totalPrice;
    }

    public static ArrayList<String> getBookNames(ArrayList<Books> books) {
        ArrayList<String> bookNames = new ArrayList<>();
        for (Books book : books) {
            bookNames.add(book.getTitle());
        }
        return bookNames;
    }

    public static Books updateQuantity(Books book)
    {
        ArrayList<Books> booksFromFile = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");
        for(Books b:booksFromFile)
        {
            if(b.equals(book))
            {
                if(book.getQuanity()<0 || book.getQuanity()-1<0){
                    return null;
                }
                book.setQuanity(book.getQuanity()-1);
                return book;
            }
        }
        return null;
    }
}
