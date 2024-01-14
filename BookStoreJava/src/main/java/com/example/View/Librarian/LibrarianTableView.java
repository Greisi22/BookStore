package com.example.View.Librarian;

import com.example.Controllers.LibrarianController;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import com.example.Model.Books.Genre;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LibrarianTableView {

    private static Books bookSelected = null;

    public Books getBookSelected1() {
        return bookSelected1;
    }

    private  Books bookSelected1 = null;
    static Label OutOfStock = new Label("");
    private LibrarianController librarianController = new LibrarianController();

    public ArrayList<Books> getBooksOfBill() {
        System.out.println();
        return booksOfBill;
    }

    private static ArrayList<Books> booksOfBill = new ArrayList<>();

    public Stage getStage() {
        return stage;
    }

    private Stage stage;
    private Stage stage1;

    public void startTableView(Stage stage) throws ClassNotFoundException {
        this.stage = stage;
        Pane pane = showTable();
        Scene scene = new Scene(pane, 700, 500);
        scene.getStylesheets().add("");
        Stage stage1 = new Stage();
        this.stage1 = stage1;
        this.stage1.setScene(scene);
        this.stage1.show();
    }

    public Pane showTable() throws ClassNotFoundException {
        Button Add = new Button("Add to Bill");
        Add.setId("addToBill");
        Add.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");

        Button showBill = new Button("Show Bill");
        showBill.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");
        showBill.setId("showBill");

        Button Cancle = new Button("Cancle");
        Cancle.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");
        Cancle.setId("Cancel");

        ArrayList<Books> listBooks = new ArrayList<Books>();

        BookService bookService = new BookService();
        listBooks = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");

        TableView<Books> userTable = new TableView<>();

        ObservableList<Books> data = FXCollections.observableArrayList(listBooks);
        userTable.setItems(data);

        // ........................................................................................................
        userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        userTable.setEditable(true);
        userTable.setId("usertableId");

        userTable.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends Books> ov, Books old_val, Books new_val) -> {
                    ObservableList<Books> selectedItems = userTable.getSelectionModel().getSelectedItems();

                    for (Books name : selectedItems) {
                        System.out.println("loool" + name.getTitle());
                        bookSelected = name;
                        bookSelected1 = name;
                    }
                });

        // ........................................................................................................

        TableColumn title = new TableColumn("title");
        TableColumn ISBN = new TableColumn("ISBN");
        TableColumn quanity = new TableColumn("quanity");
        TableColumn description = new TableColumn("description");
        TableColumn price = new TableColumn("price");
        TableColumn author = new TableColumn(" author");
        TableColumn paperback = new TableColumn(" paperback");
        TableColumn genres = new TableColumn("genres");

        title.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        ISBN.setCellValueFactory(new PropertyValueFactory<Books, String>("ISBN"));
        quanity.setCellValueFactory(new PropertyValueFactory<Books, Integer>("quanity"));
        description.setCellValueFactory(new PropertyValueFactory<Books, String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Books, Double>("price"));
        author.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        paperback.setCellValueFactory(new PropertyValueFactory<Books, Boolean>("paperback"));
        genres.setCellValueFactory(new PropertyValueFactory<Books, ArrayList<Genre>>("genres"));

        FilteredList<Books> flPerson = new FilteredList(data, p -> true);// Pass the data to a filtered list
        userTable.setItems(flPerson);// Set the table's items using the filtered list
        userTable.getColumns().addAll(title, ISBN, quanity, description, price, author, paperback, genres);

        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("title");
        choiceBox.setValue("title");

        Label label = new Label("Search");
        label.setFont(Font.font("Arimo", FontWeight.BOLD, 15));
        label.setTextFill(Color.web("white"));

        TextField textField22 = new TextField();
        textField22.setPromptText("Search here!");
        textField22.setLayoutX(90);
        textField22.setLayoutY(350);
        textField22.textProperty().addListener((obs, oldValue, newValue) -> {
            switch (choiceBox.getValue())// Switch on choiceBox value
            {
                case "title":
                    flPerson.setPredicate(p -> p.getTitle().toLowerCase().contains(newValue.toLowerCase().trim()));// filter
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                textField22.setText("");
            }
        });

        Add.setOnAction(e -> {
            if (bookSelected != null) {
                if (librarianController.checkOutOfStock(bookSelected)) {
                    OutOfStock.setText(bookSelected.getTitle() + " added!");
                    booksOfBill.add(bookSelected);
                } else {
                    OutOfStock.setText("Book " + bookSelected.getTitle() + " is out of stock!!!");
                    OutOfStock.setFont(Font.font("Arimo", FontWeight.BOLD, 10));
                    OutOfStock.setTextFill(Color.web("white"));
                    OutOfStock.setLayoutX(90);
                    OutOfStock.setLayoutY(330);
                }
            }
        });

        GridPane pane = new GridPane();
        HBox allbuttons = new HBox();
        HBox gjysma1 = new HBox();
        HBox gjysma2 = new HBox();
        gjysma1.getChildren().addAll(label, textField22);
        gjysma1.setSpacing(10);
        gjysma2.getChildren().addAll(OutOfStock, Add, showBill, Cancle);
        gjysma2.setSpacing(10);
        allbuttons.getChildren().addAll(gjysma1, gjysma2);
        allbuttons.setSpacing(100);
        pane.getChildren().addAll(userTable);
        pane.add(allbuttons, 0, 3);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);


        // ........................................................

        showBill.setOnAction(e -> {
            ShowBill showBill1 = new ShowBill();
            showBill1.startBillView(stage1, booksOfBill);
            for (Books b:booksOfBill) {
                System.out.println(b.getTitle());
            }

        });

        // ................................................................
        Cancle.setOnAction(e -> {
            System.out.println("Inside Cancel button action");
            try {
                System.out.println("Before closing stage");
                stage.close();
                System.out.println("After closing stage");

                LibrarianView librarianView = new LibrarianView();
                System.out.println("Before starting LibrarianView");
                librarianView.start(stage);
                System.out.println("After starting LibrarianView");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        return pane;
    }

}
