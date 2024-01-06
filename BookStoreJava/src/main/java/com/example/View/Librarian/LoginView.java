package com.example.View.Librarian;


import com.example.Controllers.LoginController;
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

public class LoginView {

    static Label Message = new Label();
    private Pane pane;
    private Label labeUsername;
    private TextField usernametextFiled;
    private Label labePassWord;
    private PasswordField PassswrdField;
    private Button LOGIN;

    private LoginController loginController;

    private Stage stage;

    public void setLoginController(LoginController loginController){
        this.loginController = loginController;
    }

    public void Log_inn(Stage stage) {
        this.stage = stage;
        pane = new Pane();

        labeUsername = new Label("Username");
        labeUsername.setLayoutX(440);
        labeUsername.setLayoutY(210);
        labeUsername.setFont(new Font("Glacial Indifference", 17));
        labeUsername.setTextFill(Color.web("#B1A2CF"));

        // TextField to take username
        usernametextFiled = new TextField();
        usernametextFiled.setLayoutX(440);
        usernametextFiled.setLayoutY(240);

        labePassWord = new Label("Password");
        labePassWord.setLayoutX(440);
        labePassWord.setLayoutY(270);
        labePassWord.setFont(new Font("Glacial Indifference", 17));
        labePassWord.setTextFill(Color.web("#B1A2CF"));

        PassswrdField = new PasswordField();
        PassswrdField.setLayoutX(440);
        PassswrdField.setLayoutY(300);

        LOGIN = new Button("Log In");
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
        loginController.handleLogin();

    }
    //....................................................................................

    //....................................................................................



    public static Label getMessage() {
        return Message;
    }

    public static void setMessage(Label message) {
        Message = message;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public Label getLabeUsername() {
        return labeUsername;
    }

    public void setLabeUsername(Label labeUsername) {
        this.labeUsername = labeUsername;
    }

    public TextField getUsernametextFiled() {
        return usernametextFiled;
    }

    public void setUsernametextFiled(TextField usernametextFiled) {
        this.usernametextFiled = usernametextFiled;
    }

    public Label getLabePassWord() {
        return labePassWord;
    }

    public void setLabePassWord(Label labePassWord) {
        this.labePassWord = labePassWord;
    }

    public PasswordField getPassswrdField() {
        return PassswrdField;
    }

    public void setPassswrdField(PasswordField passswrdField) {
        PassswrdField = passswrdField;
    }

    public Button getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(Button LOGIN) {
        this.LOGIN = LOGIN;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

