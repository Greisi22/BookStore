package Administator;



import Librarian.B__Log_in;
import Librarian.CA__Librarian_View;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class View {
	static String WelcomeName;
public static void FirstView(Stage stage, String WelcomeName1)
{
	WelcomeName = WelcomeName1;
	Pane pane = new Pane();

	
	Button users = new Button("Users");
	users.setPrefSize(100, 30);
	users.setLayoutX(150);
	users.setLayoutY(400);
	users.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
	users.setFont(new Font("Glacial Indifference", 12));

	
	Button signup = new Button("Sign Up");
	signup.setPrefSize(100, 30);
	signup.setLayoutX(260);
	signup.setLayoutY(400);
	signup.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
	signup.setFont(new Font("Glacial Indifference", 12));

	
	Button Statistic = new Button("Statistic");
	Statistic.setPrefSize(100, 30);
	Statistic.setLayoutX(370);
	Statistic.setLayoutY(400);
	Statistic.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
	Statistic.setFont(new Font("Glacial Indifference", 12));

	Button signout = new Button("Sign Out");
	signout.setPrefSize(100, 30);
	signout.setLayoutX(480);
	signout.setLayoutY(400);
	signout.setStyle("-fx-background-color: #B1A2CF; -fx-text-fill: white;");
	signout.setFont(new Font("Glacial Indifference", 12));

	   Label label_WelcomeName = new Label("Welcome "+WelcomeName);
	     label_WelcomeName.setFont(Font.font("Roboto Mono Regular", 27));
	       	label_WelcomeName.setTextFill(Color.web("#79CBE1"));
	       	label_WelcomeName.setLayoutX(260);
	       	label_WelcomeName.setLayoutY(300);
	
	users.setOnAction(e->{
		

		Users.ModUsers();
	
		});
	signout.setOnAction(e->{
		

		B__Log_in.Log_inn(stage);
	
		});
	
	Statistic.setOnAction(e->{
		
		 Admini_Statistic .SignUpView(stage,WelcomeName);
		
		});
	
	signup.setOnAction(e->{
		
SignUp.SignUpView(stage, WelcomeName1);
		
		});
	
	
	Image image = new Image("file:paslogin.png"); // Replace with your image file path

	BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	pane.setBackground(new javafx.scene.layout.Background(bgImg));

	
	pane.getChildren().addAll(signup,users,Statistic,signout,label_WelcomeName);
	Scene scene = new Scene(pane,700,500);
	stage.setTitle("Log in");
	stage.setScene(scene);
	stage.show();
	
	
}
	
	
}
