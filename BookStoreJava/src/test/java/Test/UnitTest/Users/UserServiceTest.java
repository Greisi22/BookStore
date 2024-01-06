package Test.UnitTest.Users;


import com.example.Model.Login.AccessLevel;
import com.example.Model.Userss.UserService;
import com.example.Model.Userss.Users;
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
            Users userGreisi = new Users();
            userGreisi.setFirstName("Greisi");
            userGreisi.setPassword("222");
            userGreisi.setAccesLevel(AccessLevel.MANAGER);

            Users userDavid = new Users();
            userDavid.setFirstName("David");
            userDavid.setPassword("111");
            userDavid.setAccesLevel(AccessLevel.LIBRARIAN);

            objectOutputStream.writeObject(userDavid);
            objectOutputStream.writeObject(userGreisi);
        }

        ArrayList<Users> userList = userService.getUsers(tempFile.getPath());
        assertEquals(2, userList.size());
        assertEquals("David", userList.get(0).getFirstName());
        assertEquals("Greisi", userList.get(1).getFirstName());
        assertEquals("222", userList.get(1).getPassword());
    }

    @Test
    void testGetUserEmptyFile() throws IOException {
        UserService userService = new UserService();
        ArrayList<Users> userList = userService.getUsers(tempFile.getPath());
        assertTrue(userList.isEmpty(), "User list should be empty for an empty file");
    }

    @Test
    void testWriteInFIle() throws IOException {
        Users userGreisi = new Users();
        userGreisi.setFirstName("Greisi");
        userGreisi.setPassword("222");
        userGreisi.setAccesLevel(AccessLevel.MANAGER);

        Users userDavid = new Users();
        userDavid.setFirstName("David");
        userDavid.setPassword("111");
        userDavid.setAccesLevel(AccessLevel.LIBRARIAN);
        ArrayList<Users> userList = new ArrayList<>();
        userList.add(userDavid);
        userList.add(userGreisi);
        UserService userService = new UserService();
        userService.writeUsersInFile(userList, "testBooks.dat");
        ArrayList<Users> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream("testBooks.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            Users obj = new Users();
            while (true) {
                obj = ((Users) objis.readObject());
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
        ArrayList<Users> userList = new ArrayList<>();
        UserService userService = new UserService();
        userService.writeUsersInFile(userList, "testBooks.dat");
        ArrayList<Users> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream("testBooks.dat");
            ObjectInputStream objis = new ObjectInputStream(fis);

            Users obj = new Users();
            while (true) {
                obj = ((Users) objis.readObject());
                list.add(obj);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            assertEquals(list.size(), userList.size());
        }



    }
}