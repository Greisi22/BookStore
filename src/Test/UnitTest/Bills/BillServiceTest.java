package Test.UnitTest.Bills;

import Model.Bills.Bill;
import Model.Bills.BillService;
import Model.Bills.MyDate;
import Model.Books.Books;
import Model.Login.AccessLevel;
import Model.Users.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillServiceTest {


    @TempDir
    static File tempFolder;

    @TempDir
    static Path tempDir;

    @Test
    void printFileTest() {
        String path = tempDir.resolve("cnt.txt").toString();
        String billPath = tempDir.resolve("Bills").toString() + File.separator + "Bill";

        // Create an ArrayList of book names
        ArrayList<String> bookNames = new ArrayList<>();
        bookNames.add("Book1");
        bookNames.add("Book2");

        // Create a Bill instance (you need to initialize it according to your application logic)
        Bill createdBill = new Bill(23, new MyDate(12, 3, 2002));

        String result = BillService.PrintFile(bookNames, createdBill);

        System.out.println("Result: " + result);
        try {
            System.out.println("Content of cnt.txt: " + Files.readString(Path.of(path)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Bill is Printed", result);

    }

    @Test
    void getBillsFromFileTest() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill.dat");

        Bill bill1;
        Bill bill2;

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            bill1 = new Bill(23, new MyDate(12, 3, 2002));
            bill2 = new Bill(25, new MyDate(8, 2, 2002));

            objectOutputStream.writeObject(bill1);
            objectOutputStream.writeObject(bill2);
        }

        ArrayList<Bill> billList = billService.getBillsFromFile(tempFile.getPath());


        assertEquals(2, billList.size());
        assertEquals(23.0, billList.get(0).getPrice());
        assertEquals(new MyDate(8, 2, 2002), billList.get(1).getDate());

        {
        }
    }

    @Test
    void createNewBillTest() throws IOException {
        BillService billService = new BillService();
        File tempFile = new File(tempFolder, "testBill.dat");


        ArrayList<Bill> billList = billService.getBillsFromFile(tempFile.getPath());

        Bill bill = new Bill(20, new MyDate(8, 2, 2002));
        billList.add(bill);
        billService.createNewBill(bill, tempFile.getPath());


        assertEquals(1, billList.size());
        assertEquals(20.0, billList.get(0).getPrice());
        assertEquals(new MyDate(8, 2, 2002), billList.get(0).getDate());

    }

    @Test
    void testWriteAndReadUser() {
        // Create three users
        Users userErisa = new Users();
        userErisa.setFirstName("Erisa");
        userErisa.setPassword("999");
        userErisa.setAccesLevel(AccessLevel.ADMINISTRATOR);

        Users userDavid = new Users();
        userDavid.setFirstName("David");
        userDavid.setPassword("111");
        userDavid.setAccesLevel(AccessLevel.LIBRARIAN);

        Users userGreisi = new Users();
        userGreisi.setFirstName("Greisi");
        userGreisi.setPassword("222");
        userGreisi.setAccesLevel(AccessLevel.MANAGER);

        // Write users to file
        try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("src/EncodedInformation/Users.dat", true))) {
            objout.writeObject(userErisa);
            objout.writeObject(userDavid);
            objout.writeObject(userGreisi);
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception according to your needs
        }

        // Read users from file
        ArrayList<Users> listofUsers = new ArrayList<>();
        try (ObjectInputStream objis = new ObjectInputStream(new FileInputStream("src/EncodedInformation/Users.dat"))) {
            while (true) {
                try {
                    Users obj = (Users) objis.readObject();
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
        for (Users user : listofUsers) {
            System.out.println("User: " + user.getFirstName() + ", Password: " + user.getPassword() + ", Access Level: " + user.getAccesLevel());
        }
    }

    private static MyDate generateRandomDateIn2023() {
        Random random = new Random();
        int randomMonth = random.nextInt(12) + 1; // 1 to 12 (inclusive)
        int randomDay = random.nextInt(28) + 1;   // 1 to 28 (inclusive)
        int year = 2023;

        return new MyDate(randomMonth, randomDay, year);
    }


    @Test
    void putBooksInFIle() {
        ArrayList<Books> booksList = new ArrayList<>();
//
//        // Create 50 books with random months and quantities in the year 2023
        for (int i = 1; i <= 12; i++) {
            Books book = new Books();
            book.setTitle("Book" + i);
            book.setISBN("ISBN" + i);
            book.setDate(new MyDate(i, 1, 2023));
            book.setQuanity(new Random().nextInt(101));
            booksList.add(book);
        }

        try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("src/EncodedInformation/Books.dat", true))) {
            for (Books bookk : booksList) {
                objout.writeObject(bookk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Books> listofUsers = new ArrayList<>();
        try (ObjectInputStream objis = new ObjectInputStream(new FileInputStream("src/EncodedInformation/Books.dat"))) {
            while (true) {
                try {
                    Books obj = (Books) objis.readObject();
                    listofUsers.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        for (Books user : listofUsers) {
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
            bill.setDate(new MyDate(i, 1, 2023));
            bill.setBookquantity(new Random().nextInt(101));
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

