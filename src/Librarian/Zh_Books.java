package Librarian;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class Zh_Books  implements Serializable {
	
	private static final long serialVersionUID = 5296705482940410483L;
	private String title;
	private String ISBN;
	private int quanity;
	private String description;
	private double price;
	private V_Author author;
	private ArrayList<Zh_Genre> genres = new ArrayList<>();
	private String genresS;
	private boolean paperback; // or e-book
	private Zh_MyDate date;
	
	public Zh_MyDate getDate() {
		return date;
	}

	public void setDate(Zh_MyDate date) {
		this.date = date;
	}

	public String getGenresS() {
		String s1="";
		for (int i=0;i<getGenres().size();i++)
		{
			s1+=getGenres().get(i)+" ";
		}
		
		return genresS;
	}

	public void setGenresS(String genresS) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<Zh_Genre> list2 = new ArrayList<>();
		char[] chararr = genresS.toCharArray();
		String s2="";
		for(int i=0;i<chararr.length;i++)
		{
			if(chararr[i]!=' ') {
				s2+=chararr[i];
			}
			else {
				list1.add(s2);
				s2="";
				i++;
			}
			
		}
		for(int i=0;i<list1.size();i++)
		{
			if(list1.get(i).equals("ACTION"))
			{
				list2.add(Zh_Genre.ACTION);
			}
			else if(list1.get(i).equals("FANTASY"))
			{
				list2.add(Zh_Genre.FANTASY);
			}
		}
		setGenres(list2);
	}

	
	
	public Zh_Books()
	{
		
	}
	
	public Zh_Books(String title, String ISBN, int quanity, String description, double price, V_Author author, boolean paperback) {
		super();
		this.title = title;
		this.ISBN = ISBN;
		this.quanity = quanity;
		this.description = description;
		this.price = price;
		this.author = author;
		this.paperback = paperback;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public V_Author getAuthor() {
		return author;
	}
	public void setAuthor(V_Author author) {
		this.author = author;
	}
	public ArrayList<Zh_Genre> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<Zh_Genre> genres) {
		this.genres = genres;
	}
	public boolean isPaperback() {
		return paperback;
	}
	public void setPaperback(boolean paperback) {
		this.paperback = paperback;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void addGenres(Zh_Genre...genres) {
		for(Zh_Genre genre : genres)
			this.addGenres(genre);
	}
	@Override
	public String toString() {
		return "Zh_Books [ISBN=" + ISBN + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", author=" + author + ", genres=" + genres + ", paperback=" + paperback + ", quanity=" + quanity
				+ "]";
	}
	
	

	
}
