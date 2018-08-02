package Tests;

import static org.junit.Assert.*;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javafx.stage.Stage;

import org.junit.Test;

import com.sun.javafx.tk.TKClipboard;

import detector.implmentation.java.Detector;

import application.App;

public class ASTTest {
	boolean res=true;

	//testing the start of an application
//    @Test
//    public void testA() throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//        	
//            @Override
//            public void run() {
//                new JFXPanel(); // Initializes the JavaFx Platform
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        new App().start(new Stage()); // Create and
//                                                        // initialize
//                                                        // your app.
//
//                    }
//                });
//            }
//        });
//        try{
//        thread.start();// Initialize the thread
//        Thread.sleep(10000); // Time to use the app, with out this, the thread
//                                // will be killed before you can tell.
//        }
//        catch(Exception e){
//        	res=false;
//        }
//      	assertEquals(true,res);
//    }
//    
//    
//    //testing if the compare files in UI works
//    @Test
//    public void testB() throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//        	
//            @Override
//            public void run() {
//                new JFXPanel(); // Initializes the JavaFx Platform
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                    	App a= new App();
//                       a.setFile1Path("./src/Tests/sum_original.java");
//                       a.setFile2Path("./src/Tests/sum_copied.java");
//                       a.compareFiles();
//                    }
//                });
//            }
//        });
//        try{
//        thread.start();// Initialize the thread
//        Thread.sleep(10000); // Time to use the app, with out this, the thread
//                                // will be killed before you can tell.
//        }
//        catch(Exception e){
//        	res=false;
//        }
//      	assertEquals(true,res);
//    }
//    
//    //testing of the detailed result in UI
//    @Test
//    public void testC() throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//        	
//            @Override
//            public void run() {
//                new JFXPanel(); // Initializes the JavaFx Platform
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                    	App a= new App();
//                    	a.setFile1Path("./src/Tests/sum_original.java");
//                        a.setFile2Path("./src/Tests/sum_copied.java");
//                       a.compareFiles();
//                       a.viewDetailedResult();
//                    }
//                });
//            }
//        });
//        try{
//        thread.start();// Initialize the thread
//        Thread.sleep(10000); // Time to use the app, with out this, the thread
//                                // will be killed before you can tell.
//        }
//        catch(Exception e){
//        	res=false;
//        }
//      	assertEquals(true,res);
//    }
//    
//    //testing returning to main function in UI
//    @Test
//    public void testD() throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//        	
//            @Override
//            public void run() {
//                new JFXPanel(); // Initializes the JavaFx Platform
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                    	App a= new App();
//                    	a.setFile1Path("./src/Tests/sum_original.java");
//                        a.setFile2Path("./src/Tests/sum_copied.java");
//                       a.compareFiles();
//                       a.returnToMainPage();
//                      
//                    }
//                });
//            }
//        });
//        try{
//        thread.start();// Initialize the thread
//        Thread.sleep(10000); // Time to use the app, with out this, the thread
//                                // will be killed before you can tell.
//        }
//        catch(Exception e){
//        	res=false;
//        }
//      	assertEquals(true,res);
//    }
//    
//  //testing clear function in UI
//    @Test
//    public void testE() throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//        	
//            @Override
//            public void run() {
//                new JFXPanel(); // Initializes the JavaFx Platform
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                    	App a= new App();
//                       a.setFile1Path("./src/Tests/sum_original.java");
//                       a.setFile2Path("./src/Tests/sum_copied.java");
//                       a.compareFiles();
//                       a.clear();
//                      
//                    }
//                });
//            }
//        });
//        try{
//        thread.start();// Initialize the thread
//        Thread.sleep(10000); // Time to use the app, with out this, the thread
//                                // will be killed before you can tell.
//        }
//        catch(Exception e){
//        	res=false;
//        }
//      	assertEquals(true,res);
//    }
//    
//    //testing setFile functionality in UI
//    @Test
//    public void testF() throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//        	
//            @Override
//            public void run() {
//                new JFXPanel(); // Initializes the JavaFx Platform
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                    	App a= new App();
//                        a.setFile1Name("TestFile1");
//                        a.setFile2Name("TestFile2");
//                        a.setFile1("./src/Tests/sum_original.java");
//                        a.setFile2("./src/Tests/sum_similar.java");
//                    }
//                });
//            }
//        });
//        try{
//        thread.start();// Initialize the thread
//        Thread.sleep(10000); // Time to use the app, with out this, the thread
//                                // will be killed before you can tell.
//        }
//        catch(Exception e){
//        	res=false;
//        }
//      	assertEquals(true,res);
//    }
//    
//    
//    //testing 2 almost similar files
//    @Test
//	public void test() {
//		Double res = 0.7391304347826086;
//		Detector detect = new Detector();
//		detect.compare("./src/Tests/sum_original.java",
//				"./src/Tests/sum_copied.java");
//		assertEquals(res, detect.getResult());
//
//	}
//
//    //testing 2 not similar files
//	@Test
//	public void test1() {
//
//		Double res1 = 0.6086956521739131;
//		Detector detect = new Detector();
//		detect.compare("./src/Tests/sum_original.java",
//				"./src/Tests/sum_similar.java");
//		System.out.println(detect.getResult());
//		assertEquals(res1, detect.getResult());
//
//	}
//	

	// Further investigation required
	//testing fails
	@Test
	public void test2() {

		Double res1 = 0.2545454545454545;
		Detector detect = new Detector();
		detect.compare("./testCases/Test",
				"./testCases/Test1");
		assertEquals(res1, detect.getResult());

	}
	
	
	//exception handling test
//	@Test
//	public void test4() {
//
//		Double res3=1.0;
//		Detector detect = new Detector();
//		detect.compare("C:/Users/sanhita/Downloads/resources-master/resources-master/PlagiarismChecker-Data/set02/Sample/LinkedList.java",
//						"C:/Users/sanhita/Downloads/resources-master/resources-master/PlagiarismChecker-Data/set02/Sample3/LinkedList.java");
//		assertEquals(res3, detect.getResult());
//
//	}
	
}