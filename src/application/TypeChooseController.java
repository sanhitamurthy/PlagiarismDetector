package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TypeChooseController extends AnchorPane implements Initializable  {

	/**
	 * FXML elements in main page
	 */
	@FXML
	ImageView JavaCompareImage;
	
	@FXML
	ImageView FolderCompareImage;
	
	@FXML
	Button JavaButton;
	
	@FXML
	Button FolderButton;
	
	private App application;

	
	/**
	 * setApp
	 * @param application
	 * set application for this controller when initialized
	 */
	public void setApp(App application) {
		this.application = application;
	}

	/**
	 * initialize()
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * setApp
	 *
	 * @param event : The action of the user choosing the folder which
	 *              is given as input
	 *              calls the controller where the chooseFolder function does the
	 *              required functionality
	 */
	@FXML
	public void chooseFolder(Event event) throws IOException {
		application.chooseFolder();
	}

    /**
     * setApp
     *
     * @param event : The action of the user choosing the folder which
     *              is given as input
     *              calls the controller where the file to be uploaded has to be java is checked.
     */
	@FXML
	public void chooseJava(Event event) throws IOException {
		application.gotoJavaMainPage();
	}
	
}
