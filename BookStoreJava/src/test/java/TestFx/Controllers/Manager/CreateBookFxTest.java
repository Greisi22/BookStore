package TestFx.Controllers.Manager;

import com.example.Controllers.LoginController;
import com.example.Model.Books.BookService;
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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateBookFxTest extends ApplicationTest {

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
        BookService bookService = new BookService();
        ArrayList<Books> firstBooks = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#Submit").queryAll().isEmpty());
        clickOn(loginView.getUsernametextFiled()).write("Greisi");
        clickOn(loginView.getPassswrdField()).write("222");
        clickOn("#Submit");
        WaitForAsyncUtils.waitForFxEvents();

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#createBook").queryAll().isEmpty());
        clickOn("#createBook");
        WaitForAsyncUtils.waitForFxEvents();

        clickOn("#title").write("Sample Title");
        clickOn("#ISBN").write("1234567890");
        clickOn("#Price").write("19.99");
        clickOn("#paperBack");
        clickOn("#description").write("This is a sample book description.");
        clickOn("#author").write("Era Mulla");
        clickOn("#quntity").write("10");
        clickOn("#checkboxGenre1");
        clickOn("#checkboxGenre3");

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#dataPicker").queryAll().isEmpty());
        DatePicker datePicker = lookup("#dataPicker").query();
        LocalDate dateToSet = LocalDate.of(2024, Month.JANUARY, 15);
        interact(() -> datePicker.setValue(dateToSet));

        WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#addbook").queryAll().isEmpty());
        clickOn("#addbook");
        WaitForAsyncUtils.waitForFxEvents();

        ArrayList<Books> secondBooks = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");

        assertEquals(firstBooks.size() + 1, secondBooks.size());

    }

}
