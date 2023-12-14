package Librarian;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BillFunctionalities {
    private static double total = 0;

    public static String PrintFile(ArrayList<String> listaaa, Bill isCreated) {
        File file = new File("src/TextFiles/cnt.txt");
        try {
            Scanner input = new Scanner(file);
            String a = input.next();
            int cnt = Integer.parseInt(a);
            cnt++;
            input.close();
            FileWriter file1 = new FileWriter("src/TextFiles/cnt.txt");
            file1.write((cnt) + "");
            file1.close();
            PrintWriter pfile = new PrintWriter("src/Bills/Bill" + cnt);
            pfile.write("**************Bill************\n");

            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < listaaa.size(); i++) {
                s1.append(listaaa.get(i)).append(" ");
            }

            pfile.write("Books Taken: " + s1 + "\n");
            pfile.write("Total Price: " + total + "\n");
            pfile.write("Date" + isCreated.getDate() + "\n");
            pfile.close();
        } catch (FileNotFoundException e1) {
            return "Bill is not created";
        } catch (IOException e1) {
            return "Bill is not created";
        }
        return "Bill is Printed";
    }

//..............................................................................

<<<<<<< HEAD
    public static ArrayList<Bill> getBills(Bill isCreated) {
        ArrayList<Bill> listBooks = new ArrayList<Bill>();
=======
    private static String lastUsedPath;
    public static ArrayList<E_Bill> getBills( E_Bill isCreated) {



        ArrayList<E_Bill> listBooks = new ArrayList<E_Bill>();
>>>>>>> dd8f93dfd29b8d42470fc6a82fe12ae2ef365139
        FileInputStream fis;
        ObjectInputStream objis = null;
        try {
            fis = new FileInputStream(lastUsedPath);
            objis = new ObjectInputStream(fis);

            E_Bill bill=new E_Bill();
            while (true) {
                try {
<<<<<<< HEAD
                    Bill obj = (Bill) objis.readObject();
                    listBooks.add(obj);
=======
                    bill = (E_Bill) objis.readObject();
                    listBooks.add(bill);
>>>>>>> dd8f93dfd29b8d42470fc6a82fe12ae2ef365139
                } catch (EOFException e) {
                    break;
                }
            }
            listBooks.add(isCreated);

            objis.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Check if objis is not null before attempting to close it
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

    public static void setLastUsedPath(String path) {
        lastUsedPath = path;
    }

    public static void createNewBill(ArrayList<Bill> listBooks, ArrayList<String> listaaa11) {

        FileOutputStream out;
        try {
            out = new FileOutputStream("src/EncodedInformation/Bills.dat");
            ObjectOutputStream objout = new ObjectOutputStream(out);

            for (int i = 0; i < listBooks.size(); i++) {
                objout.writeObject(listBooks.get(i));

            }

            for (int i = 0; i < listaaa11.size(); i++) {
                BookFunctionalities.UpdateBookQuantity(listaaa11.get(i));
            }
            listaaa11.clear();
            objout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }

    }


//.................................................................

    public static boolean checkOutOfStock(Zh_Books book) {
        if (book.getQuanity()>0){
            return true;
        }
        else {
            return false;
        }
    }
}