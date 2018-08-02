package detector.abstraction;

import java.util.Comparator;

//This abstract class has the various methods which can be used to perform the neccessary operations
//on the nodes got from the AST
public abstract class Node implements Comparable<Node> {

	/**
	 * @return the hash value of a node
	 */
	public abstract Integer getHash();
	
	/**
	 * 
	 * @param hash set the hash value for the node.
	 */
	public abstract void setHash(Integer hash);
	
	/**
	 * 
	 * @return the number of descendants of the node
	 */
	public abstract Integer getDescendantsCnt();
	
	/**
	 * 
	 * @param childrenCnt number of children of the node
	 */
	public abstract void setDescendantsCnt(Integer childrenCnt);

	/**
	 * @return the starting position of the copied lines range
	 */
	public abstract int getStartPosition();

	/**
	 * @param startPosition represented by the node wrt to corresponding source file.
	 */
	public abstract void setStartPosition(int startPosition);

	/**
	 * @return endposition represented by the node wrt to corresponding source file.
	 */
	public abstract int getEndPosition();

	/**
	 * @param endPosition : sets the end position for the comparision of the 2 java files
	 */
	public abstract void setEndPosition(int endPosition);
	
	/**
	 * 
	 * @param fileName: String representation of the file passed as input
	 */
	public abstract void setFileName(String fileName);	
	
	/**
	 * 
	 * @return the file to which the node belongs
	 */
	public abstract String getFileName() ;
}
