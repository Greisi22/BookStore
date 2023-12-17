package Test.Librarian.Bills;

import Librarian.Bill;
import Librarian.BillService;
import Librarian.Zh_MyDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BillServiceTest {



        @TempDir
        static File tempFolder;



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
            File tempFile1 = new File(tempFolder, "testBill.dat");
            Bill bill;

            ArrayList<Bill> billList1 = BillService.getBillsFromFile(tempFile1.getPath());

            bill = new Bill(25, new Zh_MyDate(8, 2, 2002));

            billList1.add(bill);

            for(Bill b:billList1)
            {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile1))) {
                    objectOutputStream.writeObject(b);

                }
            }

        assertEquals(1, billList1.size());
        assertEquals(25.0, billList1.get(0).getPrice());
        assertEquals(new Zh_MyDate(8, 2, 2002), billList1.get(0).getDate());

        }




    }


