package detector.factory;

import detector.abstraction.DirectoryReader;
import detector.implmentation.java.JavaDirectoryReader;
import detector.implmentation.java.JavaFileReader;
import detector.implmentation.java.JavaParser;


/**
 * The Class JavaPlagiarismDetectorFactory is the factory method implementation
 * to which will create instances for the
 * methods  required to begin checking for plagiarism.
 */
public class JavaPlagiarismDetectorFactory{

	private JavaPlagiarismDetectorFactory() {

	}

    /**
     * creates an instance for the class
     */
	static JavaPlagiarismDetectorFactory factory = new JavaPlagiarismDetectorFactory();

    /**
     * getInstance
     *
     * @return the instance of the JavaPlagiarismDetectorFactory class
     */
	public static JavaPlagiarismDetectorFactory getInstance() {
		return factory;
	}


    /**
     * getJavaFileReader
     *
     * @return the instance of the JavaFileReader class
     */
	public JavaFileReader getJavaFileReader() {
		JavaFileReader jfr = new JavaFileReader();
		return jfr;
	}

    /**
     * getJavaParser
     *
     * @return the instance of the JavaParser class
     */
	public JavaParser getJavaParser() {
		JavaParser jp = new JavaParser(getJavaFileReader(), getJavaDirectoryReader());
		return jp;
	}

    /**
     * getJavaDirectoryReader
     *
     * @return the instance of the JavaDirectoryReader class
     */
	public JavaDirectoryReader getJavaDirectoryReader() {
		JavaDirectoryReader javaDirReader = new JavaDirectoryReader();
		return javaDirReader;
	}	
}
