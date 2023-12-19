package Test.Librarian.Bills;

import Model.Bills.Bill;
import Model.Bills.BillService;
import Model.Bills.Zh_MyDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BillServiceTest {


    @TempDir
    static File tempFolder;

    @TempDir
    static Path tempDir;

    @Test
    void printFileTest(){
        String path = tempDir.resolve("cnt.txt").toString();
        String billPath = tempDir.resolve("Bills").toString() + File.separator + "Bill";

        // Create an ArrayList of book names
        ArrayList<String> bookNames = new ArrayList<>();
        bookNames.add("Book1");
        bookNames.add("Book2");

        // Create a Bill instance (you need to initialize it according to your application logic)
        Bill createdBill = new Bill(23, new Zh_MyDate(12, 3, 2002));

        String result = BillService.PrintFile(bookNames, createdBill);

        System.out.println("Result: " + result);
        try {
            System.out.println("Content of cnt.txt: " + Files.readString(Path.of(path)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Bill is Printed", result);

    }

    @Test
        void getBillsFromFileTest() throws IOException {
            File tempFile = new File(tempFolder, "testBill.dat");

            Bill bill1;
            Bill bill2;

            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
                bill1 = new Bill(23, new Zh_MyDate(12, 3, 2002));
                bill2 = new Bill(25, new Zh_MyDate(8, 2, 2002));

                objectOutputStream.writeObject(bill1);
                objectOutputStream.writeObject(bill2);
            }

            ArrayList<Bill> billList = BillService.getBillsFromFile(tempFile.getPath());


            assertEquals(2, billList.size());
            assertEquals(23.0, billList.get(0).getPrice());
            assertEquals(new Zh_MyDate(8, 2, 2002), billList.get(1).getDate());

            {
            }
        }
    @Test
            void createNewBillTest()throws IOException{
        File tempFile = new File(tempFolder, "testBill.dat");



        ArrayList<Bill> billList = BillService.getBillsFromFile(tempFile.getPath());

        Bill bill = new Bill(20, new Zh_MyDate(8, 2, 2002));
        billList.add(bill);
        BillService.createNewBill(bill,tempFile.getPath());


        assertEquals(1, billList.size());
        assertEquals(20.0, billList.get(0).getPrice());
        assertEquals(new Zh_MyDate(8, 2, 2002), billList.get(0).getDate());

        }

    }


