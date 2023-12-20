package View.Menager;

import java.io.*;

import Model.Bills.Bill;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menager_Statistic {
	 final static String January = "January";
	    final static String February = "February";
	    final static String March = "March";
	    final static String April = "April";
	    final static String May = "May";
	    final static String June = "June";
	    final static String July = "July";
	    final static String August = "August";
	    final static String September = "September";
	    final static String October = "October";
	    final static String November = "November";
	    final static String December = "December";
	
	    

	    
	public static void Satistic_View(Stage stage, String Name)
	{
		

		 Button button = new Button("Back");
		 button.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		 button.setLayoutX(650);
		 button.setLayoutY(460);
 
		        stage.setTitle("Bar Chart Sample");
		        final CategoryAxis xAxis = new CategoryAxis();
		        final NumberAxis yAxis = new NumberAxis();
		        final BarChart<String,Number> bc = 
		            new BarChart<String,Number>(xAxis,yAxis);
		        bc.setTitle("Books statistics");
		        xAxis.setLabel("Year");       
		        yAxis.setLabel("Number of Books");  
		        XYChart.Series series1 = new XYChart.Series();    
		        series1.setName("Sold");
		        series1.getData().add(new XYChart.Data(January, getnumber(1)));
		        series1.getData().add(new XYChart.Data(February, getnumber(2)));
		        series1.getData().add(new XYChart.Data(March, getnumber(3)));
		        series1.getData().add(new XYChart.Data(April, getnumber(4)));
		        series1.getData().add(new XYChart.Data(May, getnumber(5)));
		        series1.getData().add(new XYChart.Data(June, getnumber(6)));
		        series1.getData().add(new XYChart.Data(July, getnumber(7)));
		        series1.getData().add(new XYChart.Data(August, getnumber(8)));
		        series1.getData().add(new XYChart.Data(September, getnumber(9)));
		        series1.getData().add(new XYChart.Data(October, getnumber(10)));
		        series1.getData().add(new XYChart.Data(November, getnumber(11)));
		        series1.getData().add(new XYChart.Data(December, getnumber(12)));
		        
		        XYChart.Series series2 = new XYChart.Series();
		        series2.setName("Bought");
		        series2.getData().add(new XYChart.Data(January, getnumber1(1)));
		        series2.getData().add(new XYChart.Data(February, getnumber1(2)));
		        series2.getData().add(new XYChart.Data(March, getnumber1(3)));
		        series2.getData().add(new XYChart.Data(April, getnumber1(4)));
		        series2.getData().add(new XYChart.Data(May, getnumber1(5)));
		        series2.getData().add(new XYChart.Data(June, getnumber1(6)));
		        series2.getData().add(new XYChart.Data(July, getnumber1(7)));
		        series2.getData().add(new XYChart.Data(August, getnumber1(8)));
		        series2.getData().add(new XYChart.Data(September, getnumber1(9)));
		        series2.getData().add(new XYChart.Data(October, getnumber1(10)));
		        series2.getData().add(new XYChart.Data(November, getnumber1(11)));
		        series2.getData().add(new XYChart.Data(December, getnumber1(12)));

		      Pane pane = new Pane();
		      bc.setPrefWidth(800);
		      bc.setPrefHeight(500);
		      pane.getChildren().addAll(bc,button);
		        Scene scene  = new Scene(pane,800,500);
		        bc.getData().addAll(series1, series2);
		        stage.setScene(scene);
		        stage.show();
		
			button.setOnAction(e->{
				try {
					view.View(stage, Name);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	
		
	}

	private static int getnumber(int z) {
		FileInputStream fis;
		int sum =0;
		ObjectInputStream objis;

		try {
			fis = new FileInputStream("src/EncodedInformation/Bolls.dat");
		    objis = new ObjectInputStream(fis);
			
		while(true)
		{
			try {
				Bill obj = ((Bill) objis.readObject());
				if(obj.getDate().getYear() == 2023 && obj.getDate().getMonth()==z )
				{
					sum+=obj.getBookquantity();
				}
			}catch (EOFException e) {
				break; // End of the stream
			}

			
		}
		objis.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			
			return sum;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return 1;
	}
	private static int getnumber1(int z) {
		FileInputStream fis;
		int sum = 0;
		ObjectInputStream objis = null;

		try {
			fis = new FileInputStream("src/EncodedInformation/booksBought.dat");
			objis = new ObjectInputStream(fis);

			while (true) {
				try {
					Book_Sold obj = (Book_Sold) objis.readObject();
					if (obj.getDate().getYear() == 2023 && obj.getDate().getMonth() == z) {
						sum += 1;
					}
				} catch (EOFException e) {
					// End of file reached, exit the loop
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			if (objis != null) {
				try {
					objis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sum;
	}



}
