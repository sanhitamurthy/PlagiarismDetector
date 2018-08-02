package detector.implmentation.java;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import detector.abstraction.AFileReader;
import detector.abstraction.Node;
import detector.factory.JavaPlagiarismDetectorFactory;
import model.Similarity;
import model.SimilarityInterval;

/**
 * The Class SimilarRange 
 */
public class SimilarRange {

	/**
	 * Find similar range.
	 *
	 * @param nodes of the AST
	 * @return the interval of range of lines which has been copied
	 */	
	private static List<SimilarityInterval> findSimilarRange(List<Node> nodes, String fileContent) {
		List<SimilarityInterval> intervals = new ArrayList<>();
		for(Node node : nodes) {
			intervals.add(new SimilarityInterval(node.getStartPosition(), node.getEndPosition()));
		}		
		List<SimilarityInterval> intermediatePos = mergeIntervals(intervals);
		
		List<SimilarityInterval> res = new ArrayList<>();
		
		for(SimilarityInterval range : intermediatePos) {			
			res.add(new SimilarityInterval(findLine(fileContent, range.getStartLine()), findLine(fileContent, range.getEndLine())));
		}
		return res;
	}
	

	/**
	 * 
	 * @param SimilarNodes : all the similaar nodes from the given submissions
	 * @return The similarities meta data for the similar nodes passed to the function.
	 */
	public static List<Similarity> getSimilarityMetaFromNodes(List<Node> SimilarNodes) {
		HashMap<String, List<Node>> fileSimilarNodesMap = segregateNodesBasedOnFile(SimilarNodes);		
		List<Similarity> similarites = getSimilaritiesForMap (fileSimilarNodesMap);
		return similarites;
	}

	/**
	 *
	 * @param fileSimilarNodesMap : hashmap of file name and nodes of this file
	 * @return A list of similarity (a list of file with name, content and similar range)
	 */
	private static List<Similarity> getSimilaritiesForMap (HashMap<String, List<Node>> fileSimilarNodesMap) {		
		List<Similarity> similarites = new ArrayList<Similarity>();
		for (String fileName : fileSimilarNodesMap.keySet()) {
		    List<Node> similarNodes = fileSimilarNodesMap.get(fileName);
			Similarity sim = createSimilarity(fileName, similarNodes);
			similarites.add(sim);
		}		
		return similarites;
	}
	
	/**
	 * Converts the list to map based on file name 
	 * @param SimilarNodes List of nodes
	 * @return file name to nodes map
	 */
	private static HashMap<String, List<Node>> segregateNodesBasedOnFile (List<Node> SimilarNodes) {
		HashMap<String, List<Node>> fileSimilarNodesMap = new HashMap<String, List<Node>>();
		
		for (Iterator<Node> iterator = SimilarNodes.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			addToHashMap(node.getFileName(), node, fileSimilarNodesMap);			
		}
		return fileSimilarNodesMap;
	}

    /**
     *
     * @param key file name
     * @param value a node in this file
     * @param map a hashmap from file name to nodes in this file
     * @return adds the given information to the hassh Map
     */
	private static void addToHashMap (String key, Node value, HashMap<String, List<Node>> map) {
		List<Node> nodes = map.get(key);
		if (nodes == null) {
			nodes = new ArrayList<Node>();
			nodes.add(value);
			map.put(key, nodes);
		} else {
			nodes.add(value);
		}
	}

    /**
     *
     * @param :the string representation of the file name and a list of nodes which are similar
     * @return the similarity between the nodes
     */
	private static Similarity createSimilarity(String fileName, List<Node> similarNodes) {
		AFileReader fr = JavaPlagiarismDetectorFactory.getInstance().getJavaFileReader();
		File f = new File(fileName);
		String fileContent =  fr.readFile(f);
		List<SimilarityInterval> simIntervals = findSimilarRange(similarNodes, fileContent);		
		Similarity sim = new Similarity(fileName,fileContent, simIntervals);
		return sim;
	}
	
	/**
	 * Merge intervals.
	 *
	 * @param intervals is the list of intervals of the nodes
	 * @return a single list of intervals which is the maximum range of the copied lines
	 */
	private static List<SimilarityInterval> mergeIntervals(List<SimilarityInterval> intervals) {		
        
        Collections.sort(intervals, new Comparator<SimilarityInterval>(){
            public int compare(SimilarityInterval a, SimilarityInterval b) {
                return a.getStartLine() - b.getStartLine();
            }
        });
        List<SimilarityInterval> res = new ArrayList<SimilarityInterval>();
        int start = intervals.get(0).getStartLine();
        int end = intervals.get(0).getEndLine();
        
        for(SimilarityInterval i : intervals) {
               if (i.getStartLine() > end) {
            	   	res.add(new SimilarityInterval(start, end));
            	   	start = i.getStartLine();
            	   	end = i.getEndLine();
               } else {
            	   	end = Math.max(i.getEndLine(), end);
               }
        }
        res.add(new SimilarityInterval(start, end));
        return res;
	}
	
	/**
	 * findLine(String file, int pos)
	 * @param file
	 * @param pos 
	 * 		the character index of an Node
	 * @return Line number of given character index
	 */
	private static  int findLine(String file, int pos) {
		String[] split = file.split("\n");
		int i = 0, index = 0;
		while(i < pos && index < split.length) {
			i += split[index].length();
			index++;
		}
		return index == 0 ? 1 : index;
	}	
}
