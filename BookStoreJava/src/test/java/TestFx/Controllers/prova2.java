package TestFx.Controllers;

import com.example.Controllers.LoginController;
import com.example.Model.Books.Books;
import com.example.View.Login.LoginView;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class prova2 extends ApplicationTest {
    private LoginView loginView;
    private LoginController loginController;
    private Stage primaryStage;

    private Pane pane;

    @Override
    public void start(Stage primaryStage) {

        loginView = new LoginView();

        loginController = new LoginController(loginView);
        loginView.setLoginController(loginController);
        loginView.start(primaryStage);
//        loginView.setPane(new Pane());
//        pane = loginView.LogInViewPage();
//        this.primaryStage = primaryStage;
//        this.primaryStage.setScene(new Scene(pane, 700, 500));
//        this.primaryStage.show();
    }

    @Test
    public void testEmptyFieldsScenario() throws TimeoutException, FileNotFoundException, ClassNotFoundException {
        assertNotNull(loginView);

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());

        clickOn(loginView.getUsernametextFiled()).write("David");
        clickOn(loginView.getPassswrdField()).write("111");

        clickOn("#Submit");

        WaitForAsyncUtils.waitForFxEvents();

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#addToBill").queryAll().isEmpty());
        clickOn("#addToBill");
        WaitForAsyncUtils.waitForFxEvents();

        TableView<Books> userTable = lookup("#usertableId").query();
        interact(() -> userTable.getSelectionModel().select(0));
        clickOn("#addToBill");
        clickOn("#showBill");



        WaitForAsyncUtils.waitFor(10, TimeUnit.SECONDS, () -> !lookup("#lol").queryAll().isEmpty());
//
    }
}
