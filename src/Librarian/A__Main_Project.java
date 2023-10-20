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

public class A__Main_Project  extends Application  {

	public  void start(Stage stage){
		//The program Starts
 		B__Log_in.Log_inn(stage);
	}

	public static void main(String[] args) {
  		System.out.println("System started successfully...");
		Application.launch(args);
	}

}
