package Librarian;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Zh_Kooot {

	public static void kot (Label label)
	{
		
		Pane pane = new Pane();
		label.setLayoutX(100);
		label.setLayoutX(200);
		pane.getChildren().add(label);
		
		Scene scene = new Scene(pane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
	}
	
}
