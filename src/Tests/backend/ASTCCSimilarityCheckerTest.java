package Tests.backend;


import detector.abstraction.Node;
import detector.abstraction.Parser;
import detector.factory.JavaPlagiarismDetectorFactory;

import org.junit.Test;

import detector.implmentation.java.*;
import model.Similarity;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ASTCCSimilarityCheckerTest {

    //test suite to check the similarity of AST
    @Test
    public void compareFilesViaPath(){
        String path1="./resources/set07/Sample1";
        String path2="./resources/set07/Sample2";
        Double res1=0.91;
        Parser parser = JavaPlagiarismDetectorFactory.getInstance().getJavaParser();
        ASTCCSimilarityChecker checker = new ASTCCSimilarityChecker(parser);
        Double result = Math.floor(checker.compareDirs(path1, path2) * 100) / 100;
        assertEquals(res1, result);
        List<Similarity> check = checker.getSimilarityMetaInfo();
        System.out.print("S");
        
    }

}
