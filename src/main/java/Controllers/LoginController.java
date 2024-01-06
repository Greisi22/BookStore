package Controllers;

import Model.Login.LogInFunctionalities;
import Model.Login.ResultType;
import View.Librarian.LibrarianView;
import View.Librarian.LoginView;
import View.Menager.view;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import View.Administator.View;
import java.io.FileNotFoundException;
import java.lang.constant.Constable;
import java.util.List;

public class LoginController {
    private final LoginView loginView;
    private final LogInFunctionalities logInFunctionalities;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.logInFunctionalities = new LogInFunctionalities();
    }

    public void handleLogin() {
        loginView.getLOGIN().setOnAction(e -> {
            LogInFunctionalities logInFunctionalities = new LogInFunctionalities();
            List<Constable> result = logInFunctionalities.handleLogin(loginView.getUsernametextFiled().getText(), loginView.getPassswrdField().getText(), "src/EncodedInformation/Users.dat");
            if (result != null && result.size() > 0) {
                ResultType resultType = (ResultType) result.get(0);
                switch (resultType) {
                    case INCORRECT_USER:
                        showAlert(Alert.AlertType.ERROR, loginView.getPane().getScene().getWindow(), "Form Error!", result.get(1).toString());
                        break;
                    case TRY_AGAIN:
                        showAlert(Alert.AlertType.ERROR, loginView.getPane().getScene().getWindow(), "Form Error!", result.get(1).toString());
                        break;
                    case LIBRARIAN_LOGIN:
                        try {
                            LibrarianView.stage(loginView.getStage(), result.get(1).toString()); // Assuming the second element is the username
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case MANAGER_LOGIN:
                        try {
                            view.View(loginView.getStage(), result.get(1).toString()); // Assuming the second element is the username
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case ADMIN_LOGIN:
                        View.FirstView(loginView.getStage(), result.get(1).toString()); // Assuming the second element is the username
                        break;

                }
            }
        });
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
