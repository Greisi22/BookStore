package com.example.View.Administator;


import com.example.Model.Bills.MyDate;
import com.example.Model.Login.AccessLevel;
import com.example.Model.Userss.Users;

public class Controller_Users {
	public Users loginn(String firstName, String lastName, String email, MyDate birthday, String password, long salery,
						String phone, AccessLevel accesLevel)
	{
		Users newUser=new Users(firstName,lastName,email,birthday, password,salery,phone,accesLevel);
		
		return newUser;
	}
}
