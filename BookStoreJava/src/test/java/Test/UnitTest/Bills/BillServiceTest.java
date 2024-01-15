package Test.UnitTest.Bills;


import com.example.Model.Bills.Bill;
import com.example.Model.Bills.BillService;
import com.example.Model.Bills.MyDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BillServiceTest {


    @TempDir
    static File tempFolder;

    @TempDir
    static Path tempDir;


    @Test
    void printFileTest() {
        String path = tempDir.resolve("cnt.txt").toString();
        String billPath = tempDir.resolve("Bills").toString() + File.separator + "Bill";
        ArrayList<String> bookNames = new ArrayList<>();
        bookNames.add("Book1");
        bookNames.add("Book2");
        Bill createdBill = new Bill(23, new MyDate(12, 3, 2002));
        String result = BillService.PrintFile(bookNames, createdBill);
        System.out.println("Result: " + result);
        try {
            System.out.println("Content of cnt.txt: " + Files.readString(Path.of(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Bill is Printed", result);
    }


    //..................................................

    @Test
    void testGetBillsFromFileWithBills() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill.dat");
        Bill bill1 = new Bill(23, new MyDate(12, 3, 2002));
        Bill bill2 = new Bill(25, new MyDate(8, 2, 2002));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            objectOutputStream.writeObject(bill1);
            objectOutputStream.writeObject(bill2);
        }

        ArrayList<Bill> billList = billService.getBillsFromFile(tempFile.getPath());
        assertEquals(2, billList.size());
    }

    @Test
    void testGetBillsFromFileEmpty() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill2.dat");
        ArrayList<Bill> billList = billService.getBillsFromFile(tempFile.getPath());
        assertEquals(0, billList.size());
    }

    //................................................

    @Test
    void testCreateNewBillWithExistingBills() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill.dat");
        ArrayList<Bill> billList = billService.getBillsFromFile(tempFile.getPath());
        Bill bill = new Bill(20, new MyDate(8, 2, 2002));
        billService.createNewBill(bill, tempFile.getPath());
        ArrayList<Bill> updatedBillList = billService.getBillsFromFile(tempFile.getPath());
        assertEquals(1, updatedBillList.size());
        assertEquals(20.0, updatedBillList.get(0).getPrice());
        assertEquals(new MyDate(8, 2, 2002), updatedBillList.get(0).getDate());
    }

    @Test
    void testCreateNewBillEmptyFile() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill.dat");
        tempFile.createNewFile();
        ArrayList<Bill> billList = billService.getBillsFromFile(tempFile.getPath());
        Bill bill = new Bill(20, new MyDate(8, 2, 2002));
        billService.createNewBill(bill, tempFile.getPath());
        ArrayList<Bill> updatedBillList = billService.getBillsFromFile(tempFile.getPath());
        assertEquals(1, updatedBillList.size());
        assertEquals(20.0, updatedBillList.get(0).getPrice());
        assertEquals(new MyDate(8, 2, 2002), updatedBillList.get(0).getDate());
    }

    @Test
    void testCreateNewBillWithNullBill() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill.dat");
        ArrayList<Bill> billList = billService.getBillsFromFile(tempFile.getPath());
        billService.createNewBill(null, tempFile.getPath());
        ArrayList<Bill> updatedBillList = billService.getBillsFromFile(tempFile.getPath());
        assertEquals(billList.size(), updatedBillList.size());
    }

    @Test
    void testCreateNewBillEmptyFileWithNullBill() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill1.dat");
        tempFile.createNewFile();
        billService.createNewBill(null, tempFile.getPath());
        ArrayList<Bill> updatedBillList = billService.getBillsFromFile(tempFile.getPath());
        assertTrue(updatedBillList.isEmpty());
    }

}