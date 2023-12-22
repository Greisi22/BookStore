package View.Librarian;

import Model.Bills.Bill;
import Model.Bills.MyDate;

import java.io.Serial;
import java.io.Serializable;

public class BillController implements Serializable  {

	

	
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 6762662553919269736L;

	public Bill createBill(double price, MyDate date, int qunanity)
	{
		Bill newBill=new Bill(price,date);
		newBill.setBookquantity(qunanity);
		return newBill;
	}
	

}
