package Model.Books;

import java.io.*;
import java.util.ArrayList;


public  class BookService {

    private String path = "src/EncodedInformation/Books.dat";

    public BookService ()
    {

    }
    public <E> ArrayList<E> getBooks(String path ) {

        ArrayList<E> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream objis = new ObjectInputStream(fis);

            Books obj = new Books();
            while (true) {
                obj = ((Books) objis.readObject());
                list.add((E) obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            System.out.println(e1);
        }

        return list;
    }


    public  void writeBooksInFile(ArrayList<Books> newBooks1, String path){
        FileOutputStream out;
        try {
            out = new FileOutputStream(path);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            for (int i = 0; i < newBooks1.size(); i++) {
                objout.writeObject(newBooks1.get(i));
            }
            objout.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setPath(String path){
        this.path = path;
    }




}
