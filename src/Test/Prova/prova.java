package Test.Prova;

import Model.Bills.Bill;
import Model.Bills.Zh_MyDate;
import Model.Books.Zh_Books;
import Model.Login.Zh_accessLevel;
import Model.Users.D_Users;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class prova {

    @Test
    void testWriteAndReadUser() {
        // Create three users
        D_Users userErisa = new D_Users();
        userErisa.setFirstName("Erisa");
        userErisa.setPassword("999");
        userErisa.setAccesLevel(Zh_accessLevel.ADMINISTRATOR);

        D_Users userDavid = new D_Users();
        userDavid.setFirstName("David");
        userDavid.setPassword("111");
        userDavid.setAccesLevel(Zh_accessLevel.LIBRARIAN);

        D_Users userGreisi = new D_Users();
        userGreisi.setFirstName("Greisi");
        userGreisi.setPassword("222");
        userGreisi.setAccesLevel(Zh_accessLevel.MANAGER);

        // Write users to file
        try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("src/EncodedInformation/Users.dat", true))) {
            objout.writeObject(userErisa);
            objout.writeObject(userDavid);
            objout.writeObject(userGreisi);
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception according to your needs
        }

        // Read users from file
        ArrayList<D_Users> listofUsers = new ArrayList<>();
        try (ObjectInputStream objis = new ObjectInputStream(new FileInputStream("src/EncodedInformation/Users.dat"))) {
            while (true) {
                try {
                    D_Users obj = (D_Users) objis.readObject();
                    listofUsers.add(obj);
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();  // Handle the exception according to your needs
        }

        // Print user information
        for (D_Users user : listofUsers) {
            System.out.println("User: " + user.getFirstName() + ", Password: " + user.getPassword() + ", Access Level: " + user.getAccesLevel());
        }
    }

    private static Zh_MyDate generateRandomDateIn2023() {
        Random random = new Random();
        int randomMonth = random.nextInt(12) + 1; // 1 to 12 (inclusive)
        int randomDay = random.nextInt(28) + 1;   // 1 to 28 (inclusive)
        int year = 2023;

        return new Zh_MyDate(randomMonth, randomDay, year);
    }


    @Test
    void putBooksInFIle() {
        ArrayList<Zh_Books> booksList = new ArrayList<>();
//
//        // Create 50 books with random months and quantities in the year 2023
        for (int i = 1; i <= 12; i++) {
            Zh_Books book = new Zh_Books();
            book.setTitle("Book" + i);
            book.setISBN("ISBN" + i);
            book.setDate(new Zh_MyDate(i, 1, 2023));
            book.setQuanity(new Random().nextInt(101));
            booksList.add(book);
        }

        try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("src/EncodedInformation/Books.dat", true))) {
            for (Zh_Books bookk : booksList) {
                objout.writeObject(bookk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Zh_Books> listofUsers = new ArrayList<>();
        try (ObjectInputStream objis = new ObjectInputStream(new FileInputStream("src/EncodedInformation/Books.dat"))) {
            while (true) {
                try {
                    Zh_Books obj = (Zh_Books) objis.readObject();
                    listofUsers.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        for (Zh_Books user : listofUsers) {
            System.out.println(user.getTitle() + " "+ user.getQuanity()+ " "+ user.getDate() );
        }

    }



    @Test
    void putBillsInFIle() {
        ArrayList<Bill> billList = new ArrayList<>();
//
//        // Create 50 books with random months and quantities in the year 2023
        for (int i = 1; i <= 12; i++) {
            Bill bill = new Bill();
            bill.setDate(new Zh_MyDate(i, 1, 2023));
            bill.setBookquantity(new Random().nextInt(101));
            bill.setPrice(new Random().nextInt(101));
            bill.setLibrarian_Name("Name" + i);
            bill.setSurname("Surname" + i);
            billList.add(bill);
        }

        try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("src/EncodedInformation/Bills.dat", true))) {
            for (Bill billl : billList) {
                objout.writeObject(billl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Bill> listofUsers = new ArrayList<>();
        try (ObjectInputStream objis = new ObjectInputStream(new FileInputStream("src/EncodedInformation/Bills.dat"))) {
            while (true) {
                try {
                    Bill obj = (Bill) objis.readObject();
                    listofUsers.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        for (Bill user : listofUsers) {
            System.out.println( );
        }

    }

}
