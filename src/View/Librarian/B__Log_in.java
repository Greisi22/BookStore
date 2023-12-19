package View.Librarian;

import java.io.*;
import java.lang.constant.Constable;
import java.util.List;

import View.Administator.View;
import View.Menager.view;
import Model.Login.LogInFunctionalities;
import Test.Librarian.LogIn.ResultType;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;

public class B__Log_in {

    static Label Message = new Label();

    public static void Log_inn(Stage stage) {
        Pane pane = new Pane();

        Label labeUsername = new Label("Username");
        labeUsername.setLayoutX(440);
        labeUsername.setLayoutY(210);
        labeUsername.setFont(new Font("Glacial Indifference", 17));
        labeUsername.setTextFill(Color.web("#B1A2CF"));

        // TextField to take username
        TextField usernametextFiled = new TextField();
        usernametextFiled.setLayoutX(440);
        usernametextFiled.setLayoutY(240);

        Label labePassWord = new Label("Password");
        labePassWord.setLayoutX(440);
        labePassWord.setLayoutY(270);
        labePassWord.setFont(new Font("Glacial Indifference", 17));
        labePassWord.setTextFill(Color.web("#B1A2CF"));
        PasswordField PassswrdField = new PasswordField();
        PassswrdField.setLayoutX(440);
        PassswrdField.setLayoutY(300);

        Button LOGIN = new Button("Log In");
        LOGIN.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
        LOGIN.setLayoutX(540);
        LOGIN.setLayoutY(330);

        Message.setLayoutX(100);
        Message.setLayoutY(280);
        Message.setTextFill(Color.RED);
        Message.setFont(Font.font("Cambria", 15));

        pane.getChildren().addAll(LOGIN, labeUsername, usernametextFiled, labePassWord, PassswrdField, Message);

        Image image = new Image("file:src/UI/Images/l.png");
        BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pane.setBackground(new javafx.scene.layout.Background(bgImg));

        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.show();

        // Add an action to the LOGIN button
        LOGIN.setOnAction(e -> {

           LogInFunctionalities logInFunctionalities = new LogInFunctionalities();
            List<Constable> result = logInFunctionalities.handleLogin(usernametextFiled.getText(), PassswrdField.getText(), "src/EncodedInformation/Users.dat");
            if (result != null && result.size() > 0) {
                ResultType resultType = (ResultType) result.get(0);
             System.out.println(resultType);
                switch (resultType) {
                    case INCORRECT_USER:
                        showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", result.get(1).toString());
                        break;
                    case TRY_AGAIN:
                        showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", result.get(1).toString());
                        break;
                    case LIBRARIAN_LOGIN:
                        try {
                            CA__Librarian_View.stage(stage, result.get(1).toString()); // Assuming the second element is the username
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case MANAGER_LOGIN:
                        try {
                            view.View(stage, result.get(1).toString()); // Assuming the second element is the username
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case ADMIN_LOGIN:
                        View.FirstView(stage, result.get(1).toString()); // Assuming the second element is the username
                        break;

                }
            }









        });
    }
    //....................................................................................

    //....................................................................................
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }






}

