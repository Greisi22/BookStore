package com.example.Model.Userss;





import com.example.Model.Bills.MyDate;
import com.example.Model.Login.AccessLevel;

import java.io.Serial;
import java.io.Serializable;

public class Users implements Serializable {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;


	private String firstName;
	private String lastName;
	private String email;
	private MyDate birthday;
	private String password;
	private long salery;
	private String phone;
	private AccessLevel accesLevel;
	
	
	public Users(){
	}


	public Users(String firstName, String lastName, String email, MyDate birthday, String password, long salery,
				 String phone, AccessLevel accesLevel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
		this.salery = salery;
		this.phone = phone;
		this.accesLevel = accesLevel;
	}

    public Users(String testUser, String testPassword, AccessLevel zhAccessLevel) {
		this.firstName = testUser;
		this.password = testPassword;
		this.accesLevel = zhAccessLevel;
    }

    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getSalery() {
		return salery;
	}
	public void setSalery(long salery) {
		this.salery = salery;
	}
	public AccessLevel getAccesLevel() {
		return accesLevel;
	}
	public void setAccesLevel(AccessLevel accesLevel) {
		this.accesLevel = accesLevel;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
}
