package Model.Manager;

import Librarian.Zh_Books;

import java.io.*;

public class OutOFStock {
    public static boolean checkIfOutOfStock() {
        FileInputStream fis;

        try {
            fis = new FileInputStream("src/EncodedInformation/Books.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            while (true) {
                try {
                    Zh_Books obj = (Zh_Books) objis.readObject();
                    if (obj.getQuanity() < 5) {
                        objis.close();
                        return true;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

            objis.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
