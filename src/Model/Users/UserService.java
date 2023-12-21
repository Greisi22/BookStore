package Model.Users;

import Model.Books.Zh_Books;
import View.Administator.Users;

import java.io.*;
import java.util.ArrayList;

public class UserService {

    public UserService ()
    {

    }
    public ArrayList<D_Users> getUsers(String path ) {
        ArrayList<D_Users> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream objis = new ObjectInputStream(fis);
            D_Users obj = new D_Users();
            while (true) {
                obj = ((D_Users) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            System.out.println(e1);
        }

        return list;
    }


    public  void writeUsersInFile(ArrayList<D_Users> usersList, String path){
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
