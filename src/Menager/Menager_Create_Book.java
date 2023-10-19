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
//import Librarian.V_Author;
//import Librarian.Z_Books_Controller;
//import Librarian.Zh_Books;
//import Librarian.Zh_Genre;
//import Librarian.Zh_MyDate;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class Menager_Create_Book {
//
//public static void BookView(Stage stage)
//{
//	   TextField title = new TextField();
//	   title.setLayoutX(170);
//	   title.setLayoutY(50);
//			 
//	   Label Ltitle = new Label("Title");
//	   Ltitle.setLayoutX(100);
//	   Ltitle.setLayoutY(50);
//	      
//	      TextField ISBN = new TextField();
//	      ISBN.setLayoutX(170);
//	      ISBN.setLayoutY(100);
//			 
//	      Label LISBN = new Label("ISBN");
//	      LISBN.setLayoutX(100);
//	      LISBN.setLayoutY(100);
//	      
//	      TextField Price = new TextField();
//	      Price.setLayoutX(170);
//	      Price.setLayoutY(150);
//			 
//	      Label LPrice = new Label("Price");
//	      LPrice.setLayoutX(100);
//	      LPrice.setLayoutY(150);
//	      
//	      TextArea description = new TextArea();
//	      description.setLayoutX(170);
//	      description.setLayoutY(220);
//	
//	      description.setPrefRowCount(2);
//	      description.setPrefColumnCount(20);
//	    
//
//
//
//			 
//	      Label Ldescription = new Label("Description");
//	      Ldescription.setLayoutX(100);
//	      Ldescription.setLayoutY(220);
//	      
//	      TextField author = new TextField();
//	      author.setLayoutX(170);
//	      author.setLayoutY(280);
//			 
//	      Label Lauthor = new Label("Author");
//	      Lauthor.setLayoutX(100);
//	      Lauthor.setLayoutY(280);
//			 
//	      
//	      TextField quntity = new TextField();
//	      quntity.setLayoutX(170);
//	      quntity.setLayoutY(320);
//			
//	      Label Lquntity = new Label("Quantity");
//	      Lquntity.setLayoutX(100);
//	      Lquntity.setLayoutY(320);
//	      
//	     
//	  
//	       DatePicker d = new DatePicker();
//	      		 
//	      		 d.setLayoutX(290);
//	      		 d.setLayoutY(400);
//	  
//			 
//
//	      Button b1 = new Button("Add Book");
//	      b1.setLayoutX(330);
//	      b1.setLayoutY(470);
//	      
//	      VBox paneForGenres = new VBox(10);
//			paneForGenres.setPadding(new Insets(4));
//			ArrayList<CheckBox> genreCheckboxes = new ArrayList<>();
//			for(Zh_Genre g : Zh_Genre.values()) {
//				genreCheckboxes.add(new CheckBox(g.toString()));
//			}
//			paneForGenres.getChildren().addAll(genreCheckboxes);
//			
//			paneForGenres.setLayoutX(170);
//			paneForGenres.setLayoutY(350);
//			
//		
//			Label genreLbl = new Label("Genres: ");
//			genreLbl.setLayoutX(100);
//			genreLbl.setLayoutY(400);
//	      RadioButton rbPaperback = new RadioButton("Paperback");
//	      rbPaperback.setLayoutX(170);
//	      rbPaperback.setLayoutY(180);
//			RadioButton rbEbook = new RadioButton("E-book");
//			rbEbook.setLayoutX(260);
//			  rbEbook.setLayoutY(180);
//			  ToggleGroup group = new ToggleGroup();
//			
//				
//			  rbPaperback.setToggleGroup(group);
//			  rbEbook.setToggleGroup(group);
//			  
//		      Z_Books_Controller newBOOK = new Z_Books_Controller();
//			   b1.setOnAction(e->{
//					ArrayList<Zh_Genre> newZhner = new ArrayList<>();
//				   boolean isPaperback = rbPaperback.isSelected();
//					  String isbn13 = ISBN.getText();
//						String titlee = title.getText();
//						double price = Double.parseDouble(Price.getText());
//						String descriptionn = description.getText();
//						String authorr = author.getText();
//						boolean isPaperback1 = rbPaperback.isSelected();
//		          
//						for(int i=0; i < genreCheckboxes.size(); i++) {
//							if(genreCheckboxes.get(i).isSelected())
//								newZhner.add(Zh_Genre.values()[i]);
//						}
//						Zh_Books isCreated=newBOOK.loginn(titlee,isbn13,Integer.parseInt(quntity.getText()),
//								descriptionn,price,new V_Author(authorr),isPaperback1);
//						isCreated.setGenres(newZhner);
//						isCreated.setDate(new Zh_MyDate(d.getValue().getMonthValue(),d.getValue().getDayOfMonth(),d.getValue().getYear()));
//						
//						if(isCreated!=null)
//		    			{
//						
//		  
//		    				write(isCreated);
//		    				
//		    				Book_Sold boook = new Book_Sold(new Zh_MyDate(d.getValue().getMonthValue(),d.getValue().getDayOfMonth(),d.getValue().getYear()), "11");
//		    				writeBought(boook);
//		    		  	
//		    			}
//		    			else {
//		    				System.out.println("lol");
//		    			}
//				});
//		      
//
//			  
//			  
////			  
////			
//
//			  
//Pane pane = new Pane();
//
//pane.getChildren().addAll(title,Ltitle,ISBN,LISBN,Price,LPrice,description,Ldescription,Lquntity,quntity,
//		author,Lauthor,paneForGenres,genreLbl,rbPaperback,rbEbook,b1,d);
//Scene scene = new Scene(pane,480,500);
//		stage.setTitle("Log in");
//		stage.setScene(scene);
//		stage.show();
//	
//}
//	
//
//private static void writeBought(Book_Sold boook) {
//
//	ArrayList<Book_Sold> listBooks = new ArrayList<Book_Sold>();
//	
//	FileInputStream fis;
//		try {
//			
//			fis = new FileInputStream("booksBought.dat");
//	
//			ObjectInputStream objis = new ObjectInputStream(fis);
//			
//	
//		
//
//		while(objis!=null)
//		{
//			
//			Book_Sold	obj = ((Book_Sold) objis.readObject());
//			listBooks.add(obj);
//		}
//
//	
//		objis.close();
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e) {
//			listBooks.add(boook);
//			SaveBooks(listBooks);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//}
//////		
//////.................................................		
////	
////print file
//
//
//private static void SaveBooks(ArrayList<Book_Sold> listBooks) {
//
//	FileOutputStream out;
//	try {
//		out = new FileOutputStream("booksBought.dat");
//		ObjectOutputStream output = new ObjectOutputStream(out);
//	
//		for(int i=0;i<listBooks.size();i++)
//		{
//			output.writeObject(listBooks.get(i));
//		}
//		
//		output.close();
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//      
//	}
//	
//	
//}
//
//
//
//
//private static  void write(Zh_Books isCreated){
//	
//ArrayList<Zh_Books> listBooks = new ArrayList<Zh_Books>();
//	
//		FileInputStream fis;
//			try {
//				
//				fis = new FileInputStream("Books.dat");
//		
//				ObjectInputStream objis = new ObjectInputStream(fis);
//				
//		
//				Zh_Books obj = new Zh_Books() ;
//	
//			while(obj!=null)
//			{
//				
//				obj = ((Zh_Books) objis.readObject());
//				listBooks.add(obj);
//			}
//
//		
//			objis.close();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e) {
//				listBooks.add(isCreated);
//				AddMenuBar(listBooks);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//////			
//////.................................................		
////		
////print file
//
//
//	private static void AddMenuBar(ArrayList<Zh_Books> listBooks) {
//	
//		FileOutputStream out;
//		try {
//			out = new FileOutputStream("Books.dat");
//			ObjectOutputStream output = new ObjectOutputStream(out);
//		
//			for(int i=0;i<listBooks.size();i++)
//			{
//				output.writeObject(listBooks.get(i));
//			}
//			
//			output.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//            System.out.println("1. "+e);
//		}
//		
//		
//	}
//
//	
//	
//	
//
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

import Librarian.V_Author;
import Librarian.Z_Books_Controller;
import Librarian.Zh_Books;
import Librarian.Zh_Genre;
import Librarian.Zh_MyDate;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Menager_Create_Book {

	public static void BookView(Stage stage, String WelcomeName) {
		TextField title = new TextField();
		title.setLayoutX(300);
		title.setLayoutY(50);

		Label Ltitle = new Label("Title");
		Ltitle.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Ltitle.setTextFill(Color.web("#3BA6A2"));
		Ltitle.setLayoutX(250);
		Ltitle.setLayoutY(50);

		TextField ISBN = new TextField();
		ISBN.setLayoutX(300);
		ISBN.setLayoutY(100);

		Label LISBN = new Label("ISBN");
		LISBN.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		LISBN.setTextFill(Color.web("#3BA6A2"));
		LISBN.setLayoutX(250);
		LISBN.setLayoutY(100);

		TextField Price = new TextField();
		Price.setLayoutX(300);
		Price.setLayoutY(150);

		Label LPrice = new Label("Price");
		LPrice.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		LPrice.setTextFill(Color.web("#3BA6A2"));
		LPrice.setLayoutX(250);
		LPrice.setLayoutY(150);

		TextArea description = new TextArea();
		description.setLayoutX(300);
		description.setLayoutY(220);

		description.setPrefRowCount(2);
		description.setPrefColumnCount(20);

		Label Ldescription = new Label("Description");
		Ldescription.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Ldescription.setTextFill(Color.web("#3BA6A2"));
		Ldescription.setLayoutX(215);
		Ldescription.setLayoutY(220);

		TextField author = new TextField();
		author.setLayoutX(300);
		author.setLayoutY(280);

		Label Lauthor = new Label("Author");
		Lauthor.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Lauthor.setTextFill(Color.web("#3BA6A2"));
		Lauthor.setLayoutX(245);
		Lauthor.setLayoutY(280);

		TextField quntity = new TextField();
		quntity.setLayoutX(300);
		quntity.setLayoutY(320);

		Label Lquntity = new Label("Quantity");
		Lquntity.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Lquntity.setTextFill(Color.web("#3BA6A2"));
		Lquntity.setLayoutX(230);
		Lquntity.setLayoutY(320);

		DatePicker d = new DatePicker();

		d.setLayoutX(400);
		d.setLayoutY(400);

		Button b1 = new Button("Add Book");
		b1.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		b1.setLayoutX(440);
		b1.setLayoutY(450);
		
		Button b2 = new Button("Back");
		b2.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		b2.setLayoutX(650);
		b2.setLayoutY(450);


		VBox paneForGenres = new VBox(10);
		paneForGenres.setPadding(new Insets(4));
		ArrayList<CheckBox> genreCheckboxes = new ArrayList<>();
		for (Zh_Genre g : Zh_Genre.values()) {
			CheckBox chb = new CheckBox(g.toString());
			genreCheckboxes.add(chb);
			chb.setFont(Font.font("Arimo", FontWeight.BOLD, 12));
			chb.setTextFill(Color.web("#3BA6A2"));
			
		}
		
		paneForGenres.getChildren().addAll(genreCheckboxes);

		paneForGenres.setLayoutX(300);
		paneForGenres.setLayoutY(350);

		Label genreLbl = new Label("Genres: ");
		genreLbl.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		genreLbl.setTextFill(Color.web("#3BA6A2"));
		genreLbl.setLayoutX(250);
		genreLbl.setLayoutY(400);
		RadioButton rbPaperback = new RadioButton("Paperback");
		rbPaperback.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		rbPaperback.setTextFill(Color.web("#3BA6A2"));
		rbPaperback.setLayoutX(300);
		rbPaperback.setLayoutY(180);
		RadioButton rbEbook = new RadioButton("E-book");
		rbEbook.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		rbEbook.setTextFill(Color.web("#3BA6A2"));
		rbEbook.setLayoutX(390);
		rbEbook.setLayoutY(180);
		ToggleGroup group = new ToggleGroup();

		rbPaperback.setToggleGroup(group);
		rbEbook.setToggleGroup(group);

		Z_Books_Controller newBOOK = new Z_Books_Controller();
		b1.setOnAction(e -> {
			ArrayList<Zh_Genre> newZhner = new ArrayList<>();
			boolean isPaperback = rbPaperback.isSelected();
			String isbn13 = ISBN.getText();
			String titlee = title.getText();
			double price = Double.parseDouble(Price.getText());
			String descriptionn = description.getText();
			String authorr = author.getText();
			boolean isPaperback1 = rbPaperback.isSelected();

			for (int i = 0; i < genreCheckboxes.size(); i++) {
				if (genreCheckboxes.get(i).isSelected())
					newZhner.add(Zh_Genre.values()[i]);
			}
			Zh_Books isCreated = newBOOK.loginn(titlee, isbn13, Integer.parseInt(quntity.getText()), descriptionn,
					price, new V_Author(authorr), isPaperback1);
			isCreated.setGenres(newZhner);

			if (isCreated != null) {

				write(isCreated);

				Book_Sold boook = new Book_Sold(new Zh_MyDate(d.getValue().getMonthValue(),
						d.getValue().getDayOfMonth(), d.getValue().getYear()), "11");
				writeBought(boook);

			} else {
				System.out.println("lol");
			}
		});

//			  
				b2.setOnAction(e -> {
					
					try {
						view.View(stage,WelcomeName );
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				});
		

		Pane pane = new Pane();

		pane.getChildren().addAll(title, Ltitle, ISBN, LISBN, Price, LPrice, description, Ldescription, Lquntity,
				quntity, author, Lauthor, paneForGenres, genreLbl, rbPaperback, rbEbook, b1, d,b2);

		Image image = new Image("file:pasloginbosh.png"); // Replace with your image file path

		BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		pane.setBackground(new javafx.scene.layout.Background(bgImg));

		Scene scene = new Scene(pane, 700, 500);
		stage.setTitle("Log in");
		stage.setScene(scene);
		stage.show();

	}

	private static void writeBought(Book_Sold boook) {

		ArrayList<Book_Sold> listBooks = new ArrayList<Book_Sold>();

		FileInputStream fis;
		try {

			fis = new FileInputStream("booksBought.dat");

			ObjectInputStream objis = new ObjectInputStream(fis);

			while (objis != null) {

				Book_Sold obj = ((Book_Sold) objis.readObject());
				listBooks.add(obj);
			}

			objis.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			listBooks.add(boook);
			SaveBooks(listBooks);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
////		
////.................................................		
//	
//print file

	private static void SaveBooks(ArrayList<Book_Sold> listBooks) {

		FileOutputStream out;
		try {
			out = new FileOutputStream("booksBought.dat");
			ObjectOutputStream output = new ObjectOutputStream(out);

			for (int i = 0; i < listBooks.size(); i++) {
				output.writeObject(listBooks.get(i));
			}

			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}

	}

	private static void write(Zh_Books isCreated) {

		ArrayList<Zh_Books> listBooks = new ArrayList<Zh_Books>();

		FileInputStream fis;
		try {

			fis = new FileInputStream("Books.dat");

			ObjectInputStream objis = new ObjectInputStream(fis);

			Zh_Books obj = new Zh_Books();

			while (obj != null) {

				obj = ((Zh_Books) objis.readObject());
				listBooks.add(obj);
			}

			objis.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			listBooks.add(isCreated);
			AddMenuBar(listBooks);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
////			
////.................................................		
//		
//print file

	private static void AddMenuBar(ArrayList<Zh_Books> listBooks) {

		FileOutputStream out;
		try {
			out = new FileOutputStream("Books.dat");
			ObjectOutputStream output = new ObjectOutputStream(out);

			for (int i = 0; i < listBooks.size(); i++) {
				output.writeObject(listBooks.get(i));
			}

			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("1. " + e);
		}

	}

}
