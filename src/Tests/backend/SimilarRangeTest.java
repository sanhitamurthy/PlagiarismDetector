package Tests.backend;

import detector.abstraction.Node;
import detector.abstraction.Parser;
import detector.factory.JavaPlagiarismDetectorFactory;

import detector.implmentation.java.SimilarRange;
import model.Similarity;
import org.junit.Test;

import java.util.List;

public class SimilarRangeTest {

    //getting the fileContents of the similar nodes
    @Test
    public void getFileContentTest() {
        String path1="./resources/testCases/Test";
        Double res1=1.0;
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        List<Similarity> sim= SimilarRange.getSimilarityMetaFromNodes(nodeList);
        for(Similarity s:sim){
            s.getFileContent();
        }

    }

    //getting the fileName of the similar nodes
    @Test
    public void getFileNameTest() {
        SimilarRange sr=new SimilarRange();
        String path1="./resources/set01/Sample1";
        Double res1=1.0;
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        List<Similarity> sim= SimilarRange.getSimilarityMetaFromNodes(nodeList);
        for(Similarity s:sim){
            s.getFilename();
        }

    }
}
