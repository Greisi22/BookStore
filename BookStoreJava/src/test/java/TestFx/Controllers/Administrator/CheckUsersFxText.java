package TestFx.Controllers.Administrator;

import com.example.Controllers.LoginController;
import com.example.View.Login.LoginView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
    }
}
