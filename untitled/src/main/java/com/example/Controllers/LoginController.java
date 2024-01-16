package com.example.Controllers;


import com.example.Model.Login.LogInFunctionalities;
import com.example.Model.Login.ResultType;
import com.example.View.Administator.AdminView;
import com.example.View.Librarian.LibrarianView;
import com.example.View.Login.LoginView;
import com.example.View.Menager.ManagerView;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.io.FileNotFoundException;
import java.lang.constant.Constable;
import java.util.List;

public class LoginController {
    private final LoginView loginView;
    private  Alert alert;
    private final LogInFunctionalities logInFunctionalities;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.logInFunctionalities = new LogInFunctionalities();
    }

    public void handleLogin() {
        loginView.getLOGIN().setOnAction(e -> {
            LogInFunctionalities logInFunctionalities = new LogInFunctionalities();
            List<Constable> result = logInFunctionalities.handleLogin(loginView.getUsernametextFiled().getText(), loginView.getPassswrdField().getText(), "src/main/java/com/example/EncodedInformation/Users.dat");
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

                            LibrarianView librarianView = new LibrarianView(result.get(1).toString());
                            librarianView.start(loginView.getStage() ); // Assuming the second element is the username
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case MANAGER_LOGIN:
                        try {
                            ManagerView.View(loginView.getStage(), result.get(1).toString()); // Assuming the second element is the username
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case ADMIN_LOGIN:
                        AdminView.FirstView(loginView.getStage(), result.get(1).toString()); // Assuming the second element is the username
                        break;

                }
            }
        });
    }

    public  void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public Alert getAlert(){
        return this.alert;
    }
}
