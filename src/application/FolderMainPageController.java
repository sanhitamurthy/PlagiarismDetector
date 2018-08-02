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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * Controller for Main page of this application
 * Implements file upload function and then goes to result pages
 */
public class FolderMainPageController extends AnchorPane implements Initializable {

    /**
     * FXML elements in main page
     */
    @FXML
    private Button CompareButton;
    @FXML
    private ImageView Folder1Image;
    @FXML
    private ImageView Folder2Image;
    @FXML
    private ImageView BackImage;
    @FXML
    private Label FolderLabel1;
    @FXML
    private Label FolderLabel2;

    private String folder1Path;
    private String folder2Path;


    /**
     * flag value to indicates whether user has uploaded folders
     */
    boolean hasFolder1;
    boolean hasFolder2;

    private App application;


    /**
     * setApp
     *
     * @param application set application for this controller when initialized
     */
    public void setApp(App application) {
        this.application = application;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    /**
     * folder1Chooser
     *
     * @param event: the event when the user clicks on choosing the file
     *               show folder chooser window when click on button
     *               update folder1 label if user chooses a folder
     */
    @FXML
    public void folder1Chooser(Event event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        File selectedDirectory = directoryChooser.showDialog(stage.get(0));
        if (selectedDirectory == null) {
            return;
        } else {
            FolderLabel1.setText(selectedDirectory.getAbsolutePath());
            folder1Path = selectedDirectory.getAbsolutePath();
            application.setFile1Path(selectedDirectory.getAbsolutePath());
            hasFolder1 = true;
        }
    }


    /**
     * folder2Chooser
     *
     * @param event :the event when the user clicks on choosing the file
     *              show folder chooser window when click on folder2 button update
     *              folder2 label when user chooses a folder
     */
    @FXML
    public void folder2Chooser(Event event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        File selectedDirectory = directoryChooser.showDialog(stage.get(0));
        if (selectedDirectory == null) {
            return;
        } else {
            FolderLabel2.setText(selectedDirectory.getAbsolutePath());
            folder2Path = selectedDirectory.getAbsolutePath();
            application.setFile2Path(selectedDirectory.getAbsolutePath());
            hasFolder2 = true;
        }

    }


    /**
     * showResult
     *
     * @param event : the event when the user clicks on the button to show the result
     * @throws IOException If user have selected two files, then go to result page
     *                     If user haven't selected two files, pop up an alert window
     */
    @FXML
    public void showResult(Event event) throws IOException {
        if (!(hasFolder1 && hasFolder2)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select two folders for comparison");

            alert.showAndWait();
            return;
        }
        application.compareDirs();
    }


    /**
     * backToType
     *
     * @param event
     * @throws IOException the user can go back to choose the format of files he wants to upload
     */
    @FXML
    public void backToType(Event event) throws IOException {
        application.returnToTypeChoosePage();
    }


}