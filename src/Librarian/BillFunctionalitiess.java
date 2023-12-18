package Librarian;

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



    public static boolean checkOutOfStock(Zh_Books book) {


        ArrayList<Zh_Books> booksFromFile = bookService.getBooks("src/EncodedInformation/Books.dat");

        for(Zh_Books b:booksFromFile)
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


    public static double CalculateTotalPrice(ArrayList<Zh_Books> listBooks)
    {
        double totalPrice=0;

        for(Zh_Books books:listBooks)
        {
            totalPrice+=books.getPrice();
        }
        return totalPrice;
    }

    public static ArrayList<String> getBookNames(ArrayList<Zh_Books> books) {


        ArrayList<String> bookNames = new ArrayList<>();

        for (Zh_Books book : books) {
            bookNames.add(book.getTitle());
        }
        return bookNames;
    }

    public static Zh_Books updateQuantity(Zh_Books book)
    {

        ArrayList<Zh_Books> booksFromFile = bookService.getBooks("src/EncodedInformation/Books.dat");

        for(Zh_Books b:booksFromFile)
        {
            if(b.equals(book))
            {
                book.setQuanity(book.getQuanity()-1);
                return book;
            }
            else{
                return book;
            }
        }

       return null;
    }
}
