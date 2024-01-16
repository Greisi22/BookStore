package TestFx.Controllers.Manager;

import com.example.Controllers.LoginController;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import com.example.View.Login.LoginView;
import com.example.View.Menager.UpdateBook;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
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

public class UpdateBookFxTest extends ApplicationTest {

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

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#update").queryAll().isEmpty());
        clickOn("#update");
        WaitForAsyncUtils.waitForFxEvents();

        UpdateBook updateBook = new UpdateBook();

        TableColumn<Books, ?> titleColumn = updateBook.getTitle();
        assertNotNull(titleColumn);
        String updatedTitle = titleColumn.getCellData(0).toString();
        // Assuming that you want to click on the first cell in the title column
        doubleClickOn(titleColumn.getCellData(0).toString()).write("test").press(KeyCode.ENTER);
        updatedTitle = titleColumn.getCellData(0).toString();
        BookService bookService = new BookService();
        ArrayList<Books> Books = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");
       assertEquals(Books.get(0).getTitle(),updatedTitle);

    }
}
