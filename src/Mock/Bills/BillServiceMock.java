package Mock.Bills;

import Model.Bills.Bill;
import Model.Bills.BillService;

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
