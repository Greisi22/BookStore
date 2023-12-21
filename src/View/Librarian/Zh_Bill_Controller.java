package View.Librarian;

import Model.Bills.Bill;
import Model.Bills.Zh_MyDate;

import java.io.Serial;
import java.io.Serializable;

public class Zh_Bill_Controller implements Serializable  {

	

	
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 6762662553919269736L;

	public Bill createBill(double price, Zh_MyDate date, int qunanity)
	{
		Bill newBill=new Bill(price,date);
		newBill.setBookquantity(qunanity);
		return newBill;
	}
	

}
