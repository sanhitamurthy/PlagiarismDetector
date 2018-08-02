package detector.abstraction;

import java.io.File;
import java.util.List;

/**
 * Defines the outline of a parser class
 * 
 */
public abstract class Parser {
	/**
	 * parseJavaCodeDirectoryToNodeList(String dirPath)
	 *
	 * @param dirPath String representation path of the directory
	 * @return an array list of Node
	 * converts java code string to a list of IASTNode
	 */
	public abstract List<Node> parseJavaCodeDirectoryToNodeList(String dirPath);

	/**
	 * parseJavaCodeDirectoryToNodeList(String file1)
	 *
	 * @param file String representation of the file that has been given as input
	 * @return an array list of Node
	 * converts java code string to a list of IASTNode
	 */
	public abstract List<Node> parseJavaCodeToNodeList(File file);

}
