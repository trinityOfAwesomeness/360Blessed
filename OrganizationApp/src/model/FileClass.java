package model;

import java.io.File;

/**
 * File class.
 * 
 * @author Seoungdeok Jeon
 */
public class FileClass implements Data {

	File myFile;
	String myName;

	public FileClass(File theFile) {
		myFile = theFile;
		myName = theFile.getName();
	}

	public File getFile() {
		return myFile;
	}

	public String getName() {
		return myName;
	}
	
	public void setName(String theFileName) {
		myName = theFileName;
	}

	public String toString() {
		return myName;

	}
}
