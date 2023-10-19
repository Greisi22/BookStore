//package Administator;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//
//import Librarian.D_Users;
//import Librarian.Zh_Books;
//import Librarian.Zh_MyDate;
//import Librarian.Zh_accessLevel;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.util.converter.BooleanStringConverter;
//import javafx.util.converter.DoubleStringConverter;
//import javafx.util.converter.IntegerStringConverter;
//import javafx.util.converter.LongStringConverter;
//
//public class Users {
//@SuppressWarnings("unchecked")
//public static void ModUsers()
//{
//	//................................................................................................//
//	ArrayList<D_Users> listBooks = new ArrayList<D_Users>();
//		
//		FileInputStream fis;
//		try {
//			fis = new FileInputStream("Users.dat");
//			ObjectInputStream objis = new ObjectInputStream(fis);
//		
//			
//	
//		while(objis!=null)
//		{
//			
//			D_Users	obj = ((D_Users) objis.readObject());
//			listBooks.add(obj);
//		}
//		objis.close();
//			
//		} catch (FileNotFoundException e1) {
//		
//		} catch (IOException e1) {
//			
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		TableView<D_Users> userTable = new TableView<D_Users>();
//		ObservableList<D_Users> data = FXCollections.observableArrayList(listBooks); 
//		userTable.setItems(data);
//		
//		//........................................................................................................
//		userTable.setEditable(true);
//		
//	//........................................................................................................
//	
//		TableColumn firstName = new TableColumn("firstName");
//		TableColumn lastName = new TableColumn("lastName");
//		TableColumn email = new TableColumn("email");
//		TableColumn birthday = new TableColumn("birthday");
//		TableColumn password = new TableColumn("password");
//		TableColumn salery = new TableColumn(" salery");
//		TableColumn phone = new TableColumn(" phone");
//		TableColumn accesLevel = new TableColumn("accesLevel");
//
//		firstName.setCellValueFactory(new PropertyValueFactory<D_Users, String>("firstName"));
//		firstName.setCellFactory(TextFieldTableCell.forTableColumn());
//		firstName.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, String> event) {
//				
//		            	D_Users b1 = event.getRowValue();
//			      b1.setFirstName(event.getNewValue());
//			  //    updateBook(b1);
//			}
//
//
//		
//		});
////		//.........................................................................
////	
//		lastName.setCellValueFactory(new PropertyValueFactory<D_Users, String>("lastName"));
//		lastName.setCellFactory(TextFieldTableCell.forTableColumn());
//		lastName.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, String> event) {
//				
//			D_Users b1 = event.getRowValue();
//		      b1.setLastName(event.getNewValue());
//		   //   updateBook(b1);
//			}
//		
//		});
//		//.........................................................................
////		
//		email.setCellValueFactory(new PropertyValueFactory<D_Users, String>("email"));
//		email.setCellFactory(TextFieldTableCell.forTableColumn());
//		email.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, String> event) {
//				
//			D_Users b1 = event.getRowValue();
//		      b1.setEmail(event.getNewValue());
//		     // updateBook(b1);
//			}
//		
//		});
////		//.........................................................................
////		
//		birthday.setCellValueFactory(new PropertyValueFactory<D_Users, Zh_MyDate>("birthday"));
//		birthday.setCellFactory(TextFieldTableCell.forTableColumn(new ZH_MyDateStringConverter()));
//		birthday.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,Zh_MyDate>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, Zh_MyDate> event) {
//				
//			D_Users b1 = event.getRowValue();
//			b1.setBirthday(event.getNewValue());
//	
//	
//		     updateBook(b1);
//			}
//		
//		});
//		
//		password.setCellValueFactory(new PropertyValueFactory<D_Users, String>("password"));
//		password.setCellFactory(TextFieldTableCell.forTableColumn());
//		password.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, String> event) {
//				
//			D_Users b1 = event.getRowValue();
//			b1.setPassword(event.getNewValue());
//	
//	
//		 //   updateBook(b1);
//			}
//		
//		});
//		
//		salery.setCellValueFactory(new PropertyValueFactory<D_Users, Long>("salery"));
//		salery.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter() ));
//		salery.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,Long>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, Long> event) {
//				
//			D_Users b1 = event.getRowValue();
//			b1.setSalery(event.getNewValue());;
//	
//	
//		   updateBook(b1);
//			}
//		
//		});
//		
//		phone.setCellValueFactory(new PropertyValueFactory<D_Users, String>("phone"));
//		phone.setCellFactory(TextFieldTableCell.forTableColumn());
//		phone.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, String> event) {
//				
//			D_Users b1 = event.getRowValue();
//			b1.setPhone(event.getNewValue());
//	
//	
//		   updateBook(b1);
//			}
//		
//		});
//		
//		accesLevel.setCellValueFactory(new PropertyValueFactory<D_Users, Zh_accessLevel>("accesLevel"));
//		accesLevel.setCellFactory(TextFieldTableCell.forTableColumn(new Zh_accessLevelStringConverter()));
//		accesLevel.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,Zh_accessLevel>>(){
//
//		@Override
//			public void handle(CellEditEvent<D_Users, Zh_accessLevel> event) {
//				
//			D_Users b1 = event.getRowValue();
//			b1.setAccesLevel(event.getNewValue());
//	
//	
//		   updateBook(b1);
//			}
//		
//		});
//
//		
//		userTable.getColumns().addAll(firstName,lastName,email,birthday,password,salery,phone,accesLevel);
//
//		Pane pane = new Pane();
//		pane.getChildren().addAll(userTable);
//
//		Scene scene = new Scene(pane);
//
//		Stage stage1 = new Stage();
//    	
//			stage1.setScene(scene);
//
//			stage1.show();
//
//
//		
//}
//static ArrayList<D_Users> newBooks1 = new ArrayList<D_Users>();	
//private static  void updateBook(D_Users b1) {
//	FileInputStream fis;
//	try {
//
//		fis = new FileInputStream("Users.dat");
//
//		 ObjectInputStream objis = new ObjectInputStream(fis);
//
//	while(objis!=null)
//	{
//		D_Users obj = ((D_Users) objis.readObject());
//	if(obj.getPassword().equals(b1.getPassword())) {
//		
//		obj=b1;
//	}
//	newBooks1.add(obj);
//	}
//
//
//	objis.close();
//	} catch (FileNotFoundException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	} catch (IOException e) {
//
//		FileOutputStream out;
//		try {
//			out = new FileOutputStream("Users.dat");
//			ObjectOutputStream objout = new ObjectOutputStream(out);
//			for(int i=0;i<newBooks1.size();i++)
//			{
//				objout.writeObject(newBooks1.get(i));
//			}
//			newBooks1.clear();
//			objout.close();
//			
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			System.out.println("u kryy ");
//		}
//		
//		
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	
//	
//}
//
//}

package Administator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Librarian.D_Users;
import Librarian.Zh_Books;
import Librarian.Zh_MyDate;
import Librarian.Zh_accessLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

public class Users {
@SuppressWarnings("unchecked")
public static void ModUsers()
{
	//................................................................................................//
	ArrayList<D_Users> listBooks = new ArrayList<D_Users>();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("Users.dat");
			ObjectInputStream objis = new ObjectInputStream(fis);
		
			
	
		while(objis!=null)
		{
			
			D_Users	obj = ((D_Users) objis.readObject());
			listBooks.add(obj);
		}
		objis.close();
			
		} catch (FileNotFoundException e1) {
		
		} catch (IOException e1) {
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TableView<D_Users> userTable = new TableView<D_Users>();
		ObservableList<D_Users> data = FXCollections.observableArrayList(listBooks); 
		userTable.setItems(data);
		
		//........................................................................................................
		userTable.setEditable(true);
		
	//........................................................................................................
	
		TableColumn firstName = new TableColumn("First Name");
		TableColumn lastName = new TableColumn("Last Name");
		TableColumn email = new TableColumn("Email");
		TableColumn birthday = new TableColumn("Birthday");
		TableColumn password = new TableColumn("Password");
		TableColumn salery = new TableColumn(" Salery");
		TableColumn phone = new TableColumn(" Phone");
		TableColumn accesLevel = new TableColumn("Acces Level");

		firstName.setCellValueFactory(new PropertyValueFactory<D_Users, String>("firstName"));
		firstName.setCellFactory(TextFieldTableCell.forTableColumn());
		firstName.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){

		@Override
			public void handle(CellEditEvent<D_Users, String> event) {
				
		            	D_Users b1 = event.getRowValue();
			      b1.setFirstName(event.getNewValue());
			  //    updateBook(b1);
			}


		
		});
//		//.........................................................................
//	
		lastName.setCellValueFactory(new PropertyValueFactory<D_Users, String>("lastName"));
		lastName.setCellFactory(TextFieldTableCell.forTableColumn());
		lastName.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){

		@Override
			public void handle(CellEditEvent<D_Users, String> event) {
				
			D_Users b1 = event.getRowValue();
		      b1.setLastName(event.getNewValue());
		   //   updateBook(b1);
			}
		
		});
		//.........................................................................
//		
		email.setCellValueFactory(new PropertyValueFactory<D_Users, String>("email"));
		email.setCellFactory(TextFieldTableCell.forTableColumn());
		email.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){

		@Override
			public void handle(CellEditEvent<D_Users, String> event) {
				
			D_Users b1 = event.getRowValue();
		      b1.setEmail(event.getNewValue());
		     // updateBook(b1);
			}
		
		});
//		//.........................................................................
//		
		birthday.setCellValueFactory(new PropertyValueFactory<D_Users, Zh_MyDate>("birthday"));
		birthday.setCellFactory(TextFieldTableCell.forTableColumn(new ZH_MyDateStringConverter()));
		birthday.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,Zh_MyDate>>(){

		@Override
			public void handle(CellEditEvent<D_Users, Zh_MyDate> event) {
				
			D_Users b1 = event.getRowValue();
			b1.setBirthday(event.getNewValue());
	
	
		     updateBook(b1);
			}
		
		});
		
		password.setCellValueFactory(new PropertyValueFactory<D_Users, String>("password"));
		password.setCellFactory(TextFieldTableCell.forTableColumn());
		password.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){

		@Override
			public void handle(CellEditEvent<D_Users, String> event) {
				
			D_Users b1 = event.getRowValue();
			b1.setPassword(event.getNewValue());
	
	
		 //   updateBook(b1);
			}
		
		});
		
		salery.setCellValueFactory(new PropertyValueFactory<D_Users, Long>("salery"));
		salery.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter() ));
		salery.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,Long>>(){

		@Override
			public void handle(CellEditEvent<D_Users, Long> event) {
				
			D_Users b1 = event.getRowValue();
			b1.setSalery(event.getNewValue());;
	
	
		   updateBook(b1);
			}
		
		});
		
		phone.setCellValueFactory(new PropertyValueFactory<D_Users, String>("phone"));
		phone.setCellFactory(TextFieldTableCell.forTableColumn());
		phone.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,String>>(){

		@Override
			public void handle(CellEditEvent<D_Users, String> event) {
				
			D_Users b1 = event.getRowValue();
			b1.setPhone(event.getNewValue());
	
	
		   updateBook(b1);
			}
		
		});
		
		accesLevel.setCellValueFactory(new PropertyValueFactory<D_Users, Zh_accessLevel>("accesLevel"));
		accesLevel.setCellFactory(TextFieldTableCell.forTableColumn(new Zh_accessLevelStringConverter()));
		accesLevel.setOnEditCommit(new EventHandler<CellEditEvent<D_Users,Zh_accessLevel>>(){

		@Override
			public void handle(CellEditEvent<D_Users, Zh_accessLevel> event) {
				
			D_Users b1 = event.getRowValue();
			b1.setAccesLevel(event.getNewValue());
	
	
		   updateBook(b1);
			}
		
		});

		
		userTable.getColumns().addAll(firstName,lastName,email,birthday,password,salery,phone,accesLevel);

		Pane pane = new Pane();
		pane.getChildren().addAll(userTable);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add("try.css");
		Stage stage1 = new Stage();
    	
			stage1.setScene(scene);

			stage1.show();


		
}
static ArrayList<D_Users> newBooks1 = new ArrayList<D_Users>();	
private static  void updateBook(D_Users b1) {
	FileInputStream fis;
	try {

		fis = new FileInputStream("Users.dat");

		 ObjectInputStream objis = new ObjectInputStream(fis);

	while(objis!=null)
	{
		D_Users obj = ((D_Users) objis.readObject());
	if(obj.getPassword().equals(b1.getPassword())) {
		
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
			out = new FileOutputStream("Users.dat");
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
