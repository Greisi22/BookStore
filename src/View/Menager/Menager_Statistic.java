package View.Menager;

import java.io.*;
import java.util.ArrayList;

import Model.Bills.Bill;
import Model.Statistic.StatisticFunctionalities;
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
	    static final String bookPath = "src/EncodedInformation/Books.dat";
	    static final String billPath = "src/EncodedInformation/Bills.dat";
	    

	    
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
		        series1.setName("Bought");

		        series1.getData().add(new XYChart.Data(January, StatisticFunctionalities.getBookCost(2023, 1, bookPath)));
		        series1.getData().add(new XYChart.Data(February,StatisticFunctionalities.getBookCost(2023, 2, bookPath)));
		        series1.getData().add(new XYChart.Data(March, StatisticFunctionalities.getBookCost(2023, 3, bookPath)));
		        series1.getData().add(new XYChart.Data(April, StatisticFunctionalities.getBookCost(2023, 4, bookPath)));
		        series1.getData().add(new XYChart.Data(May, StatisticFunctionalities.getBookCost(2023, 5, bookPath)));
		        series1.getData().add(new XYChart.Data(June, StatisticFunctionalities.getBookCost(2023, 6, bookPath)));
		        series1.getData().add(new XYChart.Data(July, StatisticFunctionalities.getBookCost(2023, 7, bookPath)));
		        series1.getData().add(new XYChart.Data(August,StatisticFunctionalities.getBookCost(2023, 8, bookPath)));
		        series1.getData().add(new XYChart.Data(September, StatisticFunctionalities.getBookCost(2023, 9, bookPath)));
		        series1.getData().add(new XYChart.Data(October, StatisticFunctionalities.getBookCost(2023, 10, bookPath)));
		        series1.getData().add(new XYChart.Data(November,StatisticFunctionalities.getBookCost(2023, 11, bookPath)));
		        series1.getData().add(new XYChart.Data(December, StatisticFunctionalities.getBookCost(2023, 12, bookPath)));
		        
		        XYChart.Series series2 = new XYChart.Series();
		        series2.setName("Sold");
		        series2.getData().add(new XYChart.Data(January,StatisticFunctionalities.getBookRevenue(2023, 1, billPath)));
		        series2.getData().add(new XYChart.Data(February,StatisticFunctionalities.getBookRevenue(2023, 2, billPath)));
		        series2.getData().add(new XYChart.Data(March, StatisticFunctionalities.getBookRevenue(2023, 3, billPath)));
		        series2.getData().add(new XYChart.Data(April, StatisticFunctionalities.getBookRevenue(2023, 4, billPath)));
		        series2.getData().add(new XYChart.Data(May, StatisticFunctionalities.getBookRevenue(2023, 5, billPath)));
		        series2.getData().add(new XYChart.Data(June, StatisticFunctionalities.getBookRevenue(2023, 6, billPath)));
		        series2.getData().add(new XYChart.Data(July, StatisticFunctionalities.getBookRevenue(2023, 7, billPath)));
		        series2.getData().add(new XYChart.Data(August, StatisticFunctionalities.getBookRevenue(2023, 8, billPath)));
		        series2.getData().add(new XYChart.Data(September, StatisticFunctionalities.getBookRevenue(2023, 9, billPath)));
		        series2.getData().add(new XYChart.Data(October, StatisticFunctionalities.getBookRevenue(2023, 10, billPath)));
		        series2.getData().add(new XYChart.Data(November, StatisticFunctionalities.getBookRevenue(2023, 11, billPath)));
		        series2.getData().add(new XYChart.Data(December, StatisticFunctionalities.getBookRevenue(2023, 12, billPath)));

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






}
