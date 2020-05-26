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
	String myDateCreated;
	String myType;
	
	public FileClass(File theFile) {
		myFile = theFile;
		myName = theFile.getName();
	    myType = myName.substring(myName.lastIndexOf("."));
	}

	public File getFile() {
		return myFile;
	}
	
	public String getName() {
		return myName;
	}

	public String getDateCreated() {
		return myDateCreated;
	}
	
	public String getType() {
		return myType;
	}
	
	public void setName(String theFileName) {
		myName = theFileName;
	}
	
	public String toString() {
		return myName;
		
	}
}
