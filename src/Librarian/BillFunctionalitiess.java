package Librarian;

import java.util.ArrayList;

public class BillFunctionalitiess {

    static BillService billFunctionalities;


    private static final String path = "src/EncodedInformation/Bills.dat";


    public BillFunctionalitiess(BillService billFunctionalities)
    {
        this.billFunctionalities = billFunctionalities;
    }



    public static boolean checkOutOfStock(Zh_Books book) {

        ArrayList<Zh_Books> booksFromFile = BillService.getBillsFromFile(path);
        if (book.getQuanity()>0){
            return true;
        }
        else {
            return false;
        }
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

    private static Zh_Books updateQuantity(Zh_Books book)
    {
        book.setQuanity(book.getQuanity()-1);
        return book;
    }
}
