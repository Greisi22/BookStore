

package View.Menager;


import java.io.*;
import java.util.ArrayList;

import Model.Books.BookFunctionalities;
import Model.Books.BookService;
import Test.Librarian.Books.Zh_Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;


public class UpdateBook {
	private static String a;
	private static double b;
	private static String c;
	private static int d;
	@SuppressWarnings("unchecked")
	public static void Update_Book_View(Stage stage)
	{
		
		
		
		
		//................................................................................................//
	ArrayList<Zh_Books> listBooks = new ArrayList<Zh_Books>();
		FileInputStream fis = null;
		ObjectInputStream objis = null;
		try {
			fis = new FileInputStream("src/EncodedInformation/Books.dat");
			 objis = new ObjectInputStream(fis);

			Zh_Books obj = new Zh_Books() ;
		while(obj!=null)
		{
			
			obj = ((Zh_Books) objis.readObject());
			listBooks.add(obj);
		}
		//objis.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			try {
				if (objis != null) {
					objis.close();
				}

					fis.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(listBooks);
		TableView<Zh_Books> userTable = new TableView<Zh_Books>();
		ObservableList<Zh_Books> data = FXCollections.observableArrayList(listBooks); 
		userTable.setItems(data);
		
		//........................................................................................................
		userTable.setEditable(true);
		
	//........................................................................................................
	
		TableColumn title = new TableColumn("title");
		TableColumn ISBN = new TableColumn("ISBN");
		TableColumn quanity = new TableColumn("quanity");
		TableColumn description = new TableColumn("description");
		TableColumn price = new TableColumn("price");
		TableColumn author = new TableColumn(" author");
		TableColumn paperback = new TableColumn(" paperback");
		TableColumn genres = new TableColumn("genres");
		TableColumn genresS = new TableColumn("genresS");
		
		
		title.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("title"));
		title.setCellFactory(TextFieldTableCell.forTableColumn());

		BookService bookService = new BookService();
		title.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,String>>(){
			@Override
			public void handle(CellEditEvent<Zh_Books, String> event) {
			      Zh_Books b1 = event.getRowValue();
			      b1.setTitle(event.getNewValue());
				ArrayList<Zh_Books> temp  = BookFunctionalities.UpdateBook(b1);
				bookService.writeBooksInFile(temp, "src/EncodedInformation/Books.dat");
			}
		});
		//.........................................................................
	
		ISBN.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("ISBN"));
		ISBN.setCellFactory(TextFieldTableCell.forTableColumn());
		ISBN.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,String>>(){

		@Override
			public void handle(CellEditEvent<Zh_Books, String> event) {
				
			 Zh_Books b1 = event.getRowValue();
		      b1.setISBN((event.getNewValue()));
			ArrayList<Zh_Books> temp  = BookFunctionalities.UpdateBook(b1);
			bookService.writeBooksInFile(temp, "src/EncodedInformation/Books.dat");
			}
		
		});
		//.........................................................................
		
		quanity.setCellValueFactory(new PropertyValueFactory<Zh_Books, Integer>("quanity"));
		quanity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		quanity.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,String>>(){

		@Override
			public void handle(CellEditEvent<Zh_Books, String> event) {
				
			 Zh_Books b1 = event.getRowValue();
		      b1.setQuanity(Integer.parseInt(event.getNewValue()));
			ArrayList<Zh_Books> temp  = BookFunctionalities.UpdateBook(b1);
			bookService.writeBooksInFile(temp, "src/EncodedInformation/Books.dat");
			}
		
		});
		//.........................................................................
		
		description.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("description"));
		description.setCellFactory(TextFieldTableCell.forTableColumn());
		description.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,String>>(){

		@Override
			public void handle(CellEditEvent<Zh_Books, String> event) {
				
			 Zh_Books b1 = event.getRowValue();
		      b1.setDescription(event.getNewValue());;
			ArrayList<Zh_Books> temp  = BookFunctionalities.UpdateBook(b1);
			bookService.writeBooksInFile(temp, "src/EncodedInformation/Books.dat");
			}
		
		});
		price.setCellValueFactory(new PropertyValueFactory<Zh_Books, Double>("price"));
		price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		price.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,Double>>(){

	

		@Override
		public void handle(CellEditEvent<Zh_Books, Double> event) {
	
			 Zh_Books b1 = event.getRowValue();
		      b1.setPrice(event.getNewValue());
			ArrayList<Zh_Books> temp  = BookFunctionalities.UpdateBook(b1);
			bookService.writeBooksInFile(temp, "src/EncodedInformation/Books.dat");
		}
		
		});
		//.........................................................................
		
		author.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("author"));
//		author.setCellFactory(TextFieldTableCell.forTableColumn());
//		author.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,String>>(){
//
//		@Override
//			public void handle(CellEditEvent<Zh_Books, String> event) {
//				
////			 Zh_Books b1 = event.getRowValue();
////		      b1.setAuthor(event.getNewValue());;
////		      updateBook(b1);
//			}
//		
//		});
//		//.........................................................................
		
		paperback.setCellValueFactory(new PropertyValueFactory<Zh_Books, Boolean>("paperback"));
		paperback.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
		paperback.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,Boolean>>(){


		@Override
		public void handle(CellEditEvent<Zh_Books, Boolean> event) {
			Zh_Books b1 = event.getRowValue();
		      b1.setPaperback(event.getNewValue());
			ArrayList<Zh_Books> temp  = BookFunctionalities.UpdateBook(b1);
			bookService.writeBooksInFile(temp, "src/EncodedInformation/Books.dat");
			
		}
		
		});
		//.........................................................................
		
		genresS.setCellValueFactory(new PropertyValueFactory<Zh_Books, String>("genresS"));
		genresS.setCellFactory(TextFieldTableCell.forTableColumn());
		genresS.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,String>>(){

		@Override
			public void handle(CellEditEvent<Zh_Books, String> event) {
			Zh_Books b1 = event.getRowValue();
		      b1.setGenresS(event.getNewValue());
			ArrayList<Zh_Books> temp  = BookFunctionalities.UpdateBook(b1);
			bookService.writeBooksInFile(temp, "src/EncodedInformation/Books.dat");
			}
		
		});

		


	
        FilteredList<Zh_Books> flPerson = new FilteredList(data, p -> true);//Pass the data to a filtered list
        userTable.setItems(flPerson);//Set the table's items using the filtered list
    	userTable.getColumns().addAll(title,ISBN,quanity,description,price,author,paperback,genresS);
    	//........................................................................

    	

    	
    	Pane pane = new Pane();
		pane.getChildren().addAll(userTable);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add("try.css");
		Stage stage1 = new Stage();
    	
			stage1.setScene(scene);

			stage1.show();

	}


	}




