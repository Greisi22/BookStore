package Librarian;

import java.io.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A__Main_Project  extends Application implements Serializable  {


	

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;




	public  void start(Stage stage) throws IOException {




		
		//The program Starts
 		B__Log_in.Log_inn(stage);
 
	
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("David Greiso");
		System.out.println("okkkk");
		Application.launch(args);
		System.out.println("Greisi");
	}

}
