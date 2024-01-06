package View.Administator;

import java.util.Map;

import Model.Statistic.StatisticFunctionalities;
import Model.Users.UserService;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Admini_Statistic {
	private static UserService userService = new UserService();
	private static final String path = "src/EncodedInformation/Bills.dat";


	
	@SuppressWarnings("unchecked")
	public static void SignUpView(Stage stage, String Name) {
		

		 Button button = new Button("Back");
		 button.setStyle("-fx-background-color: #79CBE1; -fx-text-fill: white;");
		 button.setLayoutX(650);
		 button.setLayoutY(460);
		





//...............................................



        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Books statistics");
        xAxis.setLabel("Year");       
        yAxis.setLabel("Number of Books");  
        XYChart.Series series1 = new XYChart.Series();    
        series1.setName("Money Make");

		Map<String, Double> getLibrariabn = StatisticFunctionalities.getLibrarianInfo(path);

		for (Map.Entry<String, Double> entry : getLibrariabn.entrySet()) {
			series1.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
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
