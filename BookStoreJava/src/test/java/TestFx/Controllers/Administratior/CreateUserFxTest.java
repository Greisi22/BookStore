package TestFx.Controllers.Administratior;

import com.example.Controllers.LoginController;
import com.example.Model.Userss.UserService;
import com.example.Model.Userss.Users;
import com.example.View.Login.LoginView;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.robot.Motion;
import org.testfx.util.WaitForAsyncUtils;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateUserFxTest extends ApplicationTest {
    private LoginView loginView;
    private LoginController loginController;


    @Override
    public void start(Stage primaryStage) {
        loginView = new LoginView();
        loginController = new LoginController(loginView);
        loginView.setLoginController(loginController);
        loginView.start(primaryStage);
    }

    @Test
    public void testEmptyFieldsScenario() throws TimeoutException, FileNotFoundException, ClassNotFoundException {
        assertNotNull(loginView);
        UserService userService = new UserService();
        ArrayList<Users> firstUserse = userService.getUsers("src/main/java/com/example/EncodedInformation/Users.dat");
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());
        clickOn(loginView.getUsernametextFiled()).write("Erisa");
        clickOn(loginView.getPassswrdField()).write("999");
        clickOn("#Submit");
        WaitForAsyncUtils.waitForFxEvents();

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#signup").queryAll().isEmpty());
        clickOn("#signup");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#firstname").write("Era");
        clickOn("#lastname").write("Mulla");
        clickOn("#email").write("emulla21@epoka.edu.al");
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#datapicker").queryAll().isEmpty());
        DatePicker datePicker = lookup("#datapicker").query();
        LocalDate dateToSet = LocalDate.of(2024, Month.JANUARY, 15);
        interact(() -> datePicker.setValue(dateToSet));
        clickOn("#password").write("password");
        clickOn("#salery").write("7500");
        clickOn("#phone").write("0687654321");
        clickOn("#librarian");


        clickOn("#submit");

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup(".alert").queryAll().isEmpty());

        clickOn(".alert .button");

        ArrayList<Users> secondUsers = userService.getUsers("src/main/java/com/example/EncodedInformation/Users.dat");
        assertEquals(firstUserse.size() + 1, secondUsers.size());

    }
}
