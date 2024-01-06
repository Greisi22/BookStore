package Mock.Bills;



import com.example.Model.Bills.Bill;
import com.example.Model.Bills.BillService;

import java.util.ArrayList;

public class BillServiceMock extends BillService {

    private ArrayList<Bill> bills;
    public String path;
    @Override
    public  <E> ArrayList <E> getBillsFromFile(String path) {

        return (ArrayList<E>) bills;
    }

    public void setBils(ArrayList<Bill>bills){
        this.bills =bills ;
    }
}
