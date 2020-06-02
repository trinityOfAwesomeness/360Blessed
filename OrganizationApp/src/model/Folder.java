//Folder class for our TCSS360 class
package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Folder class.
 * 
 * @author Seoungdeok Jeon
 */
public class Folder implements Data {
	/** The name of the folder. */
	private String myName;
	/** Data list containing *either a folder or a file. */
	private List<Data> myDataList;
	
	/**
	 * Constructor for Folder.
	 * @param folderName The folder name being set.
	 * @author Seoungdeok Jeon
	 */
	public Folder(String folderName) {
		this.myName = folderName;
		myDataList = new LinkedList<Data>();
	}
	
	/**
	 * Gets the name of the folder.
	 * @author Seoungdeok Jeon
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * Sets the name of the folder.
	 * @param folderName The name to be set
	 * @author Seoungdeok Jeon
	 */
	public void setName(String folderName) {
		this.myName = folderName;
	}
	
	/**
	 * Returns the data list of which the folder contains
	 * @return myDataList The Folder's data list
	 * @author Seoungdeok Jeon
	 */
	public List<Data> getDataList() {
		return myDataList;
	}
	
	/**
	 * Adds a folder to the Folder's data list.
	 * @param theFolder
	 * @author Seoungdeok Jeon
	 */
	public void addFolder(Folder theFolder) {
		myDataList.add(theFolder);
	}
	
	/**
	 * Removes a folder from the data list.
	 * @param theFolder The folder being removed
	 * @author Seoungdeok Jeon
	 */
	public void removeFolder(Folder theFolder) {
		for(int i = 0; i < myDataList.size(); ++i) {
			if (theFolder.getName() == myDataList.get(i).getName()) {
				myDataList.remove(myDataList.get(i));
			}
		}
	}
	
	/**
	 * Adds a file to the Folder's data list.
	 * @param theFile The file being added
	 * @author Seoungdeok Jeon
	 */
	public void addFile(FileClass theFile) {
		myDataList.add(theFile);
	}
	
	/**
	 * Removes a file from the Folder's data list 
	 * @param theFile The file being removed
	 * @author Seoungdeok Jeon
	 */
	public void removeFile(FileClass theFile) {
		myDataList.remove(theFile);
	}
	@Override
	public String toString() {
		return myName;
	}
}