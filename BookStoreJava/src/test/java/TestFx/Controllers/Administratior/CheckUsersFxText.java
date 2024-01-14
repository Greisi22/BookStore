package TestFx.Controllers.Administratior;

import com.example.Controllers.LoginController;
import com.example.Model.Books.Books;
import com.example.Model.Userss.UserService;
import com.example.Model.Userss.Users;
import com.example.View.Administator.Userss;
import com.example.View.Login.LoginView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckUsersFxText extends ApplicationTest {
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


        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());
        clickOn(loginView.getUsernametextFiled()).write("Erisa");
        clickOn(loginView.getPassswrdField()).write("999");
        clickOn("#Submit");
        WaitForAsyncUtils.waitForFxEvents();

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#users").queryAll().isEmpty());
        clickOn("#users");
        WaitForAsyncUtils.waitForFxEvents();

        UserService userService = new UserService();
        ArrayList<Users> Users = userService.getUsers("src/main/java/com/example/EncodedInformation/Users.dat");

        Userss userss = new Userss();
        TableColumn<Books, ?> titleColumn = userss.getFirstName();
        String firstName = titleColumn.getCellData(0).toString();
        assertEquals(firstName, Users.get(0).getFirstName());
    }
}
