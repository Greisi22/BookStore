package TestFx.Controllers;

import com.example.View.Librarian.LibrarianView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.util.WaitForAsyncUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class LibrarianViewTest extends Application {
    LibrarianView librarianView;

    @Override
    public void start(Stage stage) throws Exception {
        librarianView = new LibrarianView("Era");
        Pane pane = librarianView.getLibrarianView();
        stage.setScene(new Scene(pane, 700, 500));
        stage.show();
    }


    @Test
    public void testEmptyFieldsScenario() throws TimeoutException {
        assertNotNull(librarianView);

        //WaitForAsyncUtils.waitFor(4, TimeUnit.SECONDS, () -> !lookup("#createBill").queryAll().isEmpty());
        WaitForAsyncUtils.waitForFxEvents();
    }


}
