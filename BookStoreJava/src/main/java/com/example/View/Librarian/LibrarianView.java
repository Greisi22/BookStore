package com.example.View.Librarian;

import com.example.Controllers.LibrarianController;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import com.example.Model.Books.Genre;
import com.example.View.Login.LoginView;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LibrarianView {

    private static ArrayList<Books> booksOfBill = new ArrayList<>();
    private static Books bookSelected = null;
    static Label OutOfStock = new Label("");
    static String WelcomeName;
    private Button addCreateBill = new Button("Create Bill");
    private Button signout = new Button("Sign Out");
    private  LibrarianController librarianController = new LibrarianController();

    public  void start(Stage stage, String Name) throws FileNotFoundException {
        WelcomeName = Name;

        Pane pane = getLibrarianView();
        Scene scene = new Scene(pane, 700, 500);
        if (stage != null) {
            stage.setTitle("Librarian");
            stage.setScene(scene);
            stage.show();
        } else {
            Stage stage1111 = new Stage();
            stage1111.setScene(scene);
            stage1111.show();
        }

        addCreateBill.setOnAction(e -> {
            try {
                showTable(stage);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        signout.setOnAction(e -> {
            LoginView logIn = new LoginView();
            logIn.start(stage);
        });


    }

    public  void showTable(Stage stage) throws ClassNotFoundException {
        Button Add = new Button("Add to Bill");
        Add.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");

        Button showBill = new Button("Show Bill");
        showBill.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");

        Button Cancle = new Button("Cancle");
        Cancle.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");

        ArrayList<Books> listBooks = new ArrayList<Books>();

        BookService bookService = new BookService();
        listBooks = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");

        TableView<Books> userTable = new TableView<>();

        ObservableList<Books> data = FXCollections.observableArrayList(listBooks);
        userTable.setItems(data);

        // ........................................................................................................
        userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        userTable.setEditable(true);

        userTable.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends Books> ov, Books old_val, Books new_val) -> {
                    ObservableList<Books> selectedItems = userTable.getSelectionModel().getSelectedItems();
                    for (Books name : selectedItems) {
                        bookSelected = name;
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
        Scene scene = new Scene(pane, 700, 500);
        scene.getStylesheets().add("");
        Stage stage1 = new Stage();

        stage1.setScene(scene);

        stage1.show();

        // ........................................................

        showBill.setOnAction(e -> {
            ShowBill.ShowBill(booksOfBill, pane, stage1, stage, WelcomeName);
        });

        // ................................................................
        Cancle.setOnAction(e -> {
            booksOfBill.clear();
            try {
                stage1.close();
                start(stage, WelcomeName);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

        });

    }





    public Pane getLibrarianView(){
        Pane pane = new Pane();


        addCreateBill.setPrefSize(100, 30);
        addCreateBill.setLayoutX(250);
        addCreateBill.setLayoutY(400);
        addCreateBill.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
        addCreateBill.setFont(new Font("Glacial Indifference", 12));


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
        return pane;
    }


}
