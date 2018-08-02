package detector.abstraction;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The Class AFileReader which is responsible for reading the
 * java file which has been uploaded(present in the directory)
 */
public abstract class AFileReader {

	/**
	 * Read file.
	 *
	 * @param file the java source file
	 * @return the string
	 */
	public abstract String readFile(File file);
	

}
