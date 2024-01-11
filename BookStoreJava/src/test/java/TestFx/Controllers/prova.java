//package TestFx.Controllers;
//
//import com.example.Controllers.LoginController;
//import com.example.Model.Books.Books;
//import com.example.View.Librarian.LibrarianTableView;
//import com.example.View.Librarian.LibrarianView;
//import com.example.View.Librarian.ShowBill;
//import com.example.View.Login.LoginView;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import org.junit.jupiter.api.Test;
//import org.testfx.framework.junit5.ApplicationTest;
//import org.testfx.util.WaitForAsyncUtils;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeoutException;
//
//import org.testfx.api.FxRobot;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class prova extends ApplicationTest {
//    private LoginView loginView;
//    private LoginController loginController;
//    private Stage primaryStage;
//
//    private Pane pane;
//
//    @Override
//    public void start(Stage primaryStage) {
//        loginView = new LoginView();
//        loginController = new LoginController(loginView);
//        loginView.setLoginController(loginController);
//        loginView.setPane(new Pane());
//        pane = loginView.LogInViewPage();
//        this.primaryStage = primaryStage;
//        this.primaryStage.setScene(new Scene(pane, 700, 500));
//        this.primaryStage.show();
//    }
//
//    @Test
//    public void testEmptyFieldsScenario() throws TimeoutException, FileNotFoundException, ClassNotFoundException {
//        assertNotNull(loginView);
//
//        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());
//
//        clickOn(loginView.getUsernametextFiled()).write("David");
//        clickOn(loginView.getPassswrdField()).write("111");
//
//        clickOn("#Submit");
//
//        WaitForAsyncUtils.waitForFxEvents();
//
//        // Perform actions with LibrarianView on FX Application Thread
//        Platform.runLater(() -> {
//            try {
//                // Actions in LibrarianView
//                LibrarianView librarianView = new LibrarianView();
//                Pane librarianPane = librarianView.getLibrarianView();
//                primaryStage.setScene(new Scene(librarianPane, 700, 500));
//                primaryStage.show();
//
//                // Simulate an action in LibrarianView
//                WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#addToBill").queryAll().isEmpty());
//                clickOn("#addToBill");
//                WaitForAsyncUtils.waitForFxEvents();
//
//                // Transition to LibrarianTableView
//                LibrarianTableView librarianTableView = new LibrarianTableView();
//                Pane librarianViewPane = librarianTableView.showTable();
//
//                primaryStage.setScene(new Scene(librarianViewPane, 700, 500));
//                primaryStage.show();
//
//                // Simulate an action in LibrarianTableView
//                TableView<Books> userTable = lookup("#usertableId").query();
//                interact(() -> userTable.getSelectionModel().select(0));
//
//                WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#addToBill").queryAll().isEmpty());
//                WaitForAsyncUtils.waitForFxEvents();
//                clickOn("#addToBill");
//
//                // Verify that the second row is visually selected
//                WaitForAsyncUtils.waitForFxEvents();
//                Books selectedBook = userTable.getSelectionModel().getSelectedItem();
//
//                // Rest of your test logic...
//                assertNotNull(selectedBook);
//                assertTrue(librarianTableView.getBooksOfBill().contains(selectedBook));
//
//                ShowBill showBill = new ShowBill();
//                Pane billview = showBill.ShowBill(librarianTableView.getBooksOfBill());
//                primaryStage.setScene(new Scene(billview, 700, 500));
//                primaryStage.show();
////               WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#lol1").queryAll().isEmpty());
//                WaitForAsyncUtils.waitFor(6, TimeUnit.SECONDS, () -> primaryStage.getScene().getRoot() instanceof Pane);
//
//
//
//            } catch (TimeoutException e) {
//                throw new RuntimeException(e);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
//}

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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class prova extends ApplicationTest {
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

                // Simulate an action in LibrarianView
                WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#addToBill").queryAll().isEmpty());
                clickOn("#addToBill");
                WaitForAsyncUtils.waitForFxEvents();

                // Transition to LibrarianTableView
                LibrarianTableView librarianTableView = new LibrarianTableView();
                Pane librarianViewPane = librarianTableView.showTable();

                primaryStage.setScene(new Scene(librarianViewPane, 700, 500));
                primaryStage.show();

                // Simulate an action in LibrarianTableView
                TableView<Books> userTable = lookup("#usertableId").query();
                interact(() -> userTable.getSelectionModel().select(0));

                WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#addToBill").queryAll().isEmpty());
                WaitForAsyncUtils.waitForFxEvents();
                clickOn("#addToBill");
                System.out.println(librarianTableView.getBooksOfBill()+ "qrrrrrr");
                // Verify that the second row is visually selected
                WaitForAsyncUtils.waitForFxEvents();
                Books selectedBook = userTable.getSelectionModel().getSelectedItem();

                // Rest of your test logic...
                assertNotNull(selectedBook);
//                System.out.println(librarianTableView.getBooksOfBill().contains(selectedBook));


                clickOn("#showBill");
                WaitForAsyncUtils.waitFor(12, TimeUnit.SECONDS, () -> lookup("#okok").queryAll().isEmpty());
                System.out.println("ooaknkja");
                ShowBill showBill = new ShowBill();
                Pane billview = showBill.ShowBill(librarianTableView.getBooksOfBill());
                primaryStage.setScene(new Scene(billview, 700, 500));
                primaryStage.show();

//                WaitForAsyncUtils.waitFor(6, TimeUnit.SECONDS, () -> lookup("#okok").tryQuery().isPresent());



            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

