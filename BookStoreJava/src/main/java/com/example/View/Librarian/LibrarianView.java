package com.example.View.Librarian;

import com.example.View.Login.LoginView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class LibrarianView {

    private static String WelcomeName;
    private Button addCreateBill = new Button("Create Bill");
    private Button signout = new Button("Sign Out");


    public LibrarianView(String name) {
        WelcomeName = name;
    }

    public LibrarianView() {

    }

    private Stage stage;

    public void start(Stage stage) throws FileNotFoundException {
        this.stage = stage;
        Pane pane = getLibrarianView();
        Scene scene = new Scene(pane, 700, 500);
        if (this.stage != null) {
            this.stage.setTitle("Librarian");
            this.stage.setScene(scene);
            this.stage.show();
        }


    }


    public Pane getLibrarianView() {
        Pane pane = new Pane();


        addCreateBill.setPrefSize(100, 30);
        addCreateBill.setLayoutX(250);
        addCreateBill.setLayoutY(400);
        addCreateBill.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
        addCreateBill.setFont(new Font("Glacial Indifference", 12));
        addCreateBill.setId("createBill");
        addCreateBill.setId("addToBill");


        signout.setPrefSize(100, 30);
        signout.setLayoutX(360);
        signout.setLayoutY(400);
        signout.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
        signout.setFont(new Font("Glacial Indifference", 12));

        Image image = new Image("file:src/main/java/com/example/UI/Images/paslogin.png"); // Replace with your image file path
        BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Label label_WelcomeName = new Label("Welcome " + WelcomeName);
        label_WelcomeName.setFont(Font.font("Roboto Mono Regular", 27));
        label_WelcomeName.setTextFill(Color.web("#79CBE1"));
        label_WelcomeName.setLayoutX(260);
        label_WelcomeName.setLayoutY(300);

        pane.getChildren().addAll(addCreateBill, signout, label_WelcomeName);
        pane.setBackground(new javafx.scene.layout.Background(bgImg));

        addCreateBill.setOnAction(e -> {
            try {
                LibrarianTableView librarianView = new LibrarianTableView();
                librarianView.startTableView(stage);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        signout.setOnAction(e -> {
            LoginView logIn = new LoginView();
            logIn.start(stage);
        });

        return pane;
    }


}
