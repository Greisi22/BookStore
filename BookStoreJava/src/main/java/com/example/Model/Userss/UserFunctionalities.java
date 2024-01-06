package com.example.Model.Userss;

import java.util.ArrayList;

public class UserFunctionalities {
    static UserService userService = new UserService();
    private static String path = "src/main/java/com/example/EncodedInformation/Users.dat";

    public UserFunctionalities () {}
    public UserFunctionalities(UserService userService){
        this.userService = userService;
    }
    public  static ArrayList<Users> updateUsers(Users bookupdate) {
        ArrayList<Users> users = userService.getUsers(path);
        for (int i=0;i<users.size();i++){
            if (users.get(i).getEmail().equals(bookupdate.getEmail())) {
                users.set(i, bookupdate);
            }
        }
        userService.writeUsersInFile(users, path);
        return users;
    }

   public void setPath(String path){
       this.path = path;
   }


}