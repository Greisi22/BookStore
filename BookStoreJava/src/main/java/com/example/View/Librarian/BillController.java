package com.example.View.Librarian;


import com.example.Model.Bills.Bill;
import com.example.Model.Bills.MyDate;

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
