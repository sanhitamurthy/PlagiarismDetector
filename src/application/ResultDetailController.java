package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.javafx.robot.impl.FXRobotHelper;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.SimilarityInterval;

/**
 * ResultDetailController Controller for presenting detailed result of
 * comparison with highlighting similar parts of codes controls two text flow
 * and two labels
 */
public class ResultDetailController extends AnchorPane implements Initializable {

	/**
	 * FXML element in result detail page
	 */
	@FXML
	private TextFlow File1TextFlow;
	@FXML
	private TextFlow File2TextFlow;
	@FXML
	private Label File1Label;
	@FXML
	private Label File2Label;

	private App application;

	// save similar line number of two files
 	private int[] file1Index;
 	private int[] file2Index;
	
 	private List<SimilarityInterval> file1Range = new ArrayList<>();
 	private List<SimilarityInterval> file2Range = new ArrayList<>();
	
	/**
	 * setApp()
	 * @param application
	 * set application for this controller and get data from application
	 * when initialized
	 * set file label and highlight similar codes
	 */
	public void setApp(App application) {

		this.application = application;

		File1Label.setText(application.getFile1Name());
		File2Label.setText(application.getFile2Name());

		file1Index = setIndex(application.getFile1().getFileContent(), application.getFile1().getSimilarities());
		file2Index = setIndex(application.getFile2().getFileContent(), application.getFile2().getSimilarities());

		// update TextFlow
		File1TextFlow.getChildren().addAll(getTextList(application.getFile1().getFileContent(), file1Index));
		File2TextFlow.getChildren().addAll(getTextList(application.getFile2().getFileContent(), file2Index));

	}

	/**
	 * initialize()
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * backToPercentageResult
	 *
	 * @param event
	 * @throws IOException show the percentage result page
	 */
	@FXML
	private void backToPercentageResult(Event event) throws IOException {
		application.gotoPercentageResult();
	}

	

	
	/**
	 * getTextList()
	 *
	 * @param file  : the file which is passed for comparision
	 * @param index : the index where the coed matches
	 * @return get a list of Text with code and different color depends on index
	 * list
	 */
	private List<Text> getTextList(String file, int[] index) {
		String[] split = file.split("\n");
		List<Text> res = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			Text t = new Text(split[i] + "\n");
			if (index[i] == 1) {
				t.setFill(Color.RED);
			}
			res.add(t);
		}

		return res;
	}
	
	
	/**
	 * setIndex
	 * @param content java file content
	 * @param ranges list of range 
	 * @return the array of the similar content
	 */
	private int[] setIndex(String content, List<SimilarityInterval> ranges) {
		String[] split = content.split("\n");
		int[] res = new int[split.length];
		for(SimilarityInterval i : ranges) {
			for(int j = i.getStartLine() ; j <= i.getEndLine() && j <= res.length ; j++) {
				res[j - 1] = 1;
			}
		}
		return res;
		
	}
	

}
