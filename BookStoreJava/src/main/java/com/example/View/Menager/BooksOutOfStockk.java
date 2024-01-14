package com.example.View.Menager;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class BooksOutOfStockk {
	public static Scene getScene() {
		return scene;
	}

	private static Scene scene;
	public static void OutOfStock_View(Label label) {
		
		label.setFont(Font.font("Arimo", FontWeight.BOLD, 12));
		label.setTextFill(Color.web("#79CBE1"));

		ScrollPane s = new ScrollPane();
		scene = new Scene(s, 300, 200);
	
		s.setFitToWidth(true);
		s.setContent(label);
		
		Stage stage = new Stage();
		stage.setTitle("Out Of Stock");
		stage.setScene(scene);
		stage.show();

	}
}
