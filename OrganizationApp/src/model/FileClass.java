package model;

/**
 * File class.
 * 
 * @author Seoungdeok Jeon
 */
public class FileClass implements Data {
	
	String myName;
	String myDateCreated;
	String myType;
	
	public FileClass(String fileName) {
		this.myName = fileName;
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
	
	public void setName(String folderName) {
		this.myName = folderName;
	}
	
	public String toString() {
		return myName;
		
	}
}
