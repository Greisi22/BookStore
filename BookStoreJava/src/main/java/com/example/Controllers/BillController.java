package com.example.Controllers;

import com.example.Model.Bills.Bill;
import com.example.Model.Bills.BillFunctionalitiess;
import com.example.Model.Bills.BillService;
import com.example.Model.Bills.MyDate;
import com.example.Model.Books.Books;
import javafx.scene.control.DatePicker;


import java.util.ArrayList;

public class BillController {


    public void handlePrintingBill(ArrayList<Books> bookOfBill, DatePicker datePicker) {
        double total = BillFunctionalitiess.CalculateTotalPrice(bookOfBill);
        ArrayList<String> bookNamess = BillFunctionalitiess.getBookNames(bookOfBill);
        BillFunctionalitiess.CalculateTotalPrice(bookOfBill);

        for (Books book : bookOfBill) {
            BillFunctionalitiess.updateQuantity(book);
        }
        Bill isCreated = createBill(total, new MyDate(datePicker.getValue().getMonthValue(),
                datePicker.getValue().getDayOfMonth(),
                datePicker.getValue().getYear()), bookOfBill.size());
        isCreated.setBook_name(bookNamess);
        isCreated.setBookquantity(bookOfBill.size());


        BillService.PrintFile(bookNamess, isCreated);
        BillService.createNewBill(isCreated, "src/main/java/com/example/EncodedInformation/Bills.dat");
    }


    public Bill createBill(double price, MyDate date, int qunanity) {
        Bill newBill = new Bill(price, date);
        newBill.setBookquantity(qunanity);
        return newBill;
    }
}
