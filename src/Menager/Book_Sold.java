package Menager;

import java.io.Serializable;

import Librarian.Zh_MyDate;

public class Book_Sold implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6765261616486179882L;
	private Zh_MyDate date;
	private String BookISBN;
	public Zh_MyDate getDate() {
		return date;
	}
	public void setDate(Zh_MyDate date) {
		this.date = date;
	}
	public String getBookISBN() {
		return BookISBN;
	}
	public void setBookISBN(String bookISBN) {
		BookISBN = bookISBN;
	}
	public Book_Sold(Zh_MyDate date, String bookISBN) {
		super();
		this.date = date;
		BookISBN = bookISBN;
	}
	
	
	
}
