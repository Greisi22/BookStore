package Test.UnitTest.Users;

import Model.Books.BookService;
import Model.Books.Zh_Books;
import Model.Login.Zh_accessLevel;
import Model.Users.D_Users;
import Model.Users.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private static File tempFile;

    @TempDir
    static File tempFolder;

    @BeforeEach
    void createFile() {
        tempFile = new File(tempFolder, "testUsers.dat");
    }

    @AfterEach
    void destroyFile() {
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }
    @Test
    void testGetUser() throws IOException {
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

        ArrayList<D_Users> userList = userService.getUsers(tempFile.getPath());
        assertEquals(2, userList.size());
        assertEquals("David", userList.get(0).getFirstName());
        assertEquals("Greisi", userList.get(1).getFirstName());
        assertEquals("222", userList.get(1).getPassword());
    }

    @Test
    void testGetUserEmptyFile() throws IOException {
        UserService userService = new UserService();
        ArrayList<D_Users> userList = userService.getUsers(tempFile.getPath());
        assertTrue(userList.isEmpty(), "User list should be empty for an empty file");
    }

    @Test
    void testWriteInFIle() throws IOException {
        D_Users userGreisi = new D_Users();
        userGreisi.setFirstName("Greisi");
        userGreisi.setPassword("222");
        userGreisi.setAccesLevel(Zh_accessLevel.MANAGER);

        D_Users userDavid = new D_Users();
        userDavid.setFirstName("David");
        userDavid.setPassword("111");
        userDavid.setAccesLevel(Zh_accessLevel.LIBRARIAN);
        ArrayList<D_Users> userList = new ArrayList<>();
        userList.add(userDavid);
        userList.add(userGreisi);
        UserService userService = new UserService();
        userService.writeUsersInFile(userList, "testBooks.dat");
        userList.add(userDavid);
        userList.add(userGreisi);
        ArrayList<D_Users> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream("testBooks.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            D_Users obj = new D_Users();
            while (true) {
                obj = ((D_Users) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            assertEquals(list.size(), userList.size());
        }


    }


    @Test
    void testWriteInFIleIfEmtyArray() throws IOException {
        ArrayList<D_Users> userList = new ArrayList<>();
        UserService userService = new UserService();
        userService.writeUsersInFile(userList, "testBooks.dat");
        ArrayList<D_Users> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream("testBooks.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            D_Users obj = new D_Users();
            while (true) {
                obj = ((D_Users) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            assertEquals(list.size(), userList.size());
        }



    }
}