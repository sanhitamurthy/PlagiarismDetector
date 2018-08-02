package detector.implmentation.java;
import detector.abstraction.Node;


/**
 * ASTCCNode
 * contains hash value, number of child nodes, start and end line number of an ASTNode
 * This node serves as the building block for the AST Code Comparison (AST-CC) Algorithm.
 */
public class ASTCCNode extends Node {

	private Integer hash; // hash value of this node
	private Integer childrenCnt; // count of child nodes of this node
	private int startPosition; // start position of this node in java file
	private int endPosition; // end position of this node in java file
	private String fileName; // file name which is being represented as node

	/**
	 * Gets the hash.
	 *
	 * @return the hash value of the node
	 */
	public Integer getHash() {
		return hash;
	}

	/**
	 * @param hash set the hash value for the node.
	 */
	public void setHash(Integer hash) {
		this.hash = hash;
	}

	/** The count of children nodes of this node. */
	public Integer getDescendantsCnt() {
		return childrenCnt;
	}

	/** The start position of the noe in the java file. */
	public void setDescendantsCnt(Integer childrenCnt) {
		this.childrenCnt = childrenCnt;
	}

	/** The end position of the node in the java file. */
	public int getStartPosition() {
		return startPosition;
	}

	/**
	 * 
	 * @return startposition represented by the node wrt to corresponding source file.
	 */
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	/**
	 * 
	 * @return endposition represented by the node wrt to corresponding source file.
	 */
	public int getEndPosition() {
		return endPosition;
	}

	/**
	 * 
	 * @param endPosition 
	 * set the endposition represented by the node wrt to corresponding source file.
	 */
	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}
	
	/**
	 * 
	 * @param fileName : sets the file name of the input file
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


    /**
     *
     * @return fileName : gets the file name of the input file
     */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * @param node used for comparing the hash codes of two nodes in the AST
	 */
	@Override
	public int compareTo(Node node) {
		if(this.getHash() == node.getHash()) {
			return this.getDescendantsCnt() - node.getDescendantsCnt();
		}
		return this.getHash() - node.getHash();
	}
	
}
