package TestFx.Controllers;

import com.example.Controllers.LoginController;
import com.example.Model.Books.Books;
import com.example.View.Login.LoginView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PrintBillFXTest extends ApplicationTest {
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

        // Login
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());
        clickOn(loginView.getUsernametextFiled()).write("David");
        clickOn(loginView.getPassswrdField()).write("111");
        clickOn("#Submit");
        WaitForAsyncUtils.waitForFxEvents();

        // Create a bill
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#createBill").queryAll().isEmpty());
        clickOn("#createBill");
        WaitForAsyncUtils.waitForFxEvents();

        // Add a book to the bill
        TableView<Books> userTable = lookup("#usertableId").query();
        interact(() -> userTable.getSelectionModel().select(0));
        clickOn("#addToBill");

        // Show the bill
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#showBill").queryAll().isEmpty());
        interact(() -> clickOn("#showBill"));

        // Choose a date in the DatePicker
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#yourDatePickerId").queryAll().isEmpty());

        DatePicker datePicker = lookup("#yourDatePickerId").query();
        LocalDate dateToSet = LocalDate.of(2024, Month.JANUARY, 15);

// Open the DatePicker popup
        interact(() -> datePicker.show());

// Click on the day in the calendar
        interact(() -> datePicker.getEditor().clear());
        interact(() -> datePicker.getEditor().setText(dateToSet.format(DateTimeFormatter.ISO_LOCAL_DATE)));
        WaitForAsyncUtils.waitForFxEvents();

        System.out.println("Selected Date: " + datePicker.getValue());

        // Print the bill
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#printBill").queryAll().isEmpty());
        interact(() -> clickOn("#printBill"));
        WaitForAsyncUtils.waitForFxEvents();

        // Add assertions or further testing based on the expected behavior
        // For example, check if the printing process is successful
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#lol").queryAll().isEmpty());
    }
}
