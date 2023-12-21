package Model.Statistic;

import Model.Bills.Bill;
import Model.Bills.BillService;
import Model.Books.BookService;
import Model.Books.Zh_Books;
import Model.Login.Zh_accessLevel;
import Model.Users.D_Users;
import Model.Users.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticFunctionalities {
    private static BookService bookService = new BookService();
    private static BillService billService = new BillService();
    StatisticFunctionalities(BookService bookService){
        this.bookService = bookService;
    }
    StatisticFunctionalities(BillService billService){
        this.billService = billService;
    }
    public static int getBookSold(int year, int month, String path) {
        ArrayList<Bill> bills = billService.getBillsFromFile(path);
        int sum = 0;
        int i=0;
        for(Bill bill: bills){
            if(bill.getDate().getYear() == year && bill.getDate().getMonth()==month )
            {
                sum+=bill.getBookquantity();
            }
            i++;
        }
        return sum;
    }

    public static int getBookBought(int year, int month, String path) {
        ArrayList<Zh_Books> books = bookService.getBooks(path);
        int sum = 0;
        int i=0;
        for(Zh_Books book: books){
            System.out.println(book.getDate().getYear() + " " + book.getDate().getMonth());
            if(book.getDate().getYear() == year && book.getDate().getMonth()==month )
            {
                sum+=book.getQuanity();
            }
            i++;
        }
        return sum;
    }

    public static Map<String, Double>  getLibrarianInfo(String path){
        ArrayList<Bill> bills = billService.getBillsFromFile(path);
        Map<String, Double> librarianInfoMap = new HashMap<>();
        for(Bill bill: bills){
           String key = bill.getLibrarian_Name() + " " + bill.getSurname();
           if(librarianInfoMap.containsKey(key)){
               double total = librarianInfoMap.get(key);
               librarianInfoMap.put(key, total + bill.getPrice());
           }
           else {
               librarianInfoMap.put(key, bill.getPrice());
           }
        }
        return librarianInfoMap;
    }


    }