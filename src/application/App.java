package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Similarity;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

import javax.xml.transform.Result;

import detector.implmentation.java.Detector;
import detector.implmentation.java.JavaFileReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * App class for scene changing and model of this application Store data used in
 * this application Show different pages for different user operations
 */
public class App extends Application {

	private String file1Name; // name of file1
	private String file2Name; // name of file2

	private String file1Path; // path of file1
	private String file2Path; // path of file2

	private Similarity file1; // file1 uploaded
	private Similarity file2; // file2 uploaded

	private Double percentageResult = 0.0; // percentage result of comparison

	boolean isFolder;

	/**
	 * all files in folder
	 */
	private List<Similarity> folder1Sim = new ArrayList<>();
	private List<Similarity> folder2Sim = new ArrayList<>();

	private Group root = new Group();

	/**
	 * createContent
	 *
	 * @return Create a scene with main page And return the Group of this
	 *         application
	 */
	public Parent createContent() {
		gotoTypeChoosePage();
		return root;
	}

	/**
	 * Start()
	 *
	 * @param primaryStage
	 *            the pane which shows up for displaying the main page for this
	 *            application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setResizable(false);
			primaryStage.setTitle("Plagiarism Detector");
			primaryStage.setScene(new Scene(createContent()));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * compareFiles() Compares two files with algorithm, saves the result and shows
	 * result page Be called when users upload two files and click on compare button
	 */
	public void compareFiles() {
		try {
			// reads files and runs compare algorithm
			Detector d = new Detector();
			d.compareFiles(file1Path, file2Path);
			// save the result of comparison
			percentageResult = d.getResult() * 100;

			file1 = d.getFolder1Sim().get(0);
			file2 = d.getFolder2Sim().get(0);

			gotoPercentageResult(); // show the percentage result page
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());

			alert.showAndWait();
			return;
		}

	}

	/**
	 * compareDirs() Compare two folders with ast-cc algorithm, saves the result and
	 * shows result page
	 */
	public void compareDirs() {
		try {
			Detector d = new Detector();
			d.compareDirs(file1Path, file2Path);

			percentageResult = d.getResult() * 100;
			folder1Sim = d.getFolder1Sim();
			folder2Sim = d.getFolder2Sim();

			gotoPercentageResult();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());

			alert.showAndWait();
			return;
		}
	}

	/**
	 * chooseFolder() This function allows the user ot go the screen where the
	 * directories(folders) will be uploaded
	 */
	public void chooseFolder() {
		gotoFolderMainPage();
	}

	/**
	 * returnToTypeChoosePage() This function allows the user to go back to original
	 * screen where he can select whether he wants to upload files via a folder or
	 * just upload java files
	 */
	public void returnToTypeChoosePage() {
		clear();
		gotoTypeChoosePage();
	}

	/**
	 * returnToMainPage() Go back to main page of application
	 */
	public void returnToMainPage() {
		if (isFolder) {
			gotoFolderMainPage();
		} else {
			gotoMainPage();
		}
	}

	/**
	 * gotoJavaMainPage() switch to main page for java files
	 */
	public void gotoJavaMainPage() {
		gotoMainPage();
	}

	/**
	 * viewDetailedResult() go to view detailed result of comparison
	 */
	public void viewDetailedResult() {
		if (isFolder) {
			gotoFolderDetailedResult();
		} else {
			gotoDetailedResult();
		}
	}

	/**
	 * gotoFolderMainPage() The function which directs you to the screen where you
	 * can upload 2 folders instead of just java files
	 */
	private void gotoFolderMainPage() {
		try {
			isFolder = true;
			FolderMainPageController folder = (FolderMainPageController) replaceSceneContent("FolderMain.fxml");
			folder.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * gotoFolderDetailedResult() switch to folder comparison result details page
	 */
	private void gotoFolderDetailedResult() {
		try {
			FolderResultDetailController detail = (FolderResultDetailController) replaceSceneContent(
					"FolderResultDetail.fxml");
			detail.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * gotoTypeChoosePage() show type choose page of application
	 */
	private void gotoTypeChoosePage() {
		try {
			TypeChooseController type = (TypeChooseController) replaceSceneContent("TypeChoose.fxml");
			type.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * gotoMainPage() show main page of application
	 */
	private void gotoMainPage() {
		try {
			isFolder = false;
			MainPageController main = (MainPageController) replaceSceneContent("Main.fxml");
			main.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * gotoPercentageResult() show percentage result page of application
	 */
	public void gotoPercentageResult() {
		try {

			PercentageResultController result = (PercentageResultController) replaceSceneContent(
					"PercentageResult.fxml");
			result.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * gotoDetailedResult() show detailed result page of application
	 */
	private void gotoDetailedResult() {
		try {
			ResultDetailController detail = (ResultDetailController) replaceSceneContent("ResultDetail.fxml");
			detail.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * replcaeSceneContent(String fxml)
	 *
	 * @param fxml
	 *            : the fxml which has to be loaded
	 * @return : the shows the result respective to the fxml which has been given as
	 *         input to the function
	 * @throws Exception
	 */
	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();

		InputStream in = App.class.getResourceAsStream(fxml);

		loader.setBuilderFactory(new JavaFXBuilderFactory());

		loader.setLocation(App.class.getResource(fxml));

		AnchorPane page;

		try {

			page = (AnchorPane) loader.load(in);

		} finally {

			in.close();

		}

		root.getChildren().removeAll();
		root.getChildren().addAll(page);

		return (Initializable) loader.getController();
	}

	/**
	 * clear() restore all data in App when come back to main page
	 */
	public void clear() {
		file1 = null;
		file2 = null;

		percentageResult = 0.0;
	}

	/**
	 * readFile(String path)
	 *
	 * @param path
	 *            the path of the file whose contents are need to be read
	 * @return the content of the file which is being read from the give path
	 */
	private String readFile(String path) {
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			list = stream.collect(Collectors.toList());
			for (String s : list) {
				sb.append(s + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	/**
	 * setter and getter function of App class
	 */

	public String getFile1Name() {
		return file1Name;
	}

	public void setFile1Name(String file1Name) {
		this.file1Name = file1Name;
	}

	public String getFile2Name() {
		return file2Name;
	}

	public void setFile2Name(String file2Name) {
		this.file2Name = file2Name;
	}

	public Double getPercentageResult() {
		return percentageResult;
	}

	public void setFile1Path(String file1Path) {
		this.file1Path = file1Path;
	}

	public void setFile2Path(String file2Path) {
		this.file2Path = file2Path;
	}

	public List<Similarity> getFolder1Sim() {
		return folder1Sim;
	}

	public void setFolder1Sim(List<Similarity> folder1Sim) {
		this.folder1Sim = folder1Sim;
	}

	public List<Similarity> getFolder2Sim() {
		return folder2Sim;
	}

	public void setFolder2Sim(List<Similarity> folder2Sim) {
		this.folder2Sim = folder2Sim;
	}

	public Similarity getFile1() {
		return file1;
	}

	public void setFile1(Similarity file1) {
		this.file1 = file1;
	}

	public Similarity getFile2() {
		return file2;
	}

	public void setFile2(Similarity file2) {
		this.file2 = file2;
	}
}
