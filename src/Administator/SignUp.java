package Administator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Librarian.D_Users;
import Librarian.V_Author;
import Librarian.Z_Books_Controller;
import Librarian.Zh_Books;
import Librarian.Zh_MyDate;
import Librarian.Zh_accessLevel;
import Menager.Book_Sold;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SignUp {
static String namee;
static Stage stage;
	public static void SignUpView(Stage primaryStage, String name) {
		namee = name;
		stage = primaryStage;
		primaryStage.setTitle("Registration Form");

		GridPane gridPane;
		try {
			Image image = new Image("file:pasloginbosh.png"); // Replace with your image file path

			BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

			gridPane = createRegistrationFormPane();
			addUIControls(gridPane);
			gridPane.setBackground(new javafx.scene.layout.Background(bgImg));
			Scene scene = new Scene(gridPane, 700, 500);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static GridPane createRegistrationFormPane() {

		GridPane gridPane = new GridPane();
		gridPane.setBackground(new Background(new BackgroundFill(Color.web("#8088BB"), null, null)));

		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(80, 80, 100, 150));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// Add Column Constraints
		// columnOneConstraints will be applied to all the nodes placed in column one.
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);

		// columnTwoConstraints will be applied to all the nodes placed in column two.
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

		return gridPane;
	}

	private static void addUIControls(GridPane gridPane) {

		Label headerLabel = new Label("Registration Form");
		headerLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 20));
		headerLabel.setTextFill(Color.web("#3BC1BC"));

		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		Label nameLabel = new Label("First Name : ");
		nameLabel.setTextFill(Color.WHITE);
		nameLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));
		gridPane.add(nameLabel, 0, 1);
		TextArea nameField = new TextArea();

		nameField.setPrefHeight(20);
		nameField.setPrefWidth(50);

		gridPane.add(nameField, 1, 1);

		Label lastLabel = new Label("Last Name : ");
		lastLabel.setTextFill(Color.WHITE);
		lastLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));
		gridPane.add(lastLabel, 0, 2);
		TextField lastField = new TextField();
		lastField.setPrefHeight(40);
		gridPane.add(lastField, 1, 2);

		Label emailLabel = new Label("Email : ");
		gridPane.add(emailLabel, 0, 3);
		emailLabel.setTextFill(Color.WHITE);
		emailLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));
		TextField emailField = new TextField();
		emailField.setPrefHeight(40);
		gridPane.add(emailField, 1, 3);

		Label dateLabel = new Label("Birthdate : ");
		dateLabel.setTextFill(Color.WHITE);
		dateLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));
		gridPane.add(dateLabel, 0, 4);
		DatePicker dateField = new DatePicker();
		dateField.setPrefHeight(40);
		gridPane.add(dateField, 1, 4);

		Label passwordLabel = new Label("Password : ");
		gridPane.add(passwordLabel, 0, 5);
		passwordLabel.setTextFill(Color.WHITE);
		passwordLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));
		PasswordField passwordField = new PasswordField();
		passwordField.setPrefHeight(20);
		gridPane.add(passwordField, 1, 5);

		Label salaryLabel = new Label("Salary : ");
		gridPane.add(salaryLabel, 0, 6);
		salaryLabel.setTextFill(Color.WHITE);
		salaryLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));
		TextField salaryField = new TextField();
		salaryField.setPrefHeight(40);
		gridPane.add(salaryField, 1, 6);

		Label phoneLabel = new Label("Phone No : ");
		gridPane.add(phoneLabel, 0, 7);
		phoneLabel.setTextFill(Color.WHITE);
		phoneLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));
		TextField phoneField = new TextField();
		phoneField.setPrefHeight(15);
		gridPane.add(phoneField, 1, 7);

		////////////////////////////////////////
		Label statusLabel = new Label("Status : ");
		gridPane.add(statusLabel, 0, 8);
		statusLabel.setTextFill(Color.WHITE);
		statusLabel.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 13));

		final ToggleGroup group = new ToggleGroup();
		VBox paneForAccess = new VBox(10);
		paneForAccess.setPadding(new Insets(4));
		ArrayList<RadioButton> accessCheckboxes = new ArrayList<>();

		RadioButton bLib = new RadioButton(Zh_accessLevel.LIBRARIAN.toString());
		bLib.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 12));
		bLib.setTextFill(Color.WHITE);
		RadioButton bMan = new RadioButton(Zh_accessLevel.MANAGER.toString());
		bMan.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 12));
		bMan.setTextFill(Color.WHITE);
		RadioButton bAdmin = new RadioButton(Zh_accessLevel.ADMINISTRATOR.toString());
		bAdmin.setFont(Font.font("Glacial Indeference", FontWeight.BOLD, 12));
		bAdmin.setTextFill(Color.WHITE);

		accessCheckboxes.add(bLib);
		accessCheckboxes.add(bMan);
		accessCheckboxes.add(bAdmin);

		bLib.setToggleGroup(group);
		bMan.setToggleGroup(group);
		bAdmin.setToggleGroup(group);

		paneForAccess.getChildren().addAll(accessCheckboxes);
		gridPane.add(paneForAccess, 1, 8);
		///////////////////////////////////////////
		HBox buttons = new HBox();
		Button submitButton = new Button("Submit");
		submitButton.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		submitButton.setFont(new Font("Glacial Indifference", 12));
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		Button backButton = new Button("Back");
		backButton.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		backButton.setFont(new Font("Glacial Indifference", 12));
		backButton.setPrefHeight(40);
		backButton.setDefaultButton(true);
		backButton.setPrefWidth(100);
		
		backButton.setOnAction(e->{
			View.FirstView(stage,namee);
		});
		//gridPane.add(backButton, 0, 9);
		buttons.getChildren().addAll(backButton,submitButton);
		buttons.setSpacing(15);
		gridPane.add(buttons, 1, 9);
		//GridPane.setHalignment(backButton, Pos.BASELINE_CENTER);
		//GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

		Controller_Users newUser = new Controller_Users();
		submitButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Zh_accessLevel ACESS = null;
				for (int i = 0; i < accessCheckboxes.size(); i++) {
					if (accessCheckboxes.get(i).isSelected()) {
						String accesss = accessCheckboxes.get(i).getText();
						if (accesss.equals(Zh_accessLevel.LIBRARIAN.toString())) {
							ACESS = Zh_accessLevel.LIBRARIAN;
						} else if (accesss.equals(Zh_accessLevel.MANAGER.toString())) {
							ACESS = Zh_accessLevel.MANAGER;
						} else {
							ACESS = Zh_accessLevel.ADMINISTRATOR;
						}

					}
				}
				if (nameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a surname");
					return;
				} else if (lastField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a last name");
					return;
				} else if (emailField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter an email");
					return;
				} else if (dateField.getValue().equals(null)) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a birthdate");
					return;
				} else if (passwordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a password");
					return;
				} else if (salaryField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a salary");
					return;
				} else if (phoneField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a phone number");
					return;
				} else {
					D_Users isCreated = newUser.loginn(nameField.getText(), lastField.getText(), emailLabel.getText(),
							new Zh_MyDate(dateField.getValue().getMonthValue(), dateField.getValue().getDayOfMonth(),
									dateField.getValue().getYear()),
							passwordField.getText(), Integer.parseInt(salaryField.getText()), phoneField.getText(),
							ACESS);

					if (isCreated != null) {

						write(isCreated);

					}
					showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!",
							"Welcome " + nameField.getText());
				}

			}

		});

	}

	private static void write(D_Users isCreated) {

		ArrayList<D_Users> listBooks = new ArrayList<D_Users>();

		FileInputStream fis;
		try {

			fis = new FileInputStream("Users.dat");

			ObjectInputStream objis = new ObjectInputStream(fis);

			while (objis != null) {

				D_Users obj = ((D_Users) objis.readObject());
				listBooks.add(obj);
			}

			objis.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			listBooks.add(isCreated);
			AddMenuBar(listBooks);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
////			
////.................................................		
//		
//print file

	private static void AddMenuBar(ArrayList<D_Users> listBooks) {

		FileOutputStream out;
		try {
			out = new FileOutputStream("Users.dat");
			ObjectOutputStream output = new ObjectOutputStream(out);

			for (int i = 0; i < listBooks.size(); i++) {
				output.writeObject(listBooks.get(i));
			}

			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("1. " + e);
		}

	}

	private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}