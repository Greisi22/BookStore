package Test.IntegrationTest;

import Model.Books.BookFunctionalities;
import Model.Books.BookService;
import Model.Books.Zh_Books;
import Model.Users.D_Users;
import Model.Users.UserFunctionalities;
import Model.Users.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserfunctionalitiesIntegrationTest {
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
    public void testUpdateBook() {

        ArrayList<D_Users> usersListt = new ArrayList<>();
        D_Users user1 = new D_Users();
        D_Users user2 = new D_Users();

        user1.setEmail("greisijaho@gmail.com");
        user1.setFirstName("Greisi");

        user2.setEmail("DavidKeci@gmail.com");
        user2.setFirstName("David");


        usersListt.add(user1);
        usersListt.add(user2);

        UserService userService = new UserService();
        userService.writeUsersInFile(usersListt, tempFile.getPath());

        UserFunctionalities userFunctionalities = new UserFunctionalities(userService);

        D_Users user3 = new D_Users();
        user3.setEmail("greisijaho@gmail.com");
        user3.setFirstName("Oho");

        userFunctionalities.setPath(tempFile.getPath());
        UserFunctionalities.updateUsers(user3);
        ArrayList<D_Users> updatedUsers = userService.getUsers(tempFile.getPath());

        assertEquals( usersListt.size(), updatedUsers.size());
        if(updatedUsers.size()>0){
            assertEquals(updatedUsers.get(0).getFirstName(),user3.getFirstName() );
        }

    }

}
