package Administator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Librarian.D_Users;
import Librarian.E_Bill;
import Librarian.Zh_Books;
import Librarian.Zh_accessLevel;
import Menager.Book_Sold;
import Menager.view;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Admini_Statistic {


	
	@SuppressWarnings("unchecked")
	public static void SignUpView(Stage stage, String Name) {
		

		 Button button = new Button("Back");
		 button.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		 button.setLayoutX(650);
		 button.setLayoutY(460);
		
ArrayList<D_Users> list = new ArrayList<D_Users>();
ArrayList<Integer> list3 = new ArrayList<Integer>();

FileInputStream fis;
try {
	fis = new FileInputStream("Users.dat");
	ObjectInputStream objis = new ObjectInputStream(fis);

	
	while (objis != null) {

		D_Users obj = ((D_Users) objis.readObject());
		list.add(obj);
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

//...............................................
FileInputStream fis1;
double sum =0;
for(int i=0;i<list.size();i++)
{
try {
	
	fis1 = new FileInputStream("Bills.dat");
	ObjectInputStream objis1 = new ObjectInputStream(fis1);
 sum = 0;

	while (objis1 != null) {

		E_Bill obj = ((E_Bill) objis1.readObject());
		if(list.get(i).getFirstName().equals(obj.getLibrarian_Name()))
		{
			
			sum +=(double) obj.getPrice();
		}
	
	}
	objis1.close();


	}


 catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	list3.add((int)sum);
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
}


        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        int cnt =10;
    
        bc.setTitle("Books statistics");
        xAxis.setLabel("Year");       
        yAxis.setLabel("Number of Books");  
        XYChart.Series series1 = new XYChart.Series();    
        series1.setName("Money Make");
        for(int i=0;i<list3.size();i++)
        {
        	if(list.get(i).getAccesLevel().equals(Zh_accessLevel.LIBRARIAN))
            series1.getData().add(new XYChart.Data(list.get(i).getFirstName().toString(), cnt+=3));
        }
   
   
        Pane pane = new Pane();
	      bc.setPrefWidth(800);
	      bc.setPrefHeight(500);
	      pane.getChildren().addAll(bc,button);


        
        Scene scene  = new Scene(pane,800,500);
bc.getData().addAll(series1);



        stage.setScene(scene);
        stage.show();
        
        
		button.setOnAction(e->{
			View.FirstView(stage, Name);
		});
		
		
	
	}
	


	
}
