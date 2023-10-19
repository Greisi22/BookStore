//package Menager;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//
//import Librarian.CA__Librarian_View;
//import Librarian.E_Bill;
//import Librarian.V_Author;
//import Librarian.Z_Books_Controller;
//import Librarian.Zh_Books;
//import Librarian.Zh_Genre;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//public class view {
//	static ArrayList<String> listBooks = new ArrayList<String>();
//public static void View(Stage stage) throws FileNotFoundException
//{
//	//......................................................................///
//	//create image that appear if a book has less than five
//	FileInputStream ImageInput = new FileInputStream("new_mess.png");
//	Image search = new Image(ImageInput);
//  ImageView image1 = new ImageView(search);
//  image1.setFitWidth(30);
//  image1.setFitHeight(30);
//	Button message = new Button("");
//	message.setGraphic(image1);
//	message. setStyle("-fx-background-color: #E1D9D1; ");
//	message.setLayoutX(420);
//	message.setLayoutY(30);
//	//.......................................................................//
//	//image if book have more than five
//	FileInputStream ImageInput1 = new FileInputStream("no_mess.png");
//	Image search1 = new Image(ImageInput1);
//  ImageView image11 = new ImageView(search1);
//    image11.setFitWidth(30);
//   image11.setFitHeight(30);
//	Button no_message = new Button("");
//	no_message.setGraphic(image11);
//	no_message. setStyle("-fx-background-color: #E1D9D1; ");
//	no_message.setLayoutX(420);
//	no_message.setLayoutY(30);
//	//...................................................
//	
//	//.......................................................
//	//button is used to go in the viw to create a book
//	Button createBook = new Button("Create Book");
//	createBook.setLayoutX(100);
//	createBook.setLayoutY(100);
//	
//	//.....................................................
//	Pane pane = new Pane();
//	
//	
//	Button UppdateBook = new Button("Update Book");
//	UppdateBook.setLayoutX(200);
//	UppdateBook.setLayoutY(200);
//	
//	Button Statistic = new Button("Statistic");
//	Statistic.setLayoutX(300);
//	Statistic.setLayoutY(300);
//	
//	//..........................................
//	Statistic.setOnAction(e->{
//		Menager_Statistic.Satistic_View(stage);
//	
//	});
//	//..............................................
//	
//	UppdateBook.setOnAction(e->{
//		UpdateBook.Update_Book_View(stage) ;
//	
//	});
//	//.....................................
//	//when button is clicked it goes to create a book
//	createBook.setOnAction(e->{
//		Menager_Create_Book.BookView(stage);
//		});
//	if(!outOfStock())
//	{
//		pane.getChildren().add(no_message);
//	}
//	else {
//		pane.getChildren().add(message);
//	}
//	
//	message.setOnAction(e->{
//		String s1= "";
//		for(int i=0;i<listBooks.size();i++)
//		{
//		s1 +="        Book "+ listBooks.get(i)+" has less than 5 in stock\n"; 	
//		}
//	Label label = new Label(s1);
//	Books_out_of_Stock.OutOfStock_View(label);
//		});
//	
//	
//     pane.getChildren().addAll(createBook,UppdateBook,Statistic);
// 	pane.setBackground(
//	        new Background(
//	            new BackgroundFill(
//	                javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
//	            )
//	        )
//	    );
//	 Scene scene = new Scene(pane,480,330);
//		stage.setTitle("Log in");
//		stage.setScene(scene);
//		stage.show();
//			
//}
////...........................................................
////check if the book has less than five in stock.
//private static boolean outOfStock() {
//
//	
//	FileInputStream fis;
//		try {
//			
//			fis = new FileInputStream("Books.dat");
//	
//			ObjectInputStream objis = new ObjectInputStream(fis);
//			
//
//	
//		while(objis!=null)
//		{
//			Zh_Books obj = ((Zh_Books) objis.readObject());
//		if(obj.getQuanity()<5)
//			listBooks.add(obj.getTitle());
//		}
//
//
//		objis.close();
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e) {
//			if(listBooks.size()==0)
//			{
//				return false;
//			}
//			else {
//				return true;
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	
//	return false;
//}
////............................................................................
//	
//}

package Menager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Librarian.B__Log_in;
import Librarian.CA__Librarian_View;
import Librarian.E_Bill;
import Librarian.V_Author;
import Librarian.Z_Books_Controller;
import Librarian.Zh_Books;
import Librarian.Zh_Genre;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class view {
	static ArrayList<String> listBooks = new ArrayList<String>();
	static String WelcomeName;
public static void View(Stage stage, String Name) throws FileNotFoundException
{
	WelcomeName = Name;
	//......................................................................///
	//create image that appear if a book has less than five
	FileInputStream ImageInput = new FileInputStream("mssgTheOne.png");
	Image search = new Image(ImageInput);
  ImageView image1 = new ImageView(search);
  image1.setFitWidth(35);
  image1.setFitHeight(30);
	Button message = new Button("");
	message.setGraphic(image1);
	message.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
	message.setLayoutX(610);
	message.setLayoutY(30);
	//.......................................................................//
	//image if book have more than five
	FileInputStream ImageInput1 = new FileInputStream("no_mess.png");
	Image search1 = new Image(ImageInput1);
  ImageView image11 = new ImageView(search1);
    image11.setFitWidth(30);
   image11.setFitHeight(30);
	Button no_message = new Button("");
	no_message.setGraphic(image11);
	no_message. setStyle("-fx-background-color: #E1D9D1; ");
	no_message.setLayoutX(420);
	no_message.setLayoutY(30);
	//...................................................
	Pane pane = new Pane();
	//.......................................................
	//button is used to go in the viw to create a book
	Button createBook = new Button("Create Book");
	createBook.setPrefSize(100, 30);
	createBook.setLayoutX(150);
	createBook.setLayoutY(400);
	createBook.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
	createBook.setFont(new Font("Glacial Indifference", 12));

	
	//.....................................................
	
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
	
	   Label label_WelcomeName = new Label("Welcome "+WelcomeName);
	     label_WelcomeName.setFont(Font.font("Roboto Mono Regular", 27));
	       	label_WelcomeName.setTextFill(Color.web("#79CBE1"));
	       	label_WelcomeName.setLayoutX(260);
	       	label_WelcomeName.setLayoutY(300);

	
	//..........................................
	Statistic.setOnAction(e->{
		Menager_Statistic.Satistic_View(stage,WelcomeName);
	
	});
	//..............................................
	
	UppdateBook.setOnAction(e->{
		UpdateBook.Update_Book_View(stage) ;
	
	});
	//.....................................
	signout.setOnAction(e->{
		B__Log_in.Log_inn(stage);
	});
	//when button is clicked it goes to create a book
	createBook.setOnAction(e->{
		Menager_Create_Book.BookView(stage,WelcomeName);
		});
	if(!outOfStock())
	{
		pane.getChildren().add(no_message);
	}
	else {
		pane.getChildren().add(message);
	}
	
	message.setOnAction(e->{
		String s1= "";
		for(int i=0;i<listBooks.size();i++)
		{
		s1 +="        Book "+ listBooks.get(i)+" has less than 5 in stock\n"; 	
		}
	Label label = new Label(s1);
	
	
	Books_out_of_Stock.OutOfStock_View(label);
		});
	
	
     pane.getChildren().addAll(createBook,UppdateBook,Statistic,signout,label_WelcomeName);
 
 	
 	Image image = new Image("file:paslogin.png"); // Replace with your image file path

	BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	pane.setBackground(new javafx.scene.layout.Background(bgImg));

	 Scene scene = new Scene(pane,700,500);
		stage.setTitle("Manager");
		stage.setScene(scene);
		stage.show();
			
}
//...........................................................
//check if the book has less than five in stock.
private static boolean outOfStock() {

	
	FileInputStream fis;
		try {
			
			fis = new FileInputStream("Books.dat");
	
			ObjectInputStream objis = new ObjectInputStream(fis);
			

	
		while(objis!=null)
		{
			Zh_Books obj = ((Zh_Books) objis.readObject());
		if(obj.getQuanity()<5)
			listBooks.add(obj.getTitle());
		}


		objis.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			if(listBooks.size()==0)
			{
				return false;
			}
			else {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	return false;
}
//............................................................................
	
}
