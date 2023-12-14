package Librarian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.Serial;
import java.io.Serializable;

public class Zh_MyDate implements Serializable {
    /**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 3712105092132632024L;
	private int year;
    private int month;
    private int day;

    public Zh_MyDate(){
	day=0;
	month=0;
	year=0;
    }
    public Zh_MyDate(int month, int day, int year){
	this.year=year;
	this.month=month;
	this.day=day;
    }
    public int getYear(){
	return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public void setYear(int year){
        if(year>0)
        {
            this.year=year;
        }
        else{
            this.year=0;
        }

    }
    public void setMonth(int month){
        if(month>0)
        {
            this.month=month;
        }
        else{
            this.month=0;
        }

    }
    public void setDay(int day){

        if(day>0){
            this.day=day;
        }
        else{
            this.day=0;
        }

    }



    public boolean equals(Zh_MyDate date){
	if(this.year==date.getYear() && this.month==date.getMonth() && this.day==date.getDay())
	    return true;
	else return false;
    }
    public String toString(){
	return month+"/"+day+"/"+year;
    }
}