package com.example.View.Librarian;

import java.io.*;
import java.util.ArrayList;


import com.example.Controllers.BillController;
import com.example.Model.Books.Books;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ShowBill {



    private BillController billController = new BillController();

    public void ShowBill(ArrayList<Books> bookOfBill, Pane pane2, Stage stage1) {
        HBox[] hBoxs = new HBox[bookOfBill.size()];
        VBox[] vBoxs = new VBox[bookOfBill.size()];
        VBox vBoxs1 = new VBox();

        for (int i = 0; i < bookOfBill.size(); i++) {
            Label l1 = new Label("Book: " + bookOfBill.get(i).getTitle());
            l1.setFont(Font.font("Roboto Mono Regular", FontWeight.BOLD, 14));
            l1.setTextFill(Color.web("#79CBE1"));

            Label l2 = new Label("Price: " + bookOfBill.get(i).getPrice() + "");
            l2.setFont(Font.font("Roboto Mono Regular", FontWeight.BOLD, 14));
            l2.setTextFill(Color.web("#79CBE1"));

            hBoxs[i] = new HBox();
            vBoxs[i] = new VBox();
            hBoxs[i].getChildren().addAll(l1, l2);
            vBoxs[i].getChildren().add(hBoxs[i]);
        }

        vBoxs1.getChildren().addAll(vBoxs);
        vBoxs1.setPadding(new Insets(60, 5, 5, 40));
        vBoxs1.setSpacing(12);
        vBoxs1.setLayoutX(30);
        vBoxs1.setLayoutY(100);


        Button Print = new Button("Print Bill");
        Print.setPrefSize(100, 30);
        Print.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
        Print.setFont(new Font("Glacial Indifference", 12));
        Print.setLayoutX(522);
        Print.setLayoutY(400);


        Button Back = new Button("Back");
        Back.setPrefSize(100, 30);
        Back.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
        Back.setFont(new Font("Glacial Indifference", 12));
        Back.setLayoutX(522);
        Back.setLayoutY(435);

        Button ClearBill = new Button("Clear");
        ClearBill.setPrefSize(100, 30);
        ClearBill.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
        ClearBill.setFont(new Font("Glacial Indifference", 12));
        ClearBill.setLayoutX(522);
        ClearBill.setLayoutY(365);

        DatePicker d = new DatePicker();
        d.setLayoutX(476);
        d.setLayoutY(150);

        Image image = new Image("file:src/main/java/com/example/UI/Images/showBillimg.png"); // Replace with your image file path
        BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


        Pane pane = new Pane();
        pane.getChildren().addAll(vBoxs1, Print, Back, d, ClearBill);
        pane.setBackground(new javafx.scene.layout.Background(bgImg));
        Scene scene = new Scene(pane, 700, 500);
        stage1.setScene(scene);
        stage1.show();

        Back.setOnAction(e -> {
            stage1.close();
            try {
                LibrarianTableView librarianView  = new LibrarianTableView();
                librarianView.showTable(stage1);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });


        ClearBill.setOnAction(e -> {
            bookOfBill.clear();
            ShowBill(bookOfBill, pane2, stage1);

        });

        Print.setOnAction(e -> {
            this.billController.handlePrintingBill(bookOfBill, d);
        });

    }


}