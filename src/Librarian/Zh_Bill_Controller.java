package Librarian;

import java.io.Serial;
import java.io.Serializable;

public class Zh_Bill_Controller implements Serializable  {

	

	
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 6762662553919269736L;

	public Bill loginn(double price, Zh_MyDate date)
	{
		Bill newBook=new Bill( price,date);
		
		return newBook;
	}
	

}
