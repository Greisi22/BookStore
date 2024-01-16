package com.example.Model.Books;

import java.util.ArrayList;

public class BookFunctionalities {



    static BookService bookService = new BookService();

    private static String path = "src/main/java/com/example/EncodedInformation/Books.dat";
    public BookFunctionalities(){

    }
    public BookFunctionalities(BookService bookService){
        this.bookService = bookService;
    }
    public  static  ArrayList<Books> UpdateBook(Books bookupdate) {
        ArrayList<Books> books = bookService.getBooks(path);
      if(bookupdate != null){
          for (int i=0;i<books.size();i++){
              if (books.get(i).getISBN().equals(bookupdate.getISBN())) {
                  books.set(i, bookupdate);
              }
          }
          bookService.writeBooksInFile(books, path);
      }
        return books;
    }
    public void setPath(String path){
        this.path = path;
    }


}
