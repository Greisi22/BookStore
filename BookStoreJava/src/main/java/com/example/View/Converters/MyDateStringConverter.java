package com.example.View.Converters;


import com.example.Model.Bills.MyDate;
import javafx.util.StringConverter;

public class MyDateStringConverter extends StringConverter<MyDate> {

	@Override
	public MyDate fromString(String arg0) {
		  char[] ch = new char[arg0.length()];
		  
	        // Copying character by character into array
	        // using for each loop
	        for (int i = 0; i <arg0.toString().length(); i++) {
	            ch[i] = arg0.toString().charAt(i);
	        }
	        String s111 = ch[0]+""+ch[1];
	        int month = Integer.parseInt(s111);
	        String s112 = ch[3]+""+ch[4];
	        int day = Integer.parseInt(s112);
	        String s113 = ch[6]+""+ch[7];
	        int year = Integer.parseInt(s113);
	     
		return ( new MyDate(month,day,year));
	}

	@Override
	public String toString(MyDate arg0) {

//		return arg0.toString();
		return "prova";
	}



}
