package Test.UnitTest.Librarian;


import com.example.Model.Bills.MyDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyDateTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "2000,2000",
                    "-2000,0"
            }
    )
    void getYear(int year, int expected) {
        MyDate mydate =new MyDate();
        mydate.setYear(year);
        int result =mydate.getYear();
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "12,12",


            }
    )
    void getMonth(int month, int expected) {
        MyDate mydate =new MyDate();
        mydate.setMonth(month);
        int result=mydate.getMonth();
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "12,12"
            }
    )
    void getDay(int day, int expected) {
        MyDate mydate =new MyDate();
        mydate.setMonth(day);
        int result=mydate.getMonth();
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "2022, 2022",
            "-2022, 0",
            "0, 0"
    })
    void testSetYear(int inputYear, int expectedYear) {
        MyDate myDate = new MyDate();
        myDate.setYear(inputYear);
        assertEquals(expectedYear, myDate.getYear());
    }

    @ParameterizedTest
    @CsvSource({
            "12, 12",
            "-12,0",
            "0,0"


    })
    void testSetMonth(int inputmonth, int expectedMonth) {
        MyDate myDate = new MyDate();
        myDate.setMonth(inputmonth);
        assertEquals(expectedMonth, myDate.getMonth());
    }

    @ParameterizedTest
    @CsvSource({
            "31, 31",
            "-2, 0",
            "0,0"

    })
    void testSetDay(int inputday, int expectedDay) {
        MyDate myDate = new MyDate();
        myDate.setDay(inputday);
        assertEquals(expectedDay, myDate.getDay());
    }
    @ParameterizedTest
    @CsvSource({
            "12,2,2002,12,2,2002,true",
            "12,2,2002,12,2,2000,false",
            "12,2,2002,10,2,2002,false",
            "12,2,2002,12,3,2002,false",

    })
    void testEquals(int month, int day, int year, int month1, int day1, int year1, boolean expected ) {

        MyDate myDate=new MyDate(month,day,year);
        MyDate myDate1=new MyDate(month1,day1,year1);

        assertEquals(expected, myDate.equals(myDate1));

    }

    @ParameterizedTest
    @CsvSource({
            "12,2,2002,'12/2/2002'"
    })
    void testToString(int month, int day, int year,String expected) {
        MyDate myDate=new MyDate(month,day,year);
        String result=myDate.toString();
        assertEquals(expected,result);
    }
}