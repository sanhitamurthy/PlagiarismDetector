package detector.implmentation.java;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import detector.abstraction.Node;
import detector.abstraction.Parser;
import detector.abstraction.SimilarityCheckerAlgorithm;
import model.Similarity;


/**
 * SimilarityChecker
 * Compares two list of IASTNodes and finds similar nodes
 * Uses hash value and number of child nodes for comparing
 */
public class ASTCCSimilarityChecker extends SimilarityCheckerAlgorithm {

	//All nodes of represented by directory 1;
	List<Node> hashBasedSortedNodes1;
	
	//All nodes of represented by directory 2;
	List<Node> hashBasedSortedNodes2;
	
	
	HashMap<String, List<Node>> fileAndSimilarNodeMap;
	HashMap<String, List<Node>> fileAndNodeMap;

	//	String file1;
	//	String file2;

	/** lists of similar nodes in two given lists*/
	List<Node> similarNodes1 = new ArrayList<>();
	List<Node> similarNodes2 = new ArrayList<>();

	Double similarity = 0.0; // Similarity between two files 

	Parser parser;

	public ASTCCSimilarityChecker(Parser parser) {
		this.parser = parser;
	}

	/**
	 * @param dirPath1  : path of the first directory
	 * @param dirPath2: path of the second directory
	 * @return the similarity value when two files are compared
	 */
	public Double compareDirs(String dirPath1, String dirPath2) {		
		List<Node> nodesFromDir1 = parser.parseJavaCodeDirectoryToNodeList(dirPath1);
		List<Node> nodesFromDir2 = parser.parseJavaCodeDirectoryToNodeList(dirPath2);
		this.hashBasedSortedNodes1 = sortNodeList(nodesFromDir1);
		this.hashBasedSortedNodes2 = sortNodeList(nodesFromDir2);		
		return computeSimilarity(hashBasedSortedNodes1, hashBasedSortedNodes2);		
	}

	/**
	 * @param path1  : String representation of the java file which has been given as input
	 * @param path2: String representation of the java file which has been given as input
	 * @return the similarity value when two files are compared
	 */
	@Override
	public Double compareFiles(String path1, String path2) {
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		List<Node> nodesFromFile1 = parser.parseJavaCodeToNodeList(file1);
		List<Node> nodesFromFile2 = parser.parseJavaCodeToNodeList(file2);
		this.hashBasedSortedNodes1 = sortNodeList(nodesFromFile1);
		this.hashBasedSortedNodes2 = sortNodeList(nodesFromFile2);
		return computeSimilarity(hashBasedSortedNodes1, hashBasedSortedNodes2);	
	}


    /**
     * sortNodeList(List<IASTNode> nodes)
     *
     * @param nodes : the list of ASt nodes produces from converting the java file into AST
     * @return sorted list of nodes
     * Sorts the given array list of IASTNode depends on hash value in decreasing order.
     * Descendants decide the sort order in case of tie in hase codes.
     */
	private List<Node> sortNodeList(List<Node> nodes) {
		Collections.sort(nodes, new Comparator<Node>() {
			public int compare(Node node1, Node node2) {				
				if(node2.getHash() == node1.getHash()) {
					return node2.getDescendantsCnt() - node1.getDescendantsCnt();
				}
				return node2.getHash() - node1.getHash();
			}
		});
		return nodes;
	}


    /**
     * computeSimilarity()
     *
     * @param nodes1,nodes2 : the list of ASt nodes produces from converting the 2 java files into AST
     * @return Double value for the value of comparision
     * Add similar nodes into two lists for later computation
     * Two IASTNodes will be considered similar with same hash value and number of child nodes
     */
	private Double computeSimilarity(List<Node> nodes1, List<Node>nodes2) {
		int similarNodeCnt = 0;
		int i = 0, j = 0;
		while(i < nodes1.size() && j < nodes2.size()) {

			Node node1 = nodes1.get(i);
			Node node2 = nodes2.get(j);
			if(node1.compareTo(node2) == 0) {			
				similarNodeCnt++;
				similarNodes1.add(node1);
				similarNodes2.add(node2);
				i++;
				j++;
			} else if(node1.compareTo(node2) < 0) {
				j++;
			}
			else {
				i++;
			}
		}
		return (double) similarNodeCnt /  nodes1.size();
	}


    /**
     * getSimilarityMetaInfo()
     *
     *
     * @return returns the list of file content and range (similarity nodes)
     */
	public List<Similarity> getSimilarityMetaInfo() {
		return SimilarRange.getSimilarityMetaFromNodes(this.similarNodes1);
	}

	
	
	
	
}
