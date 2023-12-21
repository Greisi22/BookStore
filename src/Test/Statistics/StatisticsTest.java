package Test.Statistics;

import Model.Books.Zh_Books;
import Model.Statistic.StatisticFunctionalities;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StatisticsTest {

    @Test
    void testStatistics(){
       double sum  =  StatisticFunctionalities.getBookBought(2023,1, "src/EncodedInformation/Books.dat");
       System.out.println(sum);
    }
}
