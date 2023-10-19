package Librarian;

import java.io.Serializable;

public class Zh_Bill_Controller implements Serializable  {

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6762662553919269736L;

	public E_Bill loginn(double price,Zh_MyDate date)
	{
		E_Bill newBook=new E_Bill( price,date);
		
		return newBook;
	}
	

}
