package Model.Users;

import Model.Books.BookService;
import Model.Books.Zh_Books;
import Model.Users.D_Users;
import View.Administator.Users;

import java.io.*;
import java.util.ArrayList;

public class UserFunctionalities {
    static UserService userService = new UserService();
    private static String path = "src/EncodedInformation/Users.dat";

    public UserFunctionalities () {}
    public UserFunctionalities(UserService userService){
        this.userService = userService;
    }
    public  static  ArrayList<D_Users> updateUsers(D_Users bookupdate) {


        ArrayList<D_Users> users = userService.getUsers(path);
        for (int i=0;i<users.size();i++){
            if (users.get(i).getEmail().equals(bookupdate.getEmail())) {
                users.set(i, bookupdate);
            }
        }
        userService.writeUsersInFile(users, path);
        return users;
    }



}