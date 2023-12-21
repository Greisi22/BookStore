package Test.UnitTest.Statistics;

import Mock.Bills.BillServiceMock;
import Mock.Books.BooksSreviceMock;
import Model.Bills.Bill;
import Model.Bills.Zh_MyDate;
import Model.Books.BookService;
import Model.Books.Zh_Books;
import Model.Statistic.StatisticFunctionalities;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {


    @Test
    void getBookRevenueTest(){

        int expected = 0;
        ArrayList<Bill> bills = new ArrayList<>();

        Bill bill = new Bill();
        bill.setDate(new Zh_MyDate(2,11,2002));
        bill.setBookquantity(3);

        Bill bill1 = new Bill();
        bill1.setDate(new Zh_MyDate(3,14,2002));
        bill.setBookquantity(2);

        bills.add(bill);
        bills.add(bill1);

        BillServiceMock billServiceMock = new BillServiceMock();
        billServiceMock.setBils(bills);

        StatisticFunctionalities statisticFunctionalities = new StatisticFunctionalities(billServiceMock);

        int actual = StatisticFunctionalities.getBookRevenue(2002,2,"bill");

        for(Bill bill3: bills)
        {
            if(bill.getDate().getYear() == 2002 && bill.getDate().getMonth()==2 )
            {
                expected+=bill3.getBookquantity();
            }

        }

        assertEquals(expected,actual);

    }

    @Test
    void getBookCostTest(){

        int expected = 0;
        ArrayList<Zh_Books> books = new ArrayList<>();

        Zh_Books book1 = new Zh_Books();
        book1.setDate(new Zh_MyDate(2,11,2002));
        book1.setQuanity(3);

        Zh_Books book2 = new Zh_Books();
        book2.setDate(new Zh_MyDate(3,11,2002));
        book2.setQuanity(3);

        books.add(book1);
        books.add(book2);

        BooksSreviceMock booksServiceMock = new BooksSreviceMock();
        booksServiceMock.setBooks(books);

        StatisticFunctionalities statisticFunctionalities = new StatisticFunctionalities(booksServiceMock);

        int actual = StatisticFunctionalities.getBookCost(2002,2,"book");

        for(Zh_Books bookss: books)
        {
            if(bookss.getDate().getYear() == 2002 && bookss.getDate().getMonth()==2 )
            {
                expected+=bookss.getQuanity();
            }

        }

        assertEquals(expected,actual);

    }


@Test
    void getLibrarianInfoTest(){

    Map<String,Double> actual = new HashMap<>();


    Map<String, Double> expected = new HashMap<>();
    expected.put("Greisi Jaho", 50.0);
    expected.put("David Keci", 58.0);
    expected.put("Greisi Jaho", 53.0);


    ArrayList<Bill> bills = new ArrayList<>();

    Bill bill = new Bill();
    bill.setLibrarian_Name("Greisi");
    bill.setSurname("Jaho");
    bill.setPrice(50);

    Bill bill2 = new Bill();
    bill2.setLibrarian_Name("Greisi");
    bill2.setSurname("Jaho");
    bill2.setPrice(53);


    Bill bill1 = new Bill();
    bill1.setLibrarian_Name("David");
    bill1.setSurname("Keci");
    bill1.setPrice(58);

    bills.add(bill);
    bills.add(bill1);
    bills.add(bill2);

    BillServiceMock billServiceMock = new BillServiceMock();
    billServiceMock.setBils(bills);

    StatisticFunctionalities statisticFunctionalities = new StatisticFunctionalities(billServiceMock);
    actual =  StatisticFunctionalities.getLibrarianInfo("Path");

assertEquals(expected,actual);


    }


}


