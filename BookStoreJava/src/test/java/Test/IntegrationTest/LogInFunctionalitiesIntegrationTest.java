package Test.IntegrationTest;

import com.example.Model.Login.AccessLevel;
import com.example.Model.Login.LogInFunctionalities;
import com.example.Model.Login.ResultType;
import com.example.Model.Userss.Users;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.constant.Constable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogInFunctionalitiesIntegrationTest {
    private static File tempFile;
//    private String path = "src/EncodedInformation/Books.dat";

    @TempDir
    static File tempFolder;

    @BeforeEach
    void createFile() throws IOException {
        tempFile = new File(tempFolder, "testUsers.dat");
        writeTestUsers(tempFile);
    }

    @AfterAll
    void destroyFile() {
        tempFile = new File(tempFolder, "testUsersss.dat");
            // Now delete the file
            if (!tempFile.delete()) {
                System.err.println("Failed to delete the file: " + tempFile.getAbsolutePath());
            }
        }



    @Test
    public void handleLogin() {
        LogInFunctionalities logInFunctionalities = new LogInFunctionalities();


        String username = "testUser";
        String password = "testPassword";
        String path = tempFile.getAbsolutePath();

        List<Constable> result = logInFunctionalities.handleLogin(username, password, path);


        assertEquals(ResultType.LIBRARIAN_LOGIN, result.get(0));
        assertEquals("testUser", result.get(1));

    }

    @Test
    public void handleLoginWithIncorrectCredentials() {
        LogInFunctionalities logInFunctionalities = new LogInFunctionalities();

        String username = "nonexistentUser";
        String password = "wrongPassword";
        String path = tempFile.getAbsolutePath();

        List<Constable> result = logInFunctionalities.handleLogin(username, password, path);

        // Assert the result for incorrect credentials
        assertEquals(ResultType.INCORRECT_USER, result.get(0));
        assertEquals("Incorrect Userername or password", result.get(1));
    }

    private void writeTestUsers(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            Users user1 = new Users("testUser", "LastName1", "email1@example.com", null, "testPassword", 1000,
                    "1234567890", AccessLevel.LIBRARIAN);
            Users user2 = new Users("anotherUser", "LastName2", "email2@example.com", null, "anotherPassword", 1200,
                    "9876543210", AccessLevel.MANAGER);

            oos.writeObject(user1);
            oos.writeObject(user2);
        }
    }

}
