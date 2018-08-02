package detector.implmentation.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import detector.abstraction.AFileReader;
import detector.abstraction.Node;
import detector.abstraction.Parser;
import detector.factory.JavaPlagiarismDetectorFactory;
import model.Similarity;


/**
 * The Class Detector: this is the start class of the backend functionality
 * which accepts teo directories as input and compares then and gives the result after
 * comparision
 */
public class Detector {

	/**
	 * Gets the single instance of Detector.
	 *
	 * @return single instance of Detector
	 */
	private Double result;

	
	/** */
	private List<Similarity> folder1Sim;
	private List<Similarity> folder2Sim;
	
	
	/** The instance. */
	private static Detector instance;
	
	
	/**
	 * Instantiates a new detector.
	 */
	public Detector() {
		
	}

	/**
	 * compareDirs(String path1, String path2)
	 *
	 * @param path1 the path of the first directory which contains the java files
	 * @param path2 the path of the second directory which contains the java files
	 */
	public void compareDirs(String path1, String path2) {
		Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
		ASTCCSimilarityChecker checker = new ASTCCSimilarityChecker(parser);
		result = checker.compareDirs(path1, path2);
		folder1Sim = SimilarRange.getSimilarityMetaFromNodes(checker.hashBasedSortedNodes1);
		folder2Sim = SimilarRange.getSimilarityMetaFromNodes(checker.hashBasedSortedNodes2);
	}

	/**
	 * compareFiles(String path1, String path2)
	 *
	 * @param path1 the path of the first java file
	 * @param path2 the path of the second java file
	 */
	public void compareFiles(String path1, String path2) {
		Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
		ASTCCSimilarityChecker checker = new ASTCCSimilarityChecker(parser);
		result = checker.compareFiles(path1, path2);
		folder1Sim = SimilarRange.getSimilarityMetaFromNodes(checker.hashBasedSortedNodes1);
		folder2Sim = SimilarRange.getSimilarityMetaFromNodes(checker.hashBasedSortedNodes2);

	}
	
	
	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Double getResult() {
		return result;
	}


	/**
	  * returns the list of Similarity of first folder
	  */
	public List<Similarity> getFolder1Sim() {
		return folder1Sim;
	}
	
	/**
	  * returns the list of Similarity of second folder
	  */
	public List<Similarity> getFolder2Sim() {
		return folder2Sim;
	}

}
