package detector.abstraction;

import java.io.File;
import java.util.Collection;

/**
 * Directory Reader which is responsible for
 * reading the directory given as input by the user to
 * the application
 */
public abstract class DirectoryReader {
    /**
     * @param dirPath the source directory for the files
     * @return list of all the files given in the directory.
     */
    public abstract Collection<File> getFilesFromDirectory(String dirPath);
}
