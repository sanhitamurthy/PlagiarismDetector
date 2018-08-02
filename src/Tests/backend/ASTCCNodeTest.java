package Tests.backend;

import detector.abstraction.Node;
import detector.abstraction.Parser;
import detector.factory.JavaPlagiarismDetectorFactory;
import detector.implmentation.java.ASTCCNode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ASTCCNodeTest {

    //test suite to compare 2 nodes produced in the AST
    @Test
    public void nodeCompareTest() {
        String path1="./resources/testCases/Test1";
        int result=0;
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        Node firstNode=nodeList.get(1);
        Node secondNode=nodeList.get(1);
        assertEquals(result,secondNode.compareTo(firstNode));
    }


}



    
