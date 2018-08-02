package detector.implmentation.java;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import detector.abstraction.DirectoryReader;

public class JavaDirectoryReader extends DirectoryReader {
	
	@Override
	/**
	 * returns all the java files under a directory and sub directory.
	 */
	public Collection<File> getFilesFromDirectory(String dirPath) {
		String [] type = {"java"};
		File dir = new File(dirPath);
		if (!dir.isDirectory()) {
			throw new NullPointerException("Please pass a valid directory path");
		}		
		
		Collection<File> files = FileUtils.listFiles(dir, type, true);
		
		if (files == null || files.isEmpty()) {
			throw new NullPointerException("No java files to process. Please pass a directory with java files");
		}
		return files;
	}
}
