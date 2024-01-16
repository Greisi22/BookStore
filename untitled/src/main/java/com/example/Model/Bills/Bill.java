package com.example.Model.Bills;


import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable {


    /**
     *
     */
    public void setBook_name(ArrayList<String> book_name) {
        Book_name = book_name;
    }

    @Serial
    private static final long serialVersionUID = 1L;
    private double Price;
    private ArrayList<String> Book_name;
    private MyDate date;
    private String name;
    private String surname;
    private int Bookquantity;
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

    public Bill() {

    }

    public Bill(double price, MyDate date) {
        super();
        Price = price;

        this.date = date;


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


    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
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


}
