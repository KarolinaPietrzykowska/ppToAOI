package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PickAndPlaceToAOIConverter extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		primaryStage.setTitle("Konwerter Pick&Place na AOI");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("icon1.png"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}
