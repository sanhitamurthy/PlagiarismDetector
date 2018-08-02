package application;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import com.sun.javafx.robot.impl.FXRobotHelper;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * PercentageResultController
 * The controller for percentage result page which only shows percentage result of comparison
 * Can changes to detailed result page or go back to main page
 * Shows Percentage result with different colors depends on result 
 */
public class PercentageResultController extends AnchorPane implements Initializable {

	/**
	 * FXML element in percentage result page
	 */
	
	@FXML
	Button BackToMainButton;
	@FXML
	Button ViewDetailButton;
	@FXML
	Label PercentageResultLabel;

	private App application; // App model for this controler


	/**
	 * setApp
	 *
	 * @param application Initialize the element in this page when presented
	 */
	public void setApp(App application) {
	    this.application = application;
	    
	    DecimalFormat df = new DecimalFormat("#.#");
	    double percentage = application.getPercentageResult();
	    PercentageResultLabel.setText(df.format(application.getPercentageResult()) + " %");
	    if(percentage > 75) {
	    		PercentageResultLabel.setTextFill(Color.RED);
	    }
	    else if(percentage > 40) {
	    		PercentageResultLabel.setTextFill(Color.ORANGE);
	    }
	    else {
	    		PercentageResultLabel.setTextFill(Color.GREENYELLOW);
	    }
    }

	/**
	 * initialize()
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}


	/**
	 * backToMainPage
	 *
	 * @param event
	 * @throws IOException Jumps to Main Page and cleans all data
	 */
	@FXML
	private void backToMainPage(Event event) throws IOException {
        application.returnToMainPage();
        application.clear();
	}


	/**
	 * viewDetail
	 *
	 * @param event
	 * @throws IOException Jumps to detailed result page
	 */
	@FXML
	private void viewDetail(Event event) throws IOException {
        application.viewDetailedResult();
	}
	
}
