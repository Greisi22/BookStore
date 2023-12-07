package Test.Librarian.LogIn;



import Librarian.*;

import Librarian.D_Users;
import Librarian.FileNotFoundExceptionCustom;
import Librarian.LogInFunctionalities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;

import java.io.IOException;
import java.lang.constant.Constable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    private static LogInFunctionalities lg;
    private  final String filePath = "src/EncodedInformation/Users.dat";
    @BeforeAll
    static void createLogIn() {
        lg = new LogInFunctionalities();
    }

    @ParameterizedTest
    @CsvSource({
            "David, 111",
            "Greisi, 222"
    })
    void testValidCredentials(String username, String password) throws IOException {
        D_Users expected = lg.checkUser(username, password, filePath);
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
        D_Users result = lg.checkUser(username, password, filePath);
        assertNull(result);
    }


    // Test for Special Characters in Username and Password
    @Test
    void testSpecialCharacters() throws IOException {
        String username = "userWithSpecialChar@!";
        String password = " passwordWith#SpecialChar";
        D_Users result = lg.checkUser(username, password, filePath);
        assertNull(result);
    }


    //     Test for File Not Found
    @Test
    void testFileNotExistCondition() {
        String nonExistingFilePath = "non_existing_file_path";
        assertThrows(FileNotFoundExceptionCustom.class, () -> lg.checkUser("username", "password", nonExistingFilePath));
    }






//    @ParameterizedTest
//    @CsvSource({
//            "userWithSpecialChar@!, passwordWith#SpecialChar"
//    })
//    void prova(String username, String password) throws IOException {
//        D_Users users = new D_Users();
//        users.setFirstName("userWithSpecialChar@!");
//        users.setPassword("passwordWith#SpecialChar");
//        UserFunctionalities.appendObjectToFile(users);
//System.out.println(UserFunctionalities.readObjectBinaryFile());
//
//    }







    @Test
    public void testValidLibrarianLogin() throws IOException {

        lg = Mockito.mock(LogInFunctionalities.class);
        D_Users librarianUser = new D_Users("Davidii", "111", Zh_accessLevel.LIBRARIAN);
        Mockito.when(lg.checkUser("Davidii", "111", "lol"))
                .thenReturn(librarianUser);

        LogInFunctionalities   logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("Davidii", "111",  "lol");
        assertEquals(Arrays.asList(ResultType.LIBRARIAN_LOGIN, "Davidii"), result);
    }

    @Test
    public void testValidManagerLogin() throws IOException {
        lg = Mockito.mock(LogInFunctionalities.class);
        D_Users librarianUser = new D_Users("Davidii", "111", Zh_accessLevel.MANAGER);
        Mockito.when(lg.checkUser("Davidii", "111", "lol"))
                .thenReturn(librarianUser);

        LogInFunctionalities   logInFunctionalities = new LogInFunctionalities(lg);
        List<Constable> result = logInFunctionalities.handleLogin("Davidii", "111",  "lol");
        assertEquals(Arrays.asList(ResultType.MANAGER_LOGIN, "Davidii"), result);
    }

    @Test
    public void testValidAdministratorLogin() throws IOException {
        lg = Mockito.mock(LogInFunctionalities.class);
        D_Users librarianUser = new D_Users("Davidii", "111", Zh_accessLevel.ADMINISTRATOR);
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


//    @Test
//    public void testOtherAccessLevels() throws IOException {
//        lg = Mockito.mock(LogInFunctionalities.class);
//        D_Users otherUser = new D_Users("OtherUser", "123", Zh_accessLevel.OTHER);
//        Mockito.when(lg.checkUser("OtherUser", "123", "lol"))
//                .thenReturn(otherUser);
//
//        LogInFunctionalities logInFunctionalities = new LogInFunctionalities(lg);
//        List<Constable> result = logInFunctionalities.handleLogin("OtherUser", "123", "lol");
//        assertEquals(Arrays.asList(ResultType.TRY_AGAIN, "Try Again"), result);
//    }


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