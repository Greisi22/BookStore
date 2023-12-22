package View.Librarian;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainProject extends Application  {

	public  void start(Stage stage){

 		LogIn.Log_inn(stage);

	}

	public static void main(String[] args) {
  		System.out.println("System started successfully...Greisi");
		Application.launch(args);
	}

}
