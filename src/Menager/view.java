package Menager;

import java.io.*;
import java.util.ArrayList;

import Librarian.B__Log_in;

import Librarian.Zh_Books;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class view {
	static ArrayList<String> listBooks = new ArrayList<String>();
	static String WelcomeName;

	public static void View(Stage stage, String Name) throws FileNotFoundException {
		WelcomeName = Name;

		FileInputStream ImageInput = new FileInputStream("src/UI/Icons/mssgTheOne.png");
		Image search = new Image(ImageInput);
		ImageView image1 = new ImageView(search);
		image1.setFitWidth(35);
		image1.setFitHeight(30);
		Button message = new Button("");
		message.setGraphic(image1);
		message.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
		message.setLayoutX(610);
		message.setLayoutY(30);

		FileInputStream ImageInput1 = new FileInputStream("src/UI/Icons/no_mess.png");
		Image search1 = new Image(ImageInput1);
		ImageView image11 = new ImageView(search1);
		image11.setFitWidth(30);
		image11.setFitHeight(30);
		Button no_message = new Button("");
		no_message.setGraphic(image11);
		no_message.setStyle("-fx-background-color: #E1D9D1; ");
		no_message.setLayoutX(420);
		no_message.setLayoutY(30);

		Pane pane = new Pane();

		Button createBook = new Button("Create Book");
		createBook.setPrefSize(100, 30);
		createBook.setLayoutX(150);
		createBook.setLayoutY(400);
		createBook.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
		createBook.setFont(new Font("Glacial Indifference", 12));

		Button UppdateBook = new Button("Update Book");
		UppdateBook.setPrefSize(100, 30);
		UppdateBook.setLayoutX(260);
		UppdateBook.setLayoutY(400);
		UppdateBook.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
		UppdateBook.setFont(new Font("Glacial Indifference", 12));

		Button Statistic = new Button("Statistic");
		Statistic.setPrefSize(100, 30);
		Statistic.setLayoutX(370);
		Statistic.setLayoutY(400);
		Statistic.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
		Statistic.setFont(new Font("Glacial Indifference", 12));

		Button signout = new Button("Sign Out");
		signout.setPrefSize(100, 30);
		signout.setLayoutX(480);
		signout.setLayoutY(400);
		signout.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
		signout.setFont(new Font("Glacial Indifference", 12));

		Label label_WelcomeName = new Label("Welcome " + WelcomeName);
		label_WelcomeName.setFont(Font.font("Roboto Mono Regular", 27));
		label_WelcomeName.setTextFill(Color.web("#79CBE1"));
		label_WelcomeName.setLayoutX(260);
		label_WelcomeName.setLayoutY(300);

		Statistic.setOnAction(e -> {
			Menager_Statistic.Satistic_View(stage, WelcomeName);
		});

		UppdateBook.setOnAction(e -> {
			UpdateBook.Update_Book_View(stage);
		});

		signout.setOnAction(e -> {
			B__Log_in.Log_inn(stage);
		});

		createBook.setOnAction(e -> {
			Menager_Create_Book.BookView(stage, WelcomeName);
		});

		if (!outOfStock()) {
			pane.getChildren().add(no_message);
		} else {
			pane.getChildren().add(message);
		}

		message.setOnAction(e -> {
			StringBuilder s1 = new StringBuilder();
			for (int i = 0; i < listBooks.size(); i++) {
				s1.append("        Book ").append(listBooks.get(i)).append(" has less than 5 in stock\n");
			}
			Label label = new Label(s1.toString());
			Books_out_of_Stock.OutOfStock_View(label);
		});

		pane.getChildren().addAll(createBook, UppdateBook, Statistic, signout, label_WelcomeName);

		Image image = new Image("file:paslogin.png");

		BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		pane.setBackground(new Background(bgImg));

		Scene scene = new Scene(pane, 700, 500);
		stage.setTitle("Manager");
		stage.setScene(scene);
		stage.show();
	}

	private static boolean outOfStock() {
		FileInputStream fis;

		try {
			fis = new FileInputStream("src/EncodedInformation/Books.dat");
			ObjectInputStream objis = new ObjectInputStream(fis);

			while (true) {
				try {
					Zh_Books obj = (Zh_Books) objis.readObject();
					if (obj.getQuanity() < 5) {
						objis.close();
						return true;
					}
				} catch (EOFException e) {
					break;
				}
			}

			objis.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}
}
