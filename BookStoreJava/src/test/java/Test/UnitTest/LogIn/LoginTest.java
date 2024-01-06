package Test.UnitTest.LogIn;



import com.example.Model.Login.AccessLevel;
import com.example.Model.Login.LogInFunctionalities;
import com.example.Model.Login.ResultType;
import com.example.Model.Userss.Users;
import com.example.View.Librarian.FileNotFoundExceptionCustom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.lang.constant.Constable;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    private static LogInFunctionalities lg;
    private  final String filePath = "src/main/java/com/example/EncodedInformation/Users.dat";
    @BeforeAll
    static void createLogIn() {
        lg = new LogInFunctionalities();
    }

    @Test
    void testFileNotExistCondition() {
        lg = new LogInFunctionalities();
        String nonExistingFilePath = "non_existing_file_path";
        assertThrows(FileNotFoundExceptionCustom.class, () -> lg.checkUser("username", "password", nonExistingFilePath));
    }
    @ParameterizedTest
    @CsvSource({
            "David,111",
            "Greisi,222"
    })
    void testValidCredentials(String username, String password) throws IOException {
        lg = new LogInFunctionalities();
        Users expected = lg.checkUser(username, password, filePath);
        assertNotNull(expected);
        assertEquals(username, expected.getFirstName());
        assertEquals(password, expected.getPassword());
    }

    //     Test for Invalid Arguments
    @ParameterizedTest
    @CsvSource({
            "Prava1, Prova1",
            "David, 11",
            "Greisi, 111",
            "Erisa, 222",
            "'',''"
    })
    void testInvalidArguments(String username, String password) throws IOException {
        Users result = lg.checkUser(username, password, filePath);
        assertNull(result);
    }


    // Test for Special Characters in Username and Password
    @Test
    void testSpecialCharacters() throws IOException {
        String username = "userWithSpecialChar@!";
        String password = " passwordWith#SpecialChar";
        Users result = lg.checkUser(username, password, filePath);
        assertNull(result);
    }

    @Test
    public void testValidLibrarianLogin() throws IOException {

        lg = Mockito.mock(LogInFunctionalities.class);
        Users librarianUser = new Users("Davidii", "111", AccessLevel.LIBRARIAN);
        Mockito.when(lg.checkUser("Davidii", "111", "lol"))
                .thenReturn(librarianUser);

        LogInFunctionalities   logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("Davidii", "111",  "lol");
        assertEquals(Arrays.asList(ResultType.LIBRARIAN_LOGIN, "Davidii"), result);
    }

    @Test
    public void testValidManagerLogin() throws IOException {
        lg = Mockito.mock(LogInFunctionalities.class);
        Users librarianUser = new Users("Davidii", "111", AccessLevel.MANAGER);
        Mockito.when(lg.checkUser("Davidii", "111", "lol"))
                .thenReturn(librarianUser);

        LogInFunctionalities   logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("Davidii", "111",  "lol");
        assertEquals(Arrays.asList(ResultType.MANAGER_LOGIN, "Davidii"), result);
    }

    @Test
    public void testValidAdministratorLogin() throws IOException {
        lg = Mockito.mock(LogInFunctionalities.class);
        Users librarianUser = new Users("Davidii", "111", AccessLevel.ADMINISTRATOR);
        Mockito.when(lg.checkUser("Davidii", "111", "lol"))
                .thenReturn(librarianUser);

        LogInFunctionalities   logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("Davidii", "111",  "lol");
        assertEquals(Arrays.asList(ResultType.ADMIN_LOGIN, "Davidii"), result);
    }

    @Test
    public void testIncorrectUsernameOrPassword() throws IOException {
        lg = Mockito.mock(LogInFunctionalities.class);
        Mockito.when(lg.checkUser("InvalidUser", "InvalidPassword", "lol"))
                .thenReturn(null);

        LogInFunctionalities logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("InvalidUser", "InvalidPassword", "lol");
        assertEquals(Arrays.asList(ResultType.INCORRECT_USER, "Incorrect Userername or password"), result);
    }

    @Test
    public void testIncorrectPassword() throws IOException {
        lg = Mockito.mock(LogInFunctionalities.class);
        Mockito.when(lg.checkUser("David", "InvalidPassword", "lol"))
                .thenReturn(null);

        LogInFunctionalities logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("InvalidUser", "InvalidPassword", "lol");
        assertEquals(Arrays.asList(ResultType.INCORRECT_USER, "Incorrect Userername or password"), result);
    }




    @Test
    public void testIOExceptionHandling() throws IOException {
        lg = Mockito.mock(LogInFunctionalities.class);
        Mockito.when(lg.checkUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenThrow(new IOException());

        LogInFunctionalities logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("Davidii", "111", "lol");
        assertEquals(Arrays.asList(ResultType.TRY_AGAIN, ""), result);
    }




}