package Tests.backend;

import detector.abstraction.Node;
import detector.abstraction.Parser;
import detector.factory.JavaPlagiarismDetectorFactory;
import detector.implmentation.java.SimilarRange;
import model.Similarity;
import model.SimilarityInterval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimilarityIntervalTest {


    //getting the start line number of each of the similar nodes
    @Test
    public void getStartLineTest() {
        List<SimilarityInterval> simInt=new ArrayList<SimilarityInterval>();
        String path1="./resources/set01/Sample1";
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        List<Similarity> sim= SimilarRange.getSimilarityMetaFromNodes(nodeList);
        for(Similarity s:sim){
            simInt=s.getSimilarities();
            simInt.get(0).getStartLine();
        }


    }

    //getting the end line number of each of the similar nodes
    @Test
    public void getEndLineTest() {
        List<SimilarityInterval> simInt=new ArrayList<SimilarityInterval>();
        String path1="./resources/set02/Sample1";
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        List<Similarity> sim= SimilarRange.getSimilarityMetaFromNodes(nodeList);
        for(Similarity s:sim){
            simInt=s.getSimilarities();
            simInt.get(0).getEndLine();
        }

    }


    //setting the start line number of each of the similar nodes
    @Test
    public void setStartLineTest() {
        List<SimilarityInterval> simInt=new ArrayList<SimilarityInterval>();
        String path1="./resources/set02/Sample2";
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        List<Similarity> sim= SimilarRange.getSimilarityMetaFromNodes(nodeList);
        for(Similarity s:sim){
            simInt=s.getSimilarities();
            simInt.get(0).setStartLine(1);
        }

    }

    //setting the end line number of each of the similar nodes
    @Test
    public void setEndLineTest() {
        List<SimilarityInterval> simInt=new ArrayList<SimilarityInterval>();
        String path1="./resources/set03/Sample1";
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        List<Node> nodeList= parser.parseJavaCodeDirectoryToNodeList(path1);
        List<Similarity> sim= SimilarRange.getSimilarityMetaFromNodes(nodeList);
        for(Similarity s:sim){
            simInt=s.getSimilarities();
            simInt.get(0).setEndLine(1);
        }

    }
}
