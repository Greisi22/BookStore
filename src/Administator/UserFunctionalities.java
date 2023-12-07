package Administator;

import Librarian.D_Users;

import java.io.*;
import java.util.ArrayList;

public class UserFunctionalities {
    public static ArrayList<D_Users> getUsers(ArrayList<D_Users> listBooks) {
        FileInputStream fis;
        ObjectInputStream objis = null;

        try {
            fis = new FileInputStream("src/EncodedInformation/Users.dat");
            objis = new ObjectInputStream(fis);

            while (true) {
                try {
                    D_Users obj = (D_Users) objis.readObject();
                    listBooks.add(obj);
                } catch (EOFException e) {
                    // End of file reached, exit the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objis != null) {
                try {
                    objis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listBooks;
    }

    static ArrayList<D_Users> newBooks1 = new ArrayList<D_Users>();

    public static String updateUsers(D_Users b1) {
        FileInputStream fis;
        ArrayList<D_Users> newBooks1 = new ArrayList<>();  // Create a new list to hold the updated objects

        try {
            fis = new FileInputStream("src/EncodedInformation/Users.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            while (true) {
                try {
                    D_Users obj = (D_Users) objis.readObject();

                    if (obj.getPassword().equals(b1.getPassword())) {
                        // Update the existing object with the new data
                        obj = b1;
                    }

                    newBooks1.add(obj);
                } catch (EOFException e) {
                    // End of file reached, exit the loop
                    break;
                }
            }

            objis.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream("src/EncodedInformation/Users.dat");
            ObjectOutputStream objout = new ObjectOutputStream(out);

            for (int i = 0; i < newBooks1.size(); i++) {
                objout.writeObject(newBooks1.get(i));
            }

            newBooks1.clear();
            objout.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Update failed");
        }
return "lot";
    }




    public static ArrayList<D_Users> readObjectBinaryFile() {
        ArrayList<D_Users> userList = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream("src/EncodedInformation/Users.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            while (true) {
                try {
                    D_Users user = (D_Users) objectInputStream.readObject();
                    userList.add(user);
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception as per your requirement
        }

        return userList;
    }

    public static void appendObjectToFile(D_Users user) {
        ArrayList<D_Users> existingUsers = readObjectBinaryFile();
        existingUsers.add(user);

        try (FileOutputStream fileOutputStream = new FileOutputStream("src/EncodedInformation/Users.dat");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            for (D_Users u : existingUsers) {
                objectOutputStream.writeObject(u);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as per your requirement
        }
    }



}