package Librarian;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BillFunctionalities {


    public static String PrintFile(ArrayList<String> bookNames, Bill isCreated) {
        System.out.println(isCreated.getPrice());
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
            pfile.write("*****Bill*****\n");

            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < bookNames.size(); i++) {
                s1.append(bookNames.get(i)).append(" ");
            }

            pfile.write("Books Taken: " + s1 + "\n");
            pfile.write("Total Price: " + isCreated.getPrice() + "\n");
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


    public static ArrayList<Bill> getBills( Bill isCreated, String path) {

        ArrayList<Bill> listBooks = new ArrayList<Bill>();
        FileInputStream fis;
        ObjectInputStream objis = null;
        try {
            fis = new FileInputStream(path);
            objis = new ObjectInputStream(fis);

            Bill bill=new Bill();
            while (true) {
                try {
                    bill = (Bill) objis.readObject();
                    listBooks.add(bill);
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



    public static void createNewBill(ArrayList<Bill> listBooks, ArrayList<Zh_Books> bookOfBill) {

            ArrayList<String> listOfIsbn = new ArrayList<>();
        FileOutputStream out;
        try {
            out = new FileOutputStream("src/EncodedInformation/Bills.dat");
            ObjectOutputStream objout = new ObjectOutputStream(out);

            for (int i = 0; i < listBooks.size(); i++) {
                objout.writeObject(listBooks.get(i));
            }



            for (int i = 0; i < bookOfBill.size(); i++) {
                BookFunctionalities.UpdateBookQuantity(bookOfBill.get(i).getISBN());

            }
            bookOfBill.clear();

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


    public static double CalculateTotalPrice(ArrayList<Zh_Books> listBooks)
    {
        double totalPrice=0;
      for(Zh_Books books:listBooks)
      {
        totalPrice+=books.getPrice();
      }
        return totalPrice;
    }

    public static ArrayList<String> getBookNames(ArrayList<Zh_Books> books) {
        ArrayList<String> bookNames = new ArrayList<>();

        for (Zh_Books book : books) {
            bookNames.add(book.getTitle());
        }
        return bookNames;
    }


}