package Test.Librarian.Bills;


import Librarian.Bill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class E_BillTest {

    @Test
    void setBook_name() {

    }

    @Test
    void getLibrarian_Name() {
        Bill bill = new Bill();
        bill.setLibrarian_Name("Era");
        String actual = bill.getLibrarian_Name();
        assertEquals("Era",actual);

    }

    @Test
    void setLibrarian_Name() {
    }

    @Test
    void getBookquantity() {
        Bill bill = new Bill();
        bill.setBookquantity(5);
        int actual = bill.getBookquantity();
        assertEquals(5,actual);

    }

    @Test
    void setBookquantity() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void getBook_name() {
    }

    @Test
    void getDate() {
    }

    @Test
    void setDate() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getSurname() {
    }

    @Test
    void setSurname() {
    }

    @Test
    void testToString() {
    }
}