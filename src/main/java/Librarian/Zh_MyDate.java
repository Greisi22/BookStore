package Librarian;

import java.io.Serializable;
import java.util.Objects;

public class Zh_MyDate implements Serializable {
    /**
	 * 
	 */

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



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Zh_MyDate other = (Zh_MyDate) obj;
        return year == other.year && month == other.month && day == other.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
    public String toString(){
	return month+"/"+day+"/"+year;
    }
}