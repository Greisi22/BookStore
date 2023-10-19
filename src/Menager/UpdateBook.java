

package Menager;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Librarian.Zh_Books;
import Librarian.Zh_Genre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.css.converter.StringConverter;
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
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("Books.dat");
			ObjectInputStream objis = new ObjectInputStream(fis);
		
			
			Zh_Books obj = new Zh_Books() ;
		while(obj!=null)
		{
			
			obj = ((Zh_Books) objis.readObject());
			listBooks.add(obj);
		}
		objis.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		title.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,String>>(){

		@Override
			public void handle(CellEditEvent<Zh_Books, String> event) {
				
			      Zh_Books b1 = event.getRowValue();
			      b1.setTitle(event.getNewValue());
			      updateBook(b1);
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
		      updateBook(b1);
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
		      updateBook(b1);
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
		      updateBook(b1);
			}
		
		});
		price.setCellValueFactory(new PropertyValueFactory<Zh_Books, Double>("price"));
		price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		price.setOnEditCommit(new EventHandler<CellEditEvent<Zh_Books,Double>>(){

	

		@Override
		public void handle(CellEditEvent<Zh_Books, Double> event) {
	
			 Zh_Books b1 = event.getRowValue();
		      b1.setPrice(event.getNewValue());
		      updateBook(b1);
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
		      updateBook(b1);
			
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
		      updateBook(b1);
		
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
	static ArrayList<Zh_Books> newBooks1 = new ArrayList<Zh_Books>();
	private static  void updateBook(Zh_Books b1) {
		FileInputStream fis;
		try {

			fis = new FileInputStream("Books.dat");
	
			 ObjectInputStream objis = new ObjectInputStream(fis);

		while(objis!=null)
		{
			Zh_Books obj = ((Zh_Books) objis.readObject());
		if(obj.getISBN().equals(b1.getISBN())) {
			
			obj=b1;
		}
		newBooks1.add(obj);
		}


		objis.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
	
			FileOutputStream out;
			try {
				out = new FileOutputStream("Books.dat");
				ObjectOutputStream objout = new ObjectOutputStream(out);
				for(int i=0;i<newBooks1.size();i++)
				{
					objout.writeObject(newBooks1.get(i));
				}
				newBooks1.clear();
				objout.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("u kryy ");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}

