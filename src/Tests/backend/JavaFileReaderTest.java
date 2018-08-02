package Tests.backend;

import detector.implmentation.java.JavaDirectoryReader;
import detector.implmentation.java.JavaFileReader;

import org.junit.Test;

import java.io.File;
import java.util.Collection;

public class JavaFileReaderTest {

    /**the test suites are used to check the various cases of reading the files
     * by the JavaFileReader class.
     */

    @Test
    public void readDirectory() {
        JavaFileReader jfr = new JavaFileReader();
        String dirPath = "./resources/testCases/Test1";
        JavaDirectoryReader jdr = new JavaDirectoryReader();
        Collection<File> files = jdr.getFilesFromDirectory(dirPath);
        for (File f : files) {
            String fileText = jfr.readFile(f);
        }
    }

    @Test
    public void readFile() {
        JavaFileReader jfr = new JavaFileReader();
        File newFile = new File("./resources/sum_original.java");
        String fileText = jfr.readFile(newFile);
    }

    @Test(expected = NullPointerException.class)
    public void readNullDirectory() {
        JavaFileReader jfr = new JavaFileReader();
        String dirPath = "./resources/testCases/Test3";
        JavaDirectoryReader jdr = new JavaDirectoryReader();
        Collection<File> files = jdr.getFilesFromDirectory(dirPath);
    }
    
    @Test
    public void readEmptyDirectory() {
        JavaFileReader jfr = new JavaFileReader();
        String dirPath = "./resources/empty_test/em2";
        JavaDirectoryReader jdr = new JavaDirectoryReader();
        Collection<File> files = jdr.getFilesFromDirectory(dirPath);
        for (File f : files) {
        	
          String fileText = jfr.readFile(f);
          f.setExecutable(false);
        }
    }
}


