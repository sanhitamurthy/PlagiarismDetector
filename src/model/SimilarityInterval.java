package model;

/**
 * 
 * @author Shetty
 * Class representing the similarity interval in the file
 */
public class SimilarityInterval {

	// start of the interval
	private int startLine;

	//end of interval
	private int endLine;

	//getters function to get the start line of the similar code
	public int getStartLine() {
		return startLine;
	}
	
	//getters function to get the end line of the similar code
	public int getEndLine() {
		return endLine;
	}

	//setter function to set the start line of the similar code
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	
	//setter function to get the end line of the similar code
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	//constructor of the class
	public SimilarityInterval(int startLine, int endLine) {
		this.startLine = startLine;
		this.endLine = endLine;
	}

}
