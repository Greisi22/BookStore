package com.example.Model.Bills;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BillService {


  private static    BillService billService = new BillService();
    public static String PrintFile(ArrayList<String> bookNames, Bill isCreated) {

        File file = new File("src/main/java/com/example/TextFiles/cnt.txt");
        try {
            Scanner input = new Scanner(file);
            String a = input.next();
            int cnt = Integer.parseInt(a);
            cnt++;
            input.close();
            FileWriter file1 = new FileWriter("src/main/java/com/example/TextFiles/cnt.txt");
            file1.write((cnt) + "");
            file1.close();
            PrintWriter pfile = new PrintWriter("src/main/java/com/example/Bills/Bill" + cnt);
            pfile.write("**Bill**\n");

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




//......................................................................


    public <E> ArrayList<E> getBillsFromFile(String path) {
        ArrayList<E> listofBooks = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream objis = new ObjectInputStream(fis);

            Bill obj = new Bill();
            while (true) {
                obj = ((Bill) objis.readObject());
                listofBooks.add((E) obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            System.out.println(e1);
        }

        return listofBooks;
    }



    public static void createNewBill(Bill newBill, String path){
        if(newBill!= null){
            ArrayList<Bill> listOfBills = new ArrayList<>();
            FileOutputStream out;
            try {
                out = new FileOutputStream(path);
                ObjectOutputStream objout = new ObjectOutputStream(out);
                listOfBills=billService.getBillsFromFile(path);
                listOfBills.add(newBill);
                for (int i = 0; i < listOfBills.size(); i++) {
                    objout.writeObject(listOfBills.get(i));
                    System.out.println(listOfBills.get(i).getBook_name());
                }
                listOfBills.clear();
                objout.close();
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }






}