package model;

/**
 * File class.
 * 
 * @author Seoungdeok Jeon
 */
public class File implements Data {
	
	String myName;
	String myDateCreated;
	String myType;
	
	public File(String fileName) {
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
