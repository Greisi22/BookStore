package Librarian;


import java.io.Serializable;
import java.util.ArrayList;

public class E_Bill implements Serializable {



	/**
	 * 
	 */
	public void setBook_name(ArrayList<String> book_name) {
		Book_name = book_name;
	}
	private static final long serialVersionUID = 1L;
	private     double Price;
	private     ArrayList<String> Book_name;
	

	private     Zh_MyDate date;
	private    String name;
	private     String surname;
	private int  Bookquantity;
	private String Librarian_Name;

public String getLibrarian_Name() {
		return Librarian_Name;
	}

	public void setLibrarian_Name(String librarian_Name) {
		Librarian_Name = librarian_Name;
	}

public int getBookquantity() {
		return Bookquantity;
	}

	public void setBookquantity(int bookquantity) {
		Bookquantity = bookquantity;
	}

public E_Bill() {
	
}
	
	public E_Bill(double price,Zh_MyDate date) {
		super();
		Price = price;

		this.date =date;

	
	}

	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public ArrayList<String> getBook_name() {
		return Book_name;
	}

	
	public Zh_MyDate getDate() {
		return date;
	}

	public void setDate(Zh_MyDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	

	@Override
	public String toString() {
		return "E_Bill [Price=" + Price + ", Book_name=" + Book_name + ", date=" + date + ", name=" + name
				+ ", surname=" + surname + "]";
	}
	
	
	
	
}
