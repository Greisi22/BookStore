package View.Administator;

import Model.Users.Users;
import Model.Bills.MyDate;
import Model.Login.AccessLevel;

public class Controller_Users {
	public Users loginn(String firstName, String lastName, String email, MyDate birthday, String password, long salery,
						String phone, AccessLevel accesLevel)
	{
		Users newUser=new Users(firstName,lastName,email,birthday, password,salery,phone,accesLevel);
		
		return newUser;
	}
}
