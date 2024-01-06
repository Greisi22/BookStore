package Administator;

import Librarian.Zh_MyDate;
import javafx.util.StringConverter;

public class ZH_MyDateStringConverter extends StringConverter<Zh_MyDate> {

	@Override
	public Zh_MyDate fromString(String arg0) {
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
	     
		return ( new Zh_MyDate(month,day,year));
	}

	@Override
	public String toString(Zh_MyDate arg0) {

		return arg0.toString();
	}



}
