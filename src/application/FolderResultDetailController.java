package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Similarity;
import model.SimilarityInterval;


/**
 * Controller for folder result detail page
 * For presenting result detail of folders comparison
 * 
 */
public class FolderResultDetailController extends AnchorPane implements Initializable {

	
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
	
	
	// All files in two folders
    private List<Similarity> folder1 = new ArrayList<>();
    private List<Similarity> folder2 = new ArrayList<>();
    
    // save similar line number of two files
 	private int[] file1Index;
 	private int[] file2Index;
	
 	private List<SimilarityInterval> file1Range = new ArrayList<>();
 	private List<SimilarityInterval> file2Range = new ArrayList<>();
 	
 	int index1 = 0;
 	int index2 = 0;
 	
	/**
	 * setApp()
	 * @param application
	 * set application for this controller and get data from application
	 * when initialized
	 */
	public void setApp(App application) {
		this.application = application;
		folder1 = application.getFolder1Sim();
		folder2 = application.getFolder2Sim();
		updateView();
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
	 * @throws IOException
	 *             show the percentage result page
	 */
	@FXML
	private void backToPercentageResult(Event event) throws IOException {
		application.gotoPercentageResult();
	}

	/**
	 * prevFile1
	 * @param event
	 * show previous file in folder1
	 */
	@FXML
	private void prevFile1(Event event) {
		index1 = (index1 == 0 ? folder1.size() - 1 : index1 - 1); 
		updateView();
	}
	
	
	/**
	 * nextFile1
	 * @param event
	 * show next file in folder1
	 */
	@FXML
	private void nextFile1(Event event) {
		index1 = (index1 == folder1.size() - 1 ? 0 : index1 + 1); 
		updateView();
	}
	
	
	/**
	 * prevFile2
	 * @param event
	 * show previous file in folder2
	 */
	@FXML
	private void prevFile2(Event event) {
		index2 = (index2 == 0 ? folder2.size() - 1 : index2 - 1); 
		updateView();
	}
	
	
	/**
	 * nextFile2
	 * @param event
	 * show next file in folder2
	 */
	@FXML
	private void nextFile2(Event event) {
		index2 = (index2 == folder2.size() - 1 ? 0 : index2 + 1); 
		updateView();
	}
	
	
	/**
	 * Update label, text when user switchs to another files
	 */
	private void updateView() {
		File1TextFlow.getChildren().clear();
		File2TextFlow.getChildren().clear();
		
		File1Label.setText(folder1.get(index1).getFilename());
		File2Label.setText(folder2.get(index2).getFilename());
		
		file1Range = folder1.get(index1).getSimilarities();
		file2Range = folder2.get(index2).getSimilarities();
		
		file1Index = setIndex(folder1.get(index1).getFileContent(), file1Range);
		file2Index = setIndex(folder2.get(index2).getFileContent(), file2Range);
		
		// update TextFlow
		File1TextFlow.getChildren().addAll(getTextList(folder1.get(index1).getFileContent(), file1Index));
		File2TextFlow.getChildren().addAll(getTextList(folder2.get(index2).getFileContent(), file2Index));
	}
	
	
	
	/**
	 * getTextList()
	 * 
	 * @param file
	 * @param index
	 * @return get a list of Text with code and different color depends on index
	 *         list
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
	 * @return  the array of similar range content
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
