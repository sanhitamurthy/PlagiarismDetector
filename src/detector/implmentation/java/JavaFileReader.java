package detector.implmentation.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import detector.abstraction.AFileReader;


/**
 * IFileReader
 * Reads file from given path
 */

public class JavaFileReader extends AFileReader {
	
	/**
	 * readFileByPath(String path)
	 * @param file
	 * @return context of file in String
	 */
	public String readFile(File file) {
		
		try {
			return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		} catch (IOException e) {
			e.printStackTrace();
			throw new NullPointerException();
		}
	}

	
}
