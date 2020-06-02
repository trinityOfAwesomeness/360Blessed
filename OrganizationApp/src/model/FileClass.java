//File class for our TCSS360 project
package model;

import java.io.File;

/**
 * File class.
 * 
 * @author Seoungdeok Jeon
 */
public class FileClass implements Data {
	
	/** The file. */
	private File myFile;
	/** The name of the file. */
	private String myName;
	
	/**
	 * Constructor for FileClass
	 * @param theFile The File being constructed
	 * @author Seoungdeok Jeon
	 */
	public FileClass(File theFile) {
		myFile = theFile;
		myName = theFile.getName();
	}
	
	/** 
	 * Returns the file.
	 * @return myFile The File
	 * @author Seoungdeok Jeon
	 */
	public File getFile() {
		return myFile;
	}
	
	/**
	 * Returns the name of the file.
	 * @return myName The file name
	 * @author Seoungdeok Jeon
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * Sets the file name.
	 * @param theFileName The name of the file
	 */
	public void setName(String theFileName) {
		myName = theFileName;
	}
	
	@Override
	public String toString() {
		return myName;

	}
}
