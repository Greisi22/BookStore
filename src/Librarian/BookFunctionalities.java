package Librarian;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class BookFunctionalities {
    private static final String path = "src/EncodedInformation/Books.dat";
    public static <E> ArrayList<E> getBooks( String path) {
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




    //..............................................................................


    //.........................................................................

    public static ArrayList<Zh_Books> UpdateBook(Zh_Books bookupdate) {
        ArrayList<Zh_Books> books = getBooks(path);
        for (int i=0;i<books.size();i++){
            if (books.get(i).getISBN().equals(bookupdate.getISBN())) {
                books.set(i, bookupdate);
            }
        }
        writeBooksInFile(books);
       return books;
    }



    //.....................................................


    public static void writeBooksInFile(ArrayList<Zh_Books> newBooks1){
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
    }

    }
