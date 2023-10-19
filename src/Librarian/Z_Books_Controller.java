package Librarian;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Z_Books_Controller implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	public Zh_Books loginn(String title, String isbn, int quanity, String description, double price, V_Author author,
			boolean paperback)
	{
		Zh_Books newBook=new Zh_Books( title,isbn,quanity,description,price,author,paperback);
		
		return newBook;
	}
	

	

}