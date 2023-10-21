
package Librarian;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class F_ShowBill {
	

	static double total = 0;
	private static ObjectInputStream objis;	
	static ArrayList<String> listaaa11;
	
	public static void ShowBill(ArrayList<String> listaaa, ArrayList<Double> listaaa1, Pane pane2, Stage stage1, 
		Stage stage, ArrayList<String> listaaa2, String WelcomeName)
	{
		
			listaaa11 = listaaa2;
		
		HBox [] hBoxs = new HBox[listaaa.size()];
		VBox [] vBoxs = new VBox[listaaa.size()];
		VBox vBoxs1 = new VBox();
	
			for(int i=0;i<listaaa.size();i++)
			{
				Label l1 = new Label("Book: "+listaaa.get(i));
				
				
				l1.setFont(Font.font("Roboto Mono Regular", FontWeight.BOLD,14));
				l1.setTextFill(Color.web("#79CBE1"));
				
				Label l2 = new Label("       Price: "+listaaa1.get(i)+"");
		
				l2.setFont(Font.font("Roboto Mono Regular", FontWeight.BOLD,14));
				l2.setTextFill(Color.web("#79CBE1"));
				
				hBoxs[i] = new HBox();
				vBoxs[i] = new VBox(); 
				hBoxs[i].getChildren().addAll(l1,l2);
				vBoxs[i].getChildren().add(hBoxs[i]);
			}
			
			 total=0;
		for(int i=0;i<listaaa.size();i++)
		{
			vBoxs1.getChildren().add(vBoxs[i]);
			total+=listaaa1.get(i);
		}
		vBoxs1.setPadding(new Insets(60, 5, 5, 40));
	
		vBoxs1.setSpacing(12);
	
		

    	Button Print = new Button("Print Bill"); 
    	Print.setPrefSize(100, 30);
    	Print.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
    	Print.setFont(new Font("Glacial Indifference", 12));
    	Print.setLayoutX(522);
    	Print.setLayoutY(400);
    	    

    	
    	Button Back = new Button("Back");  
    	Back.setPrefSize(100, 30);
    	Back.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
    	Back.setFont(new Font("Glacial Indifference", 12));
    	Back.setLayoutX(522);
    	Back.setLayoutY(435);
    	
    	Button ClearBill = new Button("Clear");  
    	ClearBill.setPrefSize(100, 30);
    	ClearBill.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
    	ClearBill.setFont(new Font("Glacial Indifference", 12));
    	ClearBill.setLayoutX(522);
    	ClearBill.setLayoutY(365);
   
    	DatePicker d = new DatePicker();
		 
		 d.setLayoutX(476);
		 d.setLayoutY(150);

		 Image image = new Image("file:src/UI/Images/showBillimg.png"); // Replace with your image file path

			BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

			

	 
		vBoxs1.setLayoutX(30);
    	vBoxs1.setLayoutY(100);
    	
    	Pane pane = new Pane();
        pane.getChildren().addAll(vBoxs1,Print,Back,d,ClearBill);	
        pane.setBackground(new javafx.scene.layout.Background(bgImg));
    	Scene scene = new Scene(pane,pane2.getWidth(),pane2.getHeight());
		stage1.setScene(scene);
		stage1.show();
		
		Back.setOnAction(e->{
			
			stage1.close();
				CA__Librarian_View.showTable(stage);
		
			});
		
		
		ClearBill.setOnAction(e->{
			listaaa.clear();
			listaaa1.clear();
			ShowBill(listaaa,  listaaa1,  pane2,  stage1, 
					stage,  listaaa2, WelcomeName);
		
			});
		
		//objecti i controllerit
Zh_Bill_Controller newBill = new Zh_Bill_Controller();

		
		Print.setOnAction(e->{

   E_Bill isCreated = newBill.loginn(total,new Zh_MyDate(d.getValue().getMonthValue(),d.getValue().getDayOfMonth(),d.getValue().getYear()));
	 isCreated.setBook_name(listaaa);
	 isCreated.setBookquantity(listaaa.size());
	 


		 write(isCreated);
		 
		 File file = new File("src/TextFiles/cnt.txt");
		 try {
			Scanner input = new Scanner(file);
			String a = input.next();
			int cnt = Integer.parseInt(a);
			cnt++;
			input.close();
			FileWriter file1 = new FileWriter("src/TextFiles/cnt.txt");
			file1.write((cnt)+"");
			file1.close();
			PrintWriter pfile = new PrintWriter("src/Bill"+cnt);
			pfile.write("**************Bill************\n");

			 StringBuilder s1 = new StringBuilder();
			 for (int i = 0; i < listaaa.size(); i++) {
				 s1.append(listaaa.get(i)).append(" ");
			 }

			pfile.write("Books Taken: "+ s1+"\n");
			pfile.write("Total Price: "+ total+"\n");
			pfile.write("Date"+isCreated.getDate()+"\n");
			pfile.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			});
		
	}

	private static  void write(E_Bill isCreated){
		ArrayList<E_Bill> listBooks = new ArrayList<E_Bill>();
				FileInputStream fis;
					try {
						fis = new FileInputStream("src/EncodedInformation/Bills.dat");
						objis = new ObjectInputStream(fis);

						while (true) {
							try {
								E_Bill obj = (E_Bill) objis.readObject();
								listBooks.add(obj);
							} catch (EOFException e) {
								break;
							}
						}

					objis.close();

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						listBooks.add(isCreated);
						putInFile(listBooks);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}  finally {
						// Check if objis is not null before attempting to close it
						if (objis != null) {
							try {
								objis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

			}

	private static void putInFile(ArrayList<E_Bill> listBooks) {
		FileOutputStream out;
		try {
			out = new FileOutputStream("src/EncodedInformation/Bills.dat");
			ObjectOutputStream objout = new ObjectOutputStream(out);
			
			for(int i=0;i<listBooks.size();i++)
			{
				objout.writeObject(listBooks.get(i));
				
			}

			for(int i=0;i<listaaa11.size();i++)
			{
				UpdateBook(listaaa11.get(i));
			}
		listaaa11.clear();
								objout.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
           System.out.println(e);
		}
		
	}
	static ArrayList<Zh_Books> newBooks1 = new ArrayList<Zh_Books>();
	
	private static void UpdateBook(String Isbn) {
		FileInputStream fis;
		try {

			fis = new FileInputStream("Books.dat");
			objis = new ObjectInputStream(fis);

			while (true) {
				try {
					Zh_Books obj = (Zh_Books) objis.readObject();
					if (obj.getISBN().equals(Isbn)) {
						int a = obj.getQuanity();
						a -= 1;
						obj.setQuanity(a);
					}
					newBooks1.add(obj);
				} catch (EOFException e) {
					break;
				}
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
