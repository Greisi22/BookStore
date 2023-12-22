package Model.Bills;

import Model.Books.BookService;
import Model.Books.Books;

import java.util.ArrayList;

public class BillFunctionalitiess {

    static BookService bookService = new BookService();


    private static final String path = "src/EncodedInformation/Bills.dat";
    private static final String path1 = "src/EncodedInformation/Books.dat";

    public  BillFunctionalitiess()
    {

    }

    public BillFunctionalitiess( BookService bookService)
    {

        this.bookService = bookService;

    }



    public static boolean checkOutOfStock(Books book) {


        ArrayList<Books> booksFromFile = bookService.getBooks("src/EncodedInformation/Books.dat");

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

        ArrayList<Books> booksFromFile = bookService.getBooks("src/EncodedInformation/Books.dat");

        for(Books b:booksFromFile)
        {


            if(b.equals(book))
            {

                book.setQuanity(book.getQuanity()-1);

                return book;
            }

        }

        return null;
    }
}
