package model;

import java.util.List;

/**
 * Folder class.
 * 
 * @author Seoungdeok Jeon
 */
public class Folder implements Data {
	
	String myName;
	String myDateCreated;
	String myType;
	List<Data> myDataList;	// data can be file or folder
	
	public Folder(String folderName) {
		this.myName = folderName;
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
	
	public List<Data> getData() {
		return myDataList;
	}
	
	public String toString() {
		return myName;
		
	}
}
