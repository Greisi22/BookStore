package com.example.View.Librarian;



import com.example.Model.Books.Author;
import com.example.Model.Books.Books;

import java.io.Serial;
import java.io.Serializable;

public class BooksController {
	/**
	 * 
	 */


	
	public Books loginn(String title, String isbn, int quanity, String description, double price, Author author,
						boolean paperback)
	{
		Books newBook=new Books( title,isbn,quanity,description,price,author,paperback);
		
		return newBook;
	}
	

	

}