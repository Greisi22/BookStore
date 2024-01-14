package TestFx.Controllers;

import com.example.Controllers.LoginController;
import com.example.Model.Books.Books;
import com.example.View.Librarian.LibrarianTableView;
import com.example.View.Librarian.LibrarianView;
import com.example.View.Librarian.ShowBill;
import com.example.View.Login.LoginView;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest extends ApplicationTest {
    private LoginView loginView;
    private LoginController loginController;
    private Stage primaryStage;

    private Pane pane;

    @Override
    public void start(Stage primaryStage) {
        loginView = new LoginView();
        loginController = new LoginController(loginView);
        loginView.setLoginController(loginController);
        loginView.setPane(new Pane());
        pane = loginView.LogInViewPage();
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(new Scene(pane, 700, 500));
        this.primaryStage.show();
    }

    @Test
    public void testEmptyFieldsScenario() throws TimeoutException, FileNotFoundException, ClassNotFoundException {
        assertNotNull(loginView);

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());

        clickOn(loginView.getUsernametextFiled()).write("David");
        clickOn(loginView.getPassswrdField()).write("111");

        clickOn("#Submit");

        WaitForAsyncUtils.waitForFxEvents();

        // Perform actions with LibrarianView on FX Application Thread
        Platform.runLater(() -> {
            try {
                // Actions in LibrarianView
                LibrarianView librarianView = new LibrarianView();
                Pane librarianPane = librarianView.getLibrarianView();
                primaryStage.setScene(new Scene(librarianPane, 700, 500));
                primaryStage.show();

                // Transition to LibrarianTableView
                LibrarianTableView librarianTableView = new LibrarianTableView();
                Pane librarianViewPane = librarianTableView.showTable();

                primaryStage.setScene(new Scene(librarianViewPane, 700, 500));
                primaryStage.show();

                // Wait for the "addToBill" button to appear
                assertTrue(lookup("#addToBill").tryQuery().isPresent(), "Add to Bill button should be present");

                // Select "Title" in the ChoiceBox
                clickOn("#choiceBox").clickOn("Title");

                // Type into the TextField
                clickOn("#textField22").write("Book Title");

                // Click on "addToBill" button
                clickOn("#addToBill");

                // Verify that the BooksOfBill list has been updated
                ArrayList<Books> getBooksOfBill = librarianTableView.getBooksOfBill();
                assertEquals(1, getBooksOfBill.size(), "One book should be added to the bill");

                // Click on "Show Bill" button
                clickOn("#showBill");



                // For example, verify that the "Show Bill" button is present
                assertTrue(lookup("#showBill").tryQuery().isPresent(), "Show Bill button should be present");
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
