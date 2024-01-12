package TestFx.Controllers.Librarian;

import com.example.Controllers.LoginController;
import com.example.Model.Books.Books;
import com.example.View.Login.LoginView;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.api.FxAssert.verifyThat;
//import static org.testfx.matcher.control.DatePickerMatchers.hasDate;

public class PrintBillFXTest extends ApplicationTest {
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


        interact(() -> lookup("#usertableId").queryTableView().getSelectionModel().select(0));
        clickOn("#addToBill");


        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#showBill").queryAll().isEmpty());
        interact(() -> clickOn("#showBill"));


        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#yourDatePickerId").queryAll().isEmpty());
        DatePicker datePicker = lookup("#yourDatePickerId").query();


        LocalDate dateToSet = LocalDate.of(2024, Month.JANUARY, 15);

        interact(() -> datePicker.setValue(dateToSet));

        System.out.println("Selected Date: " + datePicker.getValue());

        // Print the bill
        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#printBill").queryAll().isEmpty());
        interact(() -> clickOn("#printBill"));

        WaitForAsyncUtils.waitForFxEvents();



    }
}
