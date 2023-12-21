package Model.Users;



import Model.Login.Zh_accessLevel;
import Model.Bills.Zh_MyDate;

import java.io.Serial;
import java.io.Serializable;

public class D_Users implements Serializable {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;


	private String firstName;
	private String lastName;
	private String email;
	private Zh_MyDate birthday;
	private String password;
	private long salery;
	private String phone;
	private Zh_accessLevel accesLevel;
	
	
	public D_Users(){
	}


	public D_Users(String firstName, String lastName, String email, Zh_MyDate birthday, String password, long salery,
			String phone, Zh_accessLevel accesLevel) {
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

    public D_Users(String testUser, String testPassword, Zh_accessLevel zhAccessLevel) {
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
	public Zh_MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(Zh_MyDate birthday) {
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
	public Zh_accessLevel getAccesLevel() {
		return accesLevel;
	}
	public void setAccesLevel(Zh_accessLevel accesLevel) {
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
