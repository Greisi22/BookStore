package Test.UnitTest.Bills;



import com.example.Model.Bills.Bill;
import com.example.Model.Bills.MyDate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {


    @Test
    void getLibrarian_Name() {
        Bill bill = new Bill();
        bill.setLibrarian_Name("Era");
        String actual = bill.getLibrarian_Name();
        assertEquals("Era", actual);

    }


    @Test
    void getBookquantity() {
        Bill bill = new Bill();
        bill.setBookquantity(5);
        int actual = bill.getBookquantity();
        assertEquals(5, actual);

    }

    @Test
    void setBookquantity() {
    }

    @Test
    void getPrice() {
        Bill bill2 = new Bill(20.0, new MyDate(2, 3, 2000));
        Bill bill = new Bill();
        bill.setPrice(25.9);
        double actual = bill.getPrice();
        assertEquals(25.9, actual);
    }


    @Test
    void getBook_name() {
        Bill bill = new Bill();
        ArrayList<String> bookNames = new ArrayList<>();
        bookNames.add("Era");
        bookNames.add("Greisi");
        bill.setBook_name(bookNames);
        ArrayList<String> actual = bill.getBook_name();
        assertEquals(bookNames, actual);

    }

    @Test
    void getDate() {
        MyDate date = new MyDate();
        date.setDay(9);
        date.setMonth(1);
        date.setYear(2000);
        Bill bill = new Bill();
        bill.setDate(date);
        MyDate actual = bill.getDate();
        assertEquals(date, actual);
    }


    @Test
    void getName() {
        Bill bill = new Bill();
        bill.setName("Era");
        String actual = bill.getName();
        assertEquals("Era", actual);
    }

    @Test
    void getSurname() {
        Bill bill = new Bill();
        bill.setSurname("Mulla");
        String actual = bill.getSurname();
        assertEquals("Mulla", actual);
    }


}