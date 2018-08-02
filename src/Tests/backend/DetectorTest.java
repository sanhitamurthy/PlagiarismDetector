package Tests.backend;

import detector.implmentation.java.Detector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DetectorTest {


    /**
     * This test suite checks for the various plagiarism results for
     * the sample test cases given by the TA as reference. It
     * compares the java files present in the various sets present in 'resources' directory
     * and the test case names are respectively names the same.
     */
	@Test
	public void compareAlmostSimilar() {
		Double res1 =0.97;
		Detector detect = new Detector();
		detect.compareDirs("./resources/testCases/Test",
				"./resources/testCases/Test1");
		Double result=Math.floor(detect.getResult() * 100) / 100;
        assertEquals(res1,result);

	}
	

	@Test
	public void comparExactFiles() {
		Double res1 =1.0;
		Detector detect = new Detector();
		detect.compareDirs("./resources/testCases/Test",
				"./resources/testCases/Test");
		Double result=Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);

	}
	
	@Test
	public void compareSet02() {
		Double res1 =0.99;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set02/Sample1",
				"./resources/set02/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);

	}
	
	@Test
	public void compareSet01() {
		Double res1 =1.0;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set01/Sample1",
				"./resources/set01/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);

	}
	
	@Test
	public void compareSet03() {
		Double res1 =0.76;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set03/Sample1",
				"./resources/set03/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet04() {
		Double res1 =0.95;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set04/Sample1",
				"./resources/set04/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet05() {
		Double res1 =0.73;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set05/Sample1",
				"./resources/set05/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet06() {
		Double res1 =1.0;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set06/Sample1",
				"./resources/set06/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet07() {
		Double res1 =0.91;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set07/Sample1",
				"./resources/set07/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	


	@Test
	public void compareSet11() {
		Double res1 =0.88;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set11/Sample1",
				"./resources/set11/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet16() {
		Double res1 =0.96;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set16/Sample1",
				"./resources/set16/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet17() {
		Double res1 =1.0;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set17/Sample1",
				"./resources/set17/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet18() {
		Double res1 =0.96;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set18/Sample1",
				"./resources/set18/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}

    @Test
    public void compareSet08() {
        Double res=0.99;
        Detector detect = new Detector();
        detect.compareDirs("./resources/set08/Sample1",
                "./resources/set08/Sample2");
        Double result= Math.floor(detect.getResult() * 100) / 100;
        assertEquals(res,result);

    }
	
	@Test
	public void compareSet19() {
		Double res1 =0.97;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set19/Sample1",
				"./resources/set19/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}
	
	@Test
	public void compareSet20() {
		Double res1 =0.81;
		Detector detect = new Detector();
		detect.compareDirs("./resources/set20/Sample1",
				"./resources/set20/Sample2");
		Double result= Math.floor(detect.getResult() * 100) / 100;
		assertEquals(res1,result);
	}

    @Test(expected = NullPointerException.class)
    public void compareSet12() {
        Detector detect = new Detector();
        detect.compareDirs("./resources/set12/Sample1",
                "./resources/set12/Sample2");

    }

    @Test(expected = NullPointerException.class)
    public void compareEmptyFolder() {
        Detector detect = new Detector();
        detect.compareDirs("./resources/NewFolder/Sample1",
                "./resources/NewFolder/Sample2");

    }

    @Test(expected = NullPointerException.class)
    public void compareNonJava() {
        Detector detect = new Detector();
        detect.compareDirs("./resources/Python/Sample1",
                "./resources/Python/Sample2");

    }

    @Test(expected = NullPointerException.class)
    public void oneEmptyFolder() {
        Detector detect = new Detector();
        detect.compareDirs("./resources/OneEmpty/Sample1",
                "./resources/OneEmpty/Sample2");

    }


}