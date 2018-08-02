package detector.implmentation.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.NumberLiteral;

import detector.abstraction.AFileReader;
import detector.abstraction.DirectoryReader;
import detector.abstraction.Node;
import detector.abstraction.Parser;

/**
 * JavaParser
 * 1. converts java code string to AST
 * 2. traverses all nodes in the AST with visitor pattern
 * 3. saves ASTNode and some other information into IASTNode and stored in a hashmap
 */
public class JavaParser extends Parser {
	
	private AFileReader fileReader;
	private DirectoryReader dirReader;

	/**
	 * creates an instance of the JavaParser
	 */
	public JavaParser(AFileReader fileReader, DirectoryReader dirReader) {
		this.fileReader = fileReader;
		this.dirReader = dirReader;
	}
	
	/**
	 * 
	 * @param dirName name for which we needs to represented by ast nodes.
	 * @return the list of nodes representing all the java files in the directory.
	 */
	public List<Node> parseJavaCodeDirectoryToNodeList(String dirName) {
		Collection<File> filesToParse = this.dirReader.getFilesFromDirectory(dirName);	
		List<Node> nodes = getNodeListFromFileCollection(filesToParse);
		return nodes;
	}
	
	/**
	 * parseJavaCodeToNodeList(String file)
	 * @param file the file to convert to AST
	 * @return an array list of IASTNode
	 * converts java code string to a list of IASTNode
	 */
	public List<Node> parseJavaCodeToNodeList(File file) {
		String fileString = fileReader.readFile(file);		
		CompilationUnit cu = parseJavaFile(fileString);
		List<ASTNode> nodes = transformCompilationUnitToList(cu);
		HashMap<ASTNode, ASTCCNode> map = processASTNodeList(nodes, file.getAbsolutePath());
		return new ArrayList<>(map.values());
	}

	/**
	 *
	 * @param file
	 * @return Compilation unit
	 * for testing purposes only
	 */
	public CompilationUnit getCompilationUnit(String file){
		return parseJavaFile(file);
	}


	/**
	 * parseJavaFile(String file)
	 *
	 * @param file : the String representation of the java file which is given as input to be parsed
	 * @return A compilationUnit parsed from given file
	 * Converts a java code string into a compilationUnit which is the root of AST
	 */
	private CompilationUnit parseJavaFile(String file) {
		ASTParser parser = ASTParser.newParser(AST.JLS8);
	    parser.setKind(ASTParser.K_COMPILATION_UNIT);

	    Map<String, String> compilerOptions = JavaCore.getOptions();
	    compilerOptions.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_8); 
	    compilerOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_8);
	    compilerOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8);
	    parser.setCompilerOptions(compilerOptions);
	    
	    char[] src = file.toCharArray();
	    parser.setSource(src);
	    
	    return (CompilationUnit) parser.createAST(null);
	}


	/**
	 * transformCompilationUnitToList(CompilationUnit root)
	 *
	 * @param root : the root of the AST which will be sent to the visitor class
	 * @return all ASTNodes in this AST
	 */
	private List<ASTNode> transformCompilationUnitToList(CompilationUnit root) {
		IASTVisitor visitor = new IASTVisitor();
		root.accept(visitor);
		return visitor.nodes;
	}


	/**
	 * processASTNodeList(List<ASTNode> list)
	 *
	 * @param list the list of the ASTNode of the java file which has been parsed
	 * @return HashMap<ASTNode, IASTNode> which is map
	 * Produces a hash map from given ASTNode list which contains the node and the descendants of the node
	 * along with the hash value of the descendants
	 */
	private HashMap<ASTNode, ASTCCNode> processASTNodeList(List<ASTNode> list, String fileName) {
		HashMap<ASTNode, ASTCCNode> map = new HashMap<>();
		for(ASTNode node : list) {
			processASTNode(node, map, fileName);
		}
		return map;
	}


	/**
	 * processASTNode(ASTNode node, HashMap<ASTNode, IASTNode> map)
	 *
	 * @param node which is each node in the AST, a map which will be used to store the
	 *             information regarding each node and its descendants
	 *             Puts given node into map and update information of its parents
	 */
	private void processASTNode(ASTNode node, HashMap<ASTNode, ASTCCNode> map, String fileName) {

		ASTCCNode tempNode = new ASTCCNode();
		tempNode.setHash(AstNodeHashCodeMap.getHashCode(node));
		tempNode.setDescendantsCnt(0);
		tempNode.setStartPosition(node.getStartPosition());
		tempNode.setEndPosition(node.getStartPosition() + node.toString().length() - 1);
		tempNode.setFileName(fileName);
		
		map.put(node, tempNode);
		
		ASTNode temp = node;
		
		while (temp.getParent() != null) {
			temp = temp.getParent();
			if(!map.containsKey(temp)) {
				continue;
			}
			ASTCCNode myNode = map.get(temp);
			myNode.setDescendantsCnt(myNode.getDescendantsCnt() + 1);
			myNode.setHash(myNode.getHash() + tempNode.getHash());
			map.put(temp, myNode);
		}
	}

	/**
	 * getNodeListFromFileCollection(Collection<File> filesToParse)
	 *
	 * @param filesToParse : File collection of all java files intended to be converted into nodes.
	 * @return A list of nodes which are the nodes got after converting the files to AST
	 */
	private List<Node> getNodeListFromFileCollection (Collection<File> filesToParse) {
		List<Node> nodes = new ArrayList<Node>();
				
		for (File file : filesToParse) {			
			 List<Node> fileTextNodes = parseJavaCodeToNodeList(file);
			 nodes.addAll(fileTextNodes);
		}
		return nodes;
	}	
	
}
