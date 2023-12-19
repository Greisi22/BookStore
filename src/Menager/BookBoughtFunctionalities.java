package Menager;

import Librarian.Zh_Books;

import java.io.*;
import java.util.ArrayList;

public class BookBoughtFunctionalities {

    public static <E> ArrayList<E> getBooksBought(ArrayList<E> list) {

        FileInputStream fis;
        try {
            fis = new FileInputStream("src/EncodedInformation/booksBought.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            Zh_Books obj = new Zh_Books();
            while (obj != null) {
                obj = ((Zh_Books) objis.readObject());
                list.add((E) obj);
            }
            objis.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            System.out.println(e1);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    //...............................................................

    public static String saveBookBought(ArrayList<Book_Sold> listBooks){
        FileOutputStream out = null;
        ObjectOutputStream output = null;

        try {
            out = new FileOutputStream("src/EncodedInformation/booksBought.dat");
            output = new ObjectOutputStream(out);

            for (Book_Sold book : listBooks) {
                output.writeObject(book);
            }
        } catch (FileNotFoundException e) {
            return "You have not saved the BookBoght" + e;
        } catch (IOException e) {
            return "You have not saved the BookBoght" + e;
        } finally { //Added this finally block to make sure that the outputs are closed properly
            try {
                if (output != null) {
                    output.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.out.println("You have not saved the BookBoght" + e);
            }
        }
        return "You have saved the BookBoght";
    }

}
