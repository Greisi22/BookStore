

package com.example.View.Menager;

import java.io.*;
import java.util.ArrayList;


import com.example.Model.Books.Author;
import com.example.Model.Books.BookService;
import com.example.Model.Books.Books;
import com.example.Model.Books.Genre;
import com.example.View.Librarian.BooksController;
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

public class MenagerCreateBook {


	public static void BookView(Stage stage, String WelcomeName) {
		TextField title = new TextField();
		title.setLayoutX(300);
		title.setLayoutY(50);
		title.setId("title");



		Label Ltitle = new Label("Title");
		Ltitle.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Ltitle.setTextFill(Color.web("#3BA6A2"));
		Ltitle.setLayoutX(250);
		Ltitle.setLayoutY(50);
		Ltitle.setId("Ltitle");



		TextField ISBN = new TextField();
		ISBN.setLayoutX(300);
		ISBN.setLayoutY(100);
		ISBN.setId("ISBN");

		Label LISBN = new Label("ISBN");
		LISBN.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		LISBN.setTextFill(Color.web("#3BA6A2"));
		LISBN.setLayoutX(250);
		LISBN.setLayoutY(100);
		LISBN.setId("LISBN");

		TextField Price = new TextField();
		Price.setLayoutX(300);
		Price.setLayoutY(150);
		Price.setId("Price");

		Label LPrice = new Label("Price");
		LPrice.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		LPrice.setTextFill(Color.web("#3BA6A2"));
		LPrice.setLayoutX(250);
		LPrice.setLayoutY(150);
		LPrice.setId("LPrice");

		TextArea description = new TextArea();
		description.setLayoutX(300);
		description.setLayoutY(220);
		description.setPrefRowCount(2);
		description.setPrefColumnCount(20);
		description.setId("description");

		Label Ldescription = new Label("Description");
		Ldescription.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Ldescription.setTextFill(Color.web("#3BA6A2"));
		Ldescription.setLayoutX(215);
		Ldescription.setLayoutY(220);


		TextField author = new TextField();
		author.setLayoutX(300);
		author.setLayoutY(280);
		author.setId("author");

		Label Lauthor = new Label("Author");
		Lauthor.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Lauthor.setTextFill(Color.web("#3BA6A2"));
		Lauthor.setLayoutX(245);
		Lauthor.setLayoutY(280);

		TextField quntity = new TextField();
		quntity.setLayoutX(300);
		quntity.setLayoutY(320);
		quntity.setId("quntity");

		Label Lquntity = new Label("Quantity");
		Lquntity.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		Lquntity.setTextFill(Color.web("#3BA6A2"));
		Lquntity.setLayoutX(230);
		Lquntity.setLayoutY(320);

		DatePicker d = new DatePicker();

		d.setLayoutX(400);
		d.setLayoutY(400);
		d.setId("dataPicker");

		Button b1 = new Button("Add Book");
		b1.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		b1.setLayoutX(440);
		b1.setLayoutY(450);
		b1.setId("addbook");

		Button b2 = new Button("Back");
		b2.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		b2.setLayoutX(650);
		b2.setLayoutY(450);
		b2.setId("back");


		VBox paneForGenres = new VBox(10);
		paneForGenres.setPadding(new Insets(4));
		ArrayList<CheckBox> genreCheckboxes = new ArrayList<>();
		int cnt=0;
		for (Genre g : Genre.values()) {
			CheckBox chb = new CheckBox(g.toString());
			chb.setId("checkboxGenre" + cnt);
			genreCheckboxes.add(chb);
			chb.setFont(Font.font("Arimo", FontWeight.BOLD, 12));
			chb.setTextFill(Color.web("#3BA6A2"));
        cnt++;
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
		rbPaperback.setId("paperBack");

		RadioButton rbEbook = new RadioButton("E-book");
		rbEbook.setFont(Font.font("Arimo", FontWeight.BOLD, 13));
		rbEbook.setTextFill(Color.web("#3BA6A2"));
		rbEbook.setLayoutX(390);
		rbEbook.setLayoutY(180);


		ToggleGroup group = new ToggleGroup();
		rbPaperback.setToggleGroup(group);
		rbEbook.setToggleGroup(group);

		BookService bookService = new BookService();


		BooksController newBOOK = new BooksController();
		b1.setOnAction(e -> {
			ArrayList<Genre> newZhner = new ArrayList<>();
			boolean isPaperback = rbPaperback.isSelected();
			String isbn13 = ISBN.getText();
			String titlee = title.getText();
			double price = Double.parseDouble(Price.getText());
			String descriptionn = description.getText();
			String authorr = author.getText();
			boolean isPaperback1 = rbPaperback.isSelected();

			for (int i = 0; i < genreCheckboxes.size(); i++) {
				if (genreCheckboxes.get(i).isSelected())
					newZhner.add(Genre.values()[i]);
			}
			Books isCreated = newBOOK.loginn(titlee, isbn13, Integer.parseInt(quntity.getText()), descriptionn,
					price, new Author(authorr), isPaperback1);
			isCreated.setGenres(newZhner);


			ArrayList<Books> booklist = new ArrayList<>();
			booklist = bookService.getBooks("src/main/java/com/example/EncodedInformation/Books.dat");
			booklist.add(isCreated);
			bookService.writeBooksInFile(booklist, "src/main/java/com/example/EncodedInformation/Books.dat");

//			Book_Sold boook = new Book_Sold(new Zh_MyDate(d.getValue().getMonthValue(),
//					d.getValue().getDayOfMonth(), d.getValue().getYear()), isbn13);
//			ArrayList<Book_Sold> listBooks = new ArrayList<>();
//			BookBoughtFunctionalities.getBooksBought(listBooks);
//			listBooks.add(boook);
//			BookBoughtFunctionalities.saveBookBought(listBooks);


		});

//			  
		b2.setOnAction(e -> {

			try {
				ManagerView.View(stage, WelcomeName);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});


		Pane pane = new Pane();

		pane.getChildren().addAll(title, Ltitle, ISBN, LISBN, Price, LPrice, description, Ldescription, Lquntity,
				quntity, author, Lauthor, paneForGenres, genreLbl, rbPaperback, rbEbook, b1, d, b2);

		Image image = new Image("file:src/main/java/com/example/UI/Images/pasloginbosh.pngg"); // Replace with your image file path

		BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		pane.setBackground(new javafx.scene.layout.Background(bgImg));

		Scene scene = new Scene(pane, 700, 500);
		stage.setTitle("Log in");
		stage.setScene(scene);
		stage.show();

	}



}
