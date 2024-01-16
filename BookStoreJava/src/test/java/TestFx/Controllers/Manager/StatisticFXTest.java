package TestFx.Controllers.Manager;

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
import static org.testfx.api.FxAssert.verifyThat;
//import static org.testfx.matcher.control.DatePickerMatchers.hasDate;

public class StatisticFXTest extends ApplicationTest {
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
        clickOn(loginView.getUsernametextFiled()).write("Greisi");
        clickOn(loginView.getPassswrdField()).write("222");
        clickOn("#Submit");
        WaitForAsyncUtils.waitForFxEvents();



        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Statistic").queryAll().isEmpty());
        clickOn("#Statistic");
        WaitForAsyncUtils.waitForFxEvents();


        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Back").queryAll().isEmpty());
        clickOn("#Back");
        WaitForAsyncUtils.waitForFxEvents();



    }
}
