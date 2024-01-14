package TestFx.Controllers.Librarian;

import com.example.Controllers.LoginController;
import com.example.Model.Books.Books;
import com.example.View.Librarian.LibrarianTableView;
import com.example.View.Librarian.LibrarianView;
import com.example.View.Librarian.ShowBill;
import com.example.View.Login.LoginView;
import javafx.application.Platform;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import javax.swing.*;
import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

public class ClearFXTest extends ApplicationTest {
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

    }

    @Test
    public void testEmptyFieldsScenario() throws TimeoutException, FileNotFoundException, ClassNotFoundException {
        assertNotNull(loginView);

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());

        clickOn(loginView.getUsernametextFiled()).write("David");
        clickOn(loginView.getPassswrdField()).write("111");

        clickOn("#Submit");

        WaitForAsyncUtils.waitForFxEvents();

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#createBill").queryAll().isEmpty());
        clickOn("#createBill");
        WaitForAsyncUtils.waitForFxEvents();

        TableView<Books> userTable = lookup("#usertableId").query();
        interact(() -> userTable.getSelectionModel().select(2));
        clickOn("#addToBill");

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#showBill").queryAll().isEmpty());
        interact(() -> clickOn("#showBill"));
        WaitForAsyncUtils.waitForFxEvents();


        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#ClearBill").queryAll().isEmpty());
        interact(() -> {
            clickOn("#ClearBill");
            WaitForAsyncUtils.waitForFxEvents();
        });



        LibrarianTableView librarianTableView = new LibrarianTableView();

        ArrayList<Books> booksOfBillCopy = librarianTableView.getBooksOfBill();

        assertEquals(booksOfBillCopy.size(),0);
//
//        WaitForAsyncUtils.waitFor(6, TimeUnit.SECONDS, () -> !lookup("#lol").queryAll().isEmpty());



    }



}
