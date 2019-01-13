package application;

import java.io.File;
import java.io.FileNotFoundException;

import application.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Controller
{
	private Model model = new Model();

	@FXML
	private TextField tfPP;

	@FXML
	private TextField tfAOI;

	@FXML
	private Button bKonwertuj;

	@FXML
	private Button bPP;

	@FXML
	private Button bAOI;

	@FXML
	private void bKonwertujOnAction(ActionEvent event)
	{
		try
		{
			model.getPPfromFile(tfPP.getText());
			model.saveAoiCoordinatesToFile(tfAOI.getText());

			if (model.getListOfAoiCoordinates().isEmpty() == false)
			{
				Alert alertDone = new Alert(AlertType.INFORMATION, "Współrzędne zostały " + "przekonwertowane");
				Stage stage = (Stage) alertDone.getDialogPane().getScene().getWindow();
				stage.getIcons().add(new Image(PickAndPlaceToAOIConverter.class.getResourceAsStream("/icon1.png")));
				alertDone.showAndWait();
				model.getListOfAoiCoordinates().clear();
			}

			else
			{
				Alert alertFail = new Alert(AlertType.ERROR, "Błąd przy konwertowaniu " + "współrzędnych");
				Stage stage = (Stage) alertFail.getDialogPane().getScene().getWindow();
				stage.getIcons().add(new Image(PickAndPlaceToAOIConverter.class.getResourceAsStream("/icon1.png")));
				alertFail.showAndWait();
			}
		} 
		
		catch (FileNotFoundException e)
		{
			Alert alertFail = new Alert(AlertType.ERROR, "Błąd przy konwertowaniu " + "współrzędnych");
			Stage stage = (Stage) alertFail.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(PickAndPlaceToAOIConverter.class.getResourceAsStream("/icon1.png")));
			alertFail.showAndWait();
		}
	}

	@FXML
	private void bPPOnAction(ActionEvent event)
	{
		FileChooser fileChooserPP = new FileChooser();
		fileChooserPP.getExtensionFilters().add(new ExtensionFilter(".txt files", "*.txt"));
		File file = fileChooserPP.showOpenDialog(null);
		
		try
		{
			if (!file.equals(null))
			{
				tfPP.setText(file.getAbsolutePath());
			}

			if (tfPP.getText().equals(null) && tfAOI.getText().equals(null))
			{
				bKonwertuj.setDisable(false);
			}
		}
		
		catch(NullPointerException e)
		{
			
		}
	}

	@FXML
	private void bAOIOnAction(ActionEvent event)
	{
		FileChooser fileChooserAOI = new FileChooser();
		fileChooserAOI.getInitialFileName();
		fileChooserAOI.getExtensionFilters().add(new ExtensionFilter(".txt files", "*.txt"));
		File file = fileChooserAOI.showSaveDialog(null);

		try
		{
			if (!file.equals(null))
			{
				tfAOI.setText(file.getAbsolutePath());
			}

			if (!tfPP.getText().equals(null) && !tfAOI.getText().equals(null))
			{
				bKonwertuj.setDisable(false);
			}
		}
		catch(NullPointerException e)
		{
			
		}
	}
}