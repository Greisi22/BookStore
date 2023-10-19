package Menager;

import java.io.FileNotFoundException;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Books_out_of_Stock {
	// is used to show the books that are out of stock
	public static void OutOfStock_View(Label label) {
		
		label.setFont(Font.font("Arimo", FontWeight.BOLD, 12));
		label.setTextFill(Color.web("#79CBE1"));

		ScrollPane s = new ScrollPane();
		Scene scene = new Scene(s, 300, 200);
	
		s.setFitToWidth(true);
		s.setContent(label);
		
		Stage stage = new Stage();
		stage.setTitle("Out Of Stock");
		stage.setScene(scene);
		stage.show();

	}
}
