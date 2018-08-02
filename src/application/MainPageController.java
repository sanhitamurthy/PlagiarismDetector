package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.javafx.robot.impl.FXRobotHelper;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * Controller for Main page of this application
 * Implements file upload function and then goes to result pages
 */
public class MainPageController extends AnchorPane implements Initializable {

	/**
	 * FXML elements in main page
	 */
	@FXML
	private Button CompareButton; 
	@FXML
	private ImageView File1Image;
	@FXML
	private ImageView File2Image;
	@FXML
	private ImageView BackImage;
	@FXML
	private Label FileLabel1;
	@FXML
	private Label FileLabel2;
	
	
	private String file1Path;
	private String file2Path;

	
	/**
	 * flag value to indicates whether user has uploaded file
	 */
	boolean hasFile1;
	boolean hasFile2;

	private App application;


	/**
	 * setApp
	 * @param application
	 * set application for this controller when initialized
	 */
	public void setApp(App application) {
		this.application = application;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}


	/**
	 * file1Chooser
	 *
	 * @param event show file chooser window when click on file1 button
	 *              update file1 label if user chooses a java file
	 */
	@FXML
	public void file1Chooser(Event event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Java File", "*.java")
		);
		ObservableList<Stage> stage = FXRobotHelper.getStages();
		File file1 = fileChooser.showOpenDialog(stage.get(0));
		if(file1 == null) {
			return;
		}
		FileLabel1.setText(file1.getName());
		setfile1(file1);
	}

	/**
	 * setfile1
	 *
	 * @param :the file which has been chosen for the first comparision
	 *             this function is for testing purposes where we want to set the
	 *             file which has been chosen
	 */
	public void setfile1(File file1){
		file1Path = file1.getAbsolutePath();

		application.setFile1Name(file1.getName());
		application.setFile1Path(file1.getAbsolutePath());
		this.hasFile1 = true;
	}

    /**
     * file2Chooser
     *
     * @param event show file chooser window when click on file2 button
     *              update file2 label when user chooses a java file
     */
	@FXML
	public void file2Chooser(Event event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Java File", "*.java")
        );
		ObservableList<Stage> stage = FXRobotHelper.getStages();
		File file2 = fileChooser.showOpenDialog(stage.get(0));
        if(file2 == null) {
            return;
        }
        FileLabel2.setText(file2.getName());
        setfile2(file2);
    }

    /**
     * setfile2
     *
     * @param :the file which has been chosen for the second comparision.
     *             this function is for testing purposes where we want to set the
     *             file which has been chosen
     */
    public void setfile2(File file2){
        file2Path = file2.getAbsolutePath();
        application.setFile2Name(file2.getName());
        application.setFile2Path(file2.getAbsolutePath());
        hasFile2 = true;
    }

    /**
     * @return hasFile1
     * for testing purposes only
     */
    public boolean gethasfilevalue(){
        return this.hasFile1;
    }

    /**
     * @return hasFile2
     * for testing purposes only
     */
    public boolean gethasfile2value(){
        return this.hasFile2;
    }

    /**
     * showResult
     *
     * @throws IOException If user have selected two files, then go to result page
     *                     If user haven't selected two files, pop up an alert window
     */
	@FXML
	public void showResult() throws IOException {
		if(!(hasFile1 && hasFile2)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please upload two *.java Files for comparison");

			alert.showAndWait();
			return;
		}

		application.compareFiles();

	}

    /**
     * backToType
     *
     * @throws IOException the user can go back to choose the format of files he wants to upload
     */
	@FXML
	public void backToType() throws IOException {
		application.returnToTypeChoosePage();
	}



}