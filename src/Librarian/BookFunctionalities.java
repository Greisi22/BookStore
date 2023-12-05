package Librarian;



import java.io.*;
import java.util.ArrayList;


public class BookFunctionalities  {
    public static <E> ArrayList<E> getBooks(ArrayList<E> list) {

        FileInputStream fis;
        try {
            fis = new FileInputStream("src/EncodedInformation/Books.dat");
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

    //..............................................................................

    static ArrayList<Zh_Books> newBooks1 = new ArrayList<Zh_Books>();

    public  static Zh_Books UpdateBook(String Isbn) throws FileNotFoundException {

        FileInputStream fis;
        Zh_Books obj = null;
        try {

            fis = new FileInputStream("src/EncodedInformation/Books.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            while (true) {
                try {
                    obj = (Zh_Books) objis.readObject();
                    if (obj.getISBN().equals(Isbn)) {
                        int a = obj.getQuanity();
                        a -= 1;
                        obj.setQuanity(a);
                    }
                    newBooks1.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
           createBook(newBooks1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }



    public static void createBook(ArrayList<Zh_Books> newBooks1){
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
