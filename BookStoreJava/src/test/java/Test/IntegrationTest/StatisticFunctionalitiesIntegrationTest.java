package Test.IntegrationTest;

import com.example.Model.Bills.Bill;
import com.example.Model.Bills.MyDate;
import com.example.Model.Books.Books;
import com.example.Model.Statistic.StatisticFunctionalities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.example.Model.Books.BookService;
import com.example.Model.Bills.BillService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticFunctionalitiesIntegrationTest {

    private static File tempFile;
    private static File tempFile2;

    @TempDir
    static File tempFolder1;
    @TempDir
    static File tempFolder2;

    @BeforeEach
    void createFile() throws IOException {
        tempFile = new File(tempFolder1, "testBills.dat");
        tempFile2 = new File(tempFolder2, "testBoks.dat");
        writeTestBills(tempFile);
        writeTestBooks(tempFile2);
    }

    @AfterEach
    void destroyFile() {
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
        if (tempFile2 != null && tempFile2.exists()) {
            tempFile2.delete();
        }
    }

    @Test
    public void getBookRevenueTest() {
        StatisticFunctionalities statisticFunctionalities = new StatisticFunctionalities(new BookService(), new BillService());
        int year = 2022;
        int month = 1;
        String path = tempFile2.getAbsolutePath();

        int revenue = statisticFunctionalities.getBookRevenue(year, month, path);

        // Assert the revenue based on the expected value from test bills
        assertEquals(10, revenue); // Replace with your expected value
    }

    @Test
    public void getBookCostTest() {
        StatisticFunctionalities statisticFunctionalities = new StatisticFunctionalities(new BookService(), new BillService());


        int year = 2022;
        int month = 1;
        String path = tempFile2.getAbsolutePath();

        int cost = statisticFunctionalities.getBookCost(year, month, path);


        assertEquals(5, cost); // Replace with your expected value
    }

    private void writeTestBills(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            Bill bill1 = new Bill(5, new MyDate(2022, 1, 1));
            Bill bill2 = new Bill(5, new MyDate(2022, 1, 1));

            oos.writeObject(bill1);
            oos.writeObject(bill2);
        }
    }

    private void writeTestBooks(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            Books book1 = new Books("Book1", "ISBN1", 5);
            book1.setDate(new MyDate(2022, 1, 1));
            Books book2 = new Books("Book2", "ISBN2", 5);
            book2.setDate(new MyDate(2022, 1, 1));
            oos.writeObject(book1);
            oos.writeObject(book2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

//getBookSold
//getBookBought
//getLibrarianInfo

