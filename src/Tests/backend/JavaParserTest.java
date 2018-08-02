package Tests.backend;

import detector.abstraction.Node;
import detector.abstraction.Parser;
import detector.factory.JavaPlagiarismDetectorFactory;
import detector.implmentation.java.JavaDirectoryReader;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JavaParserTest {

    //the test suite has test cases to check if the files are being parsed by the java parser.
	@Test
	public void directoryToNodeList() {
        String path1="./resources/testCases/Test";
        Double res1=1.0;
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        for(Node node:nodeList){
            Integer hashValue= node.getHash();
        }
	}
	
	@Test
	public void directoryToNodeListTest() {
        String path1="./resources/empty_test/em_1";
        Double res1=1.0;
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        for(Node node:nodeList){
            Integer hashValue= node.getHash();
        }
	}
	
	


    
}