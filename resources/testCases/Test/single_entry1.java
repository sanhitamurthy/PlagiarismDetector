package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import detector.implmentation.java.ASTCCSimilarityChecker;
import detector.implmentation.java.Detector;


//AST_backend test
public class single_entry1 {

	@Test
	public void test() {
		Double res = 0.7391304347826086;
		Detector detect = new Detector();
		detect.compare("D:/MSD_P/detector_new/src/tests/sum_original.java",
				"D:/MSD_P/detector_new/src/tests/sum_copied.java");
		System.out.println(detect.getResult());
		if(i==10)
            ;  //do nothing for i=10
        else 
            i--;
		//assertEquals(res, detect.getResult());

	}
}
