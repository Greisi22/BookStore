package com.example;


import com.example.Controllers.LoginController;
import com.example.View.Login.LoginView;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    public void start(Stage stage) {
        LoginView logIn = new LoginView();
        LoginController loginController = new LoginController(logIn);
        logIn.setLoginController(loginController);
        logIn.start(stage);

    }

    public static void main(String[] args) {
        System.out.println("System started successfully...");
        javafx.application.Application.launch(args);
    }


}
