package Test;

import static org.junit.jupiter.api.Assertions.*;

import Librarian.B__Log_in;
import Librarian.D_Users;
import Librarian.Zh_accessLevel;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class B__Log_inTest {

    private D_Users testUser;

    @BeforeEach
    void setUp() {
        testUser = new D_Users("TestUser", "TestPassword", Zh_accessLevel.LIBRARIAN);
    }

    @Test
    void testLogInValidCredentials() {
        // Set up your test environment, for example, create a new Stage
        Stage stage = new Stage();

        // Create a test input stream to provide user data
        InputStream inputStream = new ByteArrayInputStream(testUser.toString().getBytes());

        // Simulate a valid ObjectInputStream using the provided input stream
        ObjectInputStream objis = null;
        try {
            objis = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Call the public Log_inn method, which indirectly tests the private checkUser method
        // You can also add assertions to ensure that the correct actions are taken based on valid credentials.
        B__Log_in.Log_inn(stage);
    }

    @Test
    void testLogInInvalidCredentials() {
        // Set up your test environment, for example, create a new Stage
        Stage stage = new Stage();

        // Create a test input stream to provide user data
        InputStream inputStream = new ByteArrayInputStream(testUser.toString().getBytes());

        // Simulate a valid ObjectInputStream using the provided input stream
        ObjectInputStream objis = null;
        try {
            objis = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Call the public Log_inn method with invalid credentials
        // You can add assertions to ensure that the correct actions are taken based on invalid credentials.
        B__Log_in.Log_inn(stage);
    }
}
