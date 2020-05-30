package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Folder class.
 * 
 * @author Seoungdeok Jeon
 */
public class Folder implements Data {
	
	private String myName;
	private String myDateCreated;
	private String myType;
	private List<Data> myDataList;	// folder can contain file or another folder
	
	public Folder(String folderName) {
		this.myName = folderName;
		myDataList = new LinkedList<Data>();
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
	
	public List<Data> getDataList() {
		return myDataList;
	}
	
	public void addFolder(Folder theFolder) {
		myDataList.add(theFolder);
	}
	
	public void removeFolder(Folder theFolder) {
		for(int i = 0; i < myDataList.size(); ++i) {
			if (theFolder.getName() == myDataList.get(i).getName()) {
				myDataList.remove(myDataList.get(i));
			}
		}
	}
	
	public void addFile(FileClass theFile) {
		myDataList.add(theFile);
	}
	
	public void removeFile(FileClass theFile) {
		myDataList.remove(theFile);
	}
	

	
	public String toString() {
		return myName;
	}
}