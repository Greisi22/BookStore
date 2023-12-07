package Librarian;

import java.io.*;

import Administator.View;
import Menager.view;
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
			try {

				D_Users isuser = (D_Users) checkUser(usernametextFiled.getText(), PassswrdField.getText());
				if (isuser == null) {
					showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Incorrect Uername or Password !!!");
				} else {
					if (isuser.getAccesLevel().equals(Zh_accessLevel.LIBRARIAN)) {
						CA__Librarian_View.stage(stage, isuser.getFirstName());
					} else if (isuser.getAccesLevel().equals(Zh_accessLevel.MANAGER)) {
						view.View(stage, isuser.getFirstName());
					} else if (isuser.getAccesLevel().equals(Zh_accessLevel.ADMINISTRATOR)) {
						View.FirstView(stage, isuser.getFirstName());
					}
					else {
						showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Try Again !!!");
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println(e1);
			}
		});
	}
	//....................................................................................
	public static Object checkUser(String usernametextFiled, String PassswrdField) throws IOException {
		File file = new File("src/EncodedInformation/Users.dat");

		if (!file.exists()) {
			throw new FileNotFoundExceptionCustom("File does not exist");
		}

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream objis = new ObjectInputStream(fis);
		D_Users user;
		while (true) {
			try {
				user = ((D_Users) objis.readObject());
				if (usernametextFiled.equals(user.getFirstName()) && PassswrdField.equals(user.getPassword())) {
					return user;
				}
			} catch (ClassNotFoundException | IOException e) {
				return null;
			}
		}
	}
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

class FileNotFoundExceptionCustom extends IOException {
	public FileNotFoundExceptionCustom(String message) {
		super(message);
	}
}