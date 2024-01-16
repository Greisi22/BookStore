package com.example.Model.Userss;

import java.io.*;
import java.util.ArrayList;


public class UserService {

    public UserService ()
    {

    }
    public ArrayList<Users> getUsers(String path ) {
        ArrayList<Users> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream objis = new ObjectInputStream(fis);
            Users obj = new Users();
            while (true) {
                obj = ((Users) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            System.out.println(e1);
        }

        return list;
    }


    public  void writeUsersInFile(ArrayList<Users> usersList, String path){
        FileOutputStream out;
        try {
            out = new FileOutputStream(path);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            for (int i = 0; i < usersList.size(); i++) {
                objout.writeObject(usersList.get(i));
            }

            objout.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
