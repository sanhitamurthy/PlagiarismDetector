package detector.abstraction;

/**
 * 
 * A outline for the class implementing the algorithm
 * to return the similarity score. 
 */

public abstract class SimilarityCheckerAlgorithm {

	/**
	 * 
	 * @param path1 file1 path to compare
	 * @param path2 file2 path to compare
	 * @return A similarity score deduced from the algorithm
	 */
	public abstract Double compareFiles(String path1, String path2);

	/**
	 * @param path1 file1 path to compare
	 * @param path2 file2 path to compare
	 * @return A similarity score deduced from the algorithm for two java files
	 * which are present the directories whose path is given
	 */
	public abstract Double compareDirs(String path1, String path2);

}
