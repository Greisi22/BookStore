package Librarian;

import java.io.*;
import java.util.ArrayList;


public abstract class BookService {
    private  final String path = "src/EncodedInformation/Books.dat";

    public BookService ()
    {

    }
    public <E> ArrayList<E> getBooks(String path ) {
        ArrayList<E> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream objis = new ObjectInputStream(fis);

            Zh_Books obj = new Zh_Books();
            while (true) {
                obj = ((Zh_Books) objis.readObject());
                list.add((E) obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            System.out.println(e1);
        }

        return list;
    }




        FileOutputStream out;
        try {
            out = new FileOutputStream("src/EncodedInformation/Books.dat");
            ObjectOutputStream objout = new ObjectOutputStream(out);
            for (int i = 0; i < newBooks1.size(); i++) {
                objout.writeObject(newBooks1.get(i));
            }
          newBooks1.clear();
            objout.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }

    public abstract void writeBooksInFile(ArrayList<Zh_Books> newBooks1);
}


}
