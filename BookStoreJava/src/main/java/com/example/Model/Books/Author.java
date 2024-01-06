package com.example.Model.Books;



import com.example.Model.Userss.Gender;

import java.io.Serializable;

public class Author implements Serializable {

	private String firstName;
	private String lastName;
	private Gender gender;
	public Author(String firstName) {
		super();
		this.firstName = firstName;
	}
	public Author(String firstName, String lastName, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
}
