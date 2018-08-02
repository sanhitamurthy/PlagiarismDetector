package Tests.backend;

import detector.abstraction.AFileReader;
import detector.implmentation.java.Detector;
import detector.implmentation.java.JavaDirectoryReader;
import detector.implmentation.java.JavaFileReader;

import org.junit.Test;

import java.io.File;
import java.util.Collection;

import static org.junit.Assert.*;

public class JavaDirectoryReaderTest {

	//test suite to check the functionality of the directory reader class.
	//test suite to check the functionality of the directory reader class.
	@Test
	public void readDirectory() {
		String dirPath="./resources/testCases/Test";
		JavaDirectoryReader jdr= new JavaDirectoryReader();
        Collection<File> files= jdr.getFilesFromDirectory(dirPath);
	}
	
	@Test(expected = NullPointerException.class)
	public void readNotDirectory() {
		String dirPath="./resources/testCases/ASTTest.java";
		JavaDirectoryReader jdr= new JavaDirectoryReader();
        Collection<File> files= jdr.getFilesFromDirectory(dirPath);

	}


}