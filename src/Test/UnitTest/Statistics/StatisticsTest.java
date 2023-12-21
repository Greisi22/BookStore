package Test.UnitTest.Statistics;

import Model.Statistic.StatisticFunctionalities;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    @Test
    void testStatistics(){
       double sum  =  StatisticFunctionalities.getBookBought(2023,1, "src/EncodedInformation/Books.dat");
       System.out.println(sum);
    }
}
