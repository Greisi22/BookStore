package Test.Librarian.LogIn;

import Administator.UserFunctionalities;
import Librarian.D_Users;
import Librarian.FileNotFoundExceptionCustom;
import Librarian.LogInFunctionalities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

}
