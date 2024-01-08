package TestFx.Controllers;

import com.example.Controllers.LoginController;
import com.example.View.Login.LoginView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;


public class LoginControllerTest extends ApplicationTest {
    private LoginView loginView;
    private LoginController loginController ;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        loginView = new LoginView();
        loginController = new LoginController(loginView);
        loginView.setLoginController(loginController);
        loginView.setPane(new Pane());
        Pane pane = loginView.LogInViewPage();
        primaryStage.setScene(new Scene(pane , 700, 500));
        primaryStage.show();
    }

    @Test
    public void testEmptyFieldsScenario() throws TimeoutException {
        assertNotNull(loginView);

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());

        clickOn(loginView.getUsernametextFiled()).eraseText(10);
        clickOn(loginView.getPassswrdField()).eraseText(10);

        clickOn("#Submit");

        WaitForAsyncUtils.waitForFxEvents();
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> "Incorrect Userername or password".equals(loginController.getAlert().getContentText()));
    }


}
