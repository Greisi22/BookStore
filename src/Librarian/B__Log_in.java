package Librarian;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import Administator.View;
import Menager.Menager_Create_Book;
import Menager.view;
//import detyraklase.BackgroundImage;
//import detyraklase.Image;
//import detyraklase.javafx;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
	static D_Users u1 = null;
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

			// Label for username
			Label labePassWord = new Label("Password");
			labePassWord.setLayoutX(440);
			labePassWord.setLayoutY(270); 
			labePassWord.setFont(new Font("Glacial Indifference", 17));
			labePassWord.setTextFill(Color.web("#B1A2CF"));
			// TextField to take Password
			PasswordField PassswrdField = new PasswordField();
			PassswrdField.setLayoutX(440);
			PassswrdField.setLayoutY(300);

			// Button Log In
			Button LOGIN = new Button("Log In");
			LOGIN.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
			LOGIN.setLayoutX(540);
			LOGIN.setLayoutY(330);
		    
		 
		    
		    
	
			
			LOGIN.setOnAction(e->{
			
				FileInputStream fis;
				try {
					fis = new FileInputStream("Users.dat");
				
					ObjectInputStream objis = new ObjectInputStream(fis);
				
					D_Users a =	(D_Users) checkUser(objis,usernametextFiled.getText(),PassswrdField.getText());
					System.out.println(u1);
					if(u1 == null) {
				System.out.println("era");
						   showAlert(Alert.AlertType.ERROR,  pane.getScene().getWindow(), "Form Error!", "Try Again !!!");
					}
					else {
						System.out.println("era1");
					if(a.getAccesLevel().equals(Zh_accessLevel.LIBRARIAN))
					{
						CA__Librarian_View.stage(stage, a.getFirstName());
					}
					else if(a.getAccesLevel().equals(Zh_accessLevel.MANAGER))
					{
						view.View(stage, a.getFirstName());
					}
					else if(a.getAccesLevel().equals(Zh_accessLevel.ADMINISTRATOR))
					{

						View.FirstView(stage, a.getFirstName());
					}
					
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					
				}
				
				
				
			});
			// label characteristic  
			Message.setLayoutX(100);
			Message.setLayoutY(280);
			Message.setTextFill(Color.RED);
			Message.setFont(Font.font("Cambria", 15));
		
			pane.getChildren().addAll( LOGIN,  labeUsername, usernametextFiled, labePassWord, PassswrdField,
					Message);
			
		 Image image = new Image("file:l.png"); // Replace with your image file path
//			 
	        BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
	        		BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	       pane.setBackground(new javafx.scene.layout.Background(bgImg)); 

				
		
			
			
			Scene scene = new Scene(pane, 700, 500);
			stage.setTitle("Log in");
			stage.setScene(scene);
			stage.show();
			
	}
	//it check all the password of users and if it finds it return all the object else it put a message 
	private static Object checkUser(ObjectInputStream objis, String usernametextFiled, String PassswrdField)  {

		while(true)
		{
		 try {
			u1 = ((D_Users) objis.readObject());
			if(usernametextFiled.equals(u1.getFirstName()) && PassswrdField.equals(u1.getPassword()))
			{
		
		return u1;
			}
	else {

	}
	

		} catch (ClassNotFoundException | IOException e) {
u1=null;
return null;
			
		}

			

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









