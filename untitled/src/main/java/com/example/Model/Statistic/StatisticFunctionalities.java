package com.example.Model.Statistic;


import com.example.Model.Bills.Bill;
import com.example.Model.Bills.BillService;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticFunctionalities {
    private static BookService bookService = new BookService();
    private static BillService billService = new BillService();

    public StatisticFunctionalities(BookService bookService) {
        this.bookService = bookService;
    }

    public StatisticFunctionalities(BillService billService) {
        this.billService = billService;
    }

    public StatisticFunctionalities(BookService bookService, BillService billService) {
        this.billService = billService;
        this.bookService = bookService;
    }

    public static int getBookRevenue(int year, int month, String path) {
        ArrayList<Bill> bills = billService.getBillsFromFile(path);
        int sum = 0;
        int i = 0;
        for (Bill bill : bills) {
            if (bill.getDate().getYear() == year && bill.getDate().getMonth() == month) {
                sum += bill.getBookquantity();
            }
            i++;
        }
        return sum;
    }

    public static int getBookCost(int year, int month, String path) {
        ArrayList<Books> books = bookService.getBooks(path);
        int sum = 0;
        int i = 0;
        for (Books book : books) {
            if (book.getDate().getYear() == year && book.getDate().getMonth() == month) {
                sum += book.getQuanity();
            }
            i++;
        }
        return sum;
    }

    public static Map<String, Double> getLibrarianInfo(String path) {
        ArrayList<Bill> bills = billService.getBillsFromFile(path);
        Map<String, Double> librarianInfoMap = new HashMap<>();
        for (Bill bill : bills) {
            String key = bill.getLibrarian_Name() + " " + bill.getSurname();
            if (librarianInfoMap.containsKey(key)) {
                double total = librarianInfoMap.get(key);
                librarianInfoMap.put(key, total + bill.getPrice());
            } else {
                librarianInfoMap.put(key, bill.getPrice());
            }
        }
        return librarianInfoMap;
    }


}
