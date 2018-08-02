package model;

import java.util.List;

/**
 * 
 * Class representing the similarities within a file.
 */
public class Similarity {


	String filename;
	String fileContent;
	List<SimilarityInterval> similarities;
	

	//function to return the name of the file
	public String getFilename() {
		return filename;
	}

	//function to return the content in the file
	public String getFileContent() {
		return fileContent;
	}

	//function to return the lis of similarities in the file
	public List<SimilarityInterval> getSimilarities() {
		return similarities;
	}

	//setter function to set the name of the file
	public void setFilename(String filename) {
		this.filename = filename;
	}

	//setter function to set the content of the file
	public void setFilecontent(String fileContent) {
		this.fileContent = fileContent;
	}

	//setter function to set the similarities found in the file
	public void setSimilarities(List<SimilarityInterval> similarities) {
		this.similarities = similarities;
	}

	//constructor for similarity
	public Similarity(String fileName, String fileContent, List<SimilarityInterval> similarities) {
		this.filename = fileName;
		this.fileContent =  fileContent;
		this.similarities = similarities;
	}

}
