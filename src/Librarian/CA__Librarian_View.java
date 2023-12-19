package Librarian;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CA__Librarian_View {
//	static ArrayList<String> listaaa = new ArrayList<String>();
//	static ArrayList<Double> listaaa1 = new ArrayList<Double>();
//	static ArrayList<String> listaaa2 = new ArrayList<String>();




	private static ArrayList<Zh_Books> booksOfBill = new ArrayList<>();
	private static Zh_Books bookSelected = null;

	static Label OutOfStock = new Label("");
	static String WelcomeName;

	public static void stage(Stage stage, String LName) throws FileNotFoundException {
		WelcomeName = LName;
		Pane pane = new Pane();

		Button addCreateBill = new Button("Create Bill");
		addCreateBill.setPrefSize(100, 30);
		addCreateBill.setLayoutX(250);
		addCreateBill.setLayoutY(400);
		addCreateBill.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		addCreateBill.setFont(new Font("Glacial Indifference", 12));

		Button signout = new Button("Sign Out");
		signout.setPrefSize(100, 30);
		signout.setLayoutX(360);
		signout.setLayoutY(400);
		signout.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		signout.setFont(new Font("Glacial Indifference", 12));


		addCreateBill.setOnAction(e -> {
			showTable(stage);
		});

		signout.setOnAction(e -> {
			B__Log_in.Log_inn(stage);
		});

		Image image = new Image("file:src/UI/Images/paslogin.png"); // Replace with your image file path
		BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		
		Label label_WelcomeName = new Label("Welcome "+WelcomeName);
		label_WelcomeName.setFont(Font.font("Roboto Mono Regular", 27));
       	label_WelcomeName.setTextFill(Color.web("#79CBE1"));
       	label_WelcomeName.setLayoutX(260);
       	label_WelcomeName.setLayoutY(300);
           
		
		pane.getChildren().addAll(addCreateBill, signout,label_WelcomeName);
		pane.setBackground(new javafx.scene.layout.Background(bgImg));

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

	}

	public static void showTable(Stage stage) {
		Button Add = new Button("Add to Bill");
		Add.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");
		Button showBill = new Button("Show Bill");
		showBill.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");

		Button Cancle = new Button("Cancle");
		Cancle.setStyle("-fx-background-color: #3AA5C2; -fx-text-fill: white;");

		ArrayList<Zh_Books> listBooks = new ArrayList<Zh_Books>();

		BookService bookService = new BookService() ;
	   listBooks = bookService.getBooks("src/EncodedInformation/Books.dat");

		TableView<Zh_Books> userTable = new TableView<>();

		ObservableList<Zh_Books> data = FXCollections.observableArrayList(listBooks);
		userTable.setItems(data);

		// ........................................................................................................
		userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		userTable.setEditable(true);

		userTable.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends Zh_Books> ov, Zh_Books old_val, Zh_Books new_val) -> {
					ObservableList<Zh_Books> selectedItems = userTable.getSelectionModel().getSelectedItems();


					//ruan infot kur i ben select
					for (Zh_Books name : selectedItems) {
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

		title.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("title"));
		ISBN.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("ISBN"));
		quanity.setCellValueFactory(new PropertyValueFactory<Zh_Books, Integer>("quanity"));
		description.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("description"));
		price.setCellValueFactory(new PropertyValueFactory<Zh_Books, Double>("price"));
		author.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("author"));
		paperback.setCellValueFactory(new PropertyValueFactory<Zh_Books, Boolean>("paperback"));
		genres.setCellValueFactory(new PropertyValueFactory<Zh_Books, ArrayList<Zh_Genre>>("genres"));

		FilteredList<Zh_Books> flPerson = new FilteredList(data, p -> true);// Pass the data to a filtered list
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
			if (BillFunctionalitiess.checkOutOfStock(bookSelected)) {
				BillFunctionalitiess.updateQuantity(bookSelected);
				OutOfStock.setText(bookSelected.getTitle() +" added!");
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
		gjysma1.getChildren().addAll(label,textField22);
		gjysma1.setSpacing(10);
		gjysma2.getChildren().addAll(OutOfStock,Add,showBill,Cancle);
		gjysma2.setSpacing(10);
		allbuttons.getChildren().addAll(gjysma1,gjysma2);
		allbuttons.setSpacing(100);
		pane.getChildren().addAll(userTable);
		pane.add(allbuttons, 0, 3);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 700, 500);
		scene.getStylesheets().add("try.css");
		Stage stage1 = new Stage();

		stage1.setScene(scene);

		stage1.show();

		// ........................................................

		showBill.setOnAction(e -> {
            System.out.println(booksOfBill);
			F_ShowBill.ShowBill( booksOfBill,pane, stage1, stage,WelcomeName);

		});

		// ................................................................
		Cancle.setOnAction(e -> {
			booksOfBill.clear();
			try {
				stage1.close();
				CA__Librarian_View.stage(stage, WelcomeName);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		});
		// .......................................................................................
	}



}
