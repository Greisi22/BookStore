package Librarian;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class BookFunctionalities {
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
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }catch (IOException e1) {
            System.out.println(e1);
        }

        return list;
    }

    //..............................................................................

    static ArrayList<Zh_Books> newBooks1 = new ArrayList<Zh_Books>();

    public static ArrayList<Zh_Books> UpdateBookQuantity(String Isbn) throws FileNotFoundException {

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
        return newBooks1;
    }

    //.........................................................................

    public static ArrayList<Zh_Books> UpdateBook(Zh_Books b1) {
        FileInputStream fis;
        ArrayList<Zh_Books> newBooks1 = new ArrayList<>();  // Create a new list to hold the updated objects
        if (Files.exists(Path.of("src/EncodedInformation/Books.dat"))) {
            System.out.println("Directory is valid and exists.");
        } else {
            System.out.println("Directory does not exist or is not a valid directory.");
        }
        try {
            fis = new FileInputStream("src/EncodedInformation/Books.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            while (true) {
                try {
                    Zh_Books obj = (Zh_Books) objis.readObject();

                    if (obj.getISBN().equals(b1.getISBN())) {
                        // Update the existing object with the new data
                        obj = b1;
                    }

                    newBooks1.add(obj);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            objis.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            // Handle the case where the file doesn't exist
            return (newBooks1);

        }
        return newBooks1;
    }


    //.....................................................


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
