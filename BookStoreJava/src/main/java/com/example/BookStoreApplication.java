package com.example;


import com.example.Controllers.LoginController;
import com.example.View.Librarian.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class BookStoreApplication extends Application {

    public void start(Stage stage) {
        LoginView logIn = new LoginView();
        LoginController loginController = new LoginController(logIn);
        logIn.setLoginController(loginController);
        logIn.Log_inn(stage);

    }

    public static void main(String[] args) {
        System.out.println("System started successfully...");
        Application.launch(args);
    }


}
