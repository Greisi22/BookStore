package View.Administator;

import Model.Users.D_Users;
import Model.Bills.Zh_MyDate;
import Test.Librarian.Books.Zh_accessLevel;

public class Controller_Users {
	public D_Users loginn(String firstName, String lastName, String email, Zh_MyDate birthday, String password, long salery,
			String phone,Zh_accessLevel accesLevel)
	{
		D_Users newUser=new D_Users(firstName,lastName,email,birthday, password,salery,phone,accesLevel);
		
		return newUser;
	}
}
