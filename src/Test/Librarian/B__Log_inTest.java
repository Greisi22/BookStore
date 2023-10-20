package Test.Librarian;

import Librarian.B__Log_in;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class B__Log_inTest {

    @Test
    public void testLogInnWithValidCredentials() {
        Stage stage = new Stage();
        Pane pane = new Pane();
        TextField usernametextFiled = new TextField();
        PasswordField PassswrdField = new PasswordField();

        usernametextFiled.setText("valid_username");
        PassswrdField.setText("valid_password");

        // Call the Log_inn method and assert the expected behavior
        B__Log_in.Log_inn(stage);

        // Add your assertions here to check the behavior, e.g., if a new scene is set or not
        Scene scene = stage.getScene();
        assertNotNull(scene);
        // You can add more specific assertions here to validate the behavior.
    }

    @Test
    public void testLogInnWithInvalidCredentials() {
        Stage stage = new Stage();
        Pane pane = new Pane();
        TextField usernametextFiled = new TextField();
        PasswordField PassswrdField = new PasswordField();

        usernametextFiled.setText("invalid_username");
        PassswrdField.setText("invalid_password");

        // Call the Log_inn method and assert the expected behavior for invalid credentials
        B__Log_in.Log_inn(stage);

        // Add your assertions here to check the behavior for invalid credentials
        Scene scene = stage.getScene();
        assertNull(scene);
        // You can add more specific assertions here to validate the behavior.
    }


    static class CA__Librarian_ViewTest {

        @Test
        void stage() {
        }

        @Test
        void showTable() {
        }
    }
}
