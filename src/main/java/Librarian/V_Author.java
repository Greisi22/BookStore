package Librarian;

import java.io.Serializable;

public class V_Author implements Serializable {

	private String firstName;
	private String lastName;
	private Gender gender;
	public V_Author(String firstName) {
		super();
		this.firstName = firstName;
	}
	public V_Author(String firstName, String lastName, Gender gender) {
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
	@Override
	public String toString() {
		return "V_Author [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + "]";
	}
	
}
