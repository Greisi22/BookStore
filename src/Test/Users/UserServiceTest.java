package Test.Users;

import Model.Books.BookService;
import Model.Books.Zh_Books;
import Model.Login.Zh_accessLevel;
import Model.Users.D_Users;
import Model.Users.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @TempDir
    static File tempFolder;


    @Test
    void testGetBooks() throws IOException {
        File tempFile = new File(tempFolder, "testUsers.dat");
        UserService userService = new UserService();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            D_Users userGreisi = new D_Users();
            userGreisi.setFirstName("Greisi");
            userGreisi.setPassword("222");
            userGreisi.setAccesLevel(Zh_accessLevel.MANAGER);

            D_Users userDavid = new D_Users();
            userDavid.setFirstName("David");
            userDavid.setPassword("111");
            userDavid.setAccesLevel(Zh_accessLevel.LIBRARIAN);
            objectOutputStream.writeObject(userDavid);
            objectOutputStream.writeObject(userGreisi);
        }
        ArrayList<D_Users> userList = userService.getUsers("testUsers.dat");
        assertEquals(2, userList.size());
        assertEquals("David", userList.get(0).getFirstName());
        assertEquals("Greisi", userList.get(1).getFirstName());
        assertEquals("222", userList.get(1).getPassword());
    }

    @Test
    void testWriteInFIle() throws IOException {
        Zh_Books book1 = new Zh_Books("Book 1", "Author 1", 2023);
        Zh_Books book2 = new Zh_Books("Book 2", "Author 2", 2024);
        ArrayList<Zh_Books> booksList = new ArrayList<>();
        booksList.add(book1);
        booksList.add(book2);
        BookService bookService = new BookService();
        bookService.writeBooksInFile(booksList, "testBooks.dat");
        booksList.add(book1);
        booksList.add(book2);
        ArrayList<Zh_Books> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream("testBooks.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            Zh_Books obj = new Zh_Books();
            while (true) {
                obj = ((Zh_Books) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            assertEquals(list.size(), booksList.size());
        }


    }

}
