package View.Librarian;

import javafx.application.Application;
import javafx.stage.Stage;

public class A__Main_Project  extends Application  {

	public  void start(Stage stage){

 		B__Log_in.Log_inn(stage);

	}

	public static void main(String[] args) {
  		System.out.println("System started successfully...Greisi");
		Application.launch(args);
	}

}