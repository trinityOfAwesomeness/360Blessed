package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main model class which interact with controller.
 * 
 * @author Seoungdeok Jeon
 */
public class Database {

	private Folder myCurrentFolder;
	private List<Folder> myPreviousFolders;
	
	private ProjectVersion myProjectVersion;
	private Settings mySettings;

	public Database() {
		myCurrentFolder = new Folder("");
		myPreviousFolders = new ArrayList<Folder>();
		myProjectVersion = new ProjectVersion();
		mySettings = new Settings();
	}

	
	
	
	public void addFolder(Folder theFolder) {
		myCurrentFolder.addFolder(theFolder);
		
		System.out.println(myCurrentFolder.getDataList());
	}

	public void addFile(FileClass theFile) {
		myCurrentFolder.addFile(theFile);
		
		System.out.println(myCurrentFolder.getDataList());
	}
	
	public void removeData (int index) {
	//	myDataList.remove(index);
	}

	
	
	
	
	/**
	 * Get current folder.
	 * @return the current folder
	 */
	public Folder getCurrentFolder() {
		return myCurrentFolder;
	}

	/**
	 * Set current folder
	 * @param theFolder - the folder to be set
	 */
	public void setCurrentFolder(Folder theFolder) {
		myPreviousFolders.add(myCurrentFolder);
		myCurrentFolder = theFolder;
		System.out.println(myPreviousFolders);
	}
	
	public void goToPreviousFolder() throws IndexOutOfBoundsException {
		try {
			int previousFolderLocation = myPreviousFolders.size()-1;
			myCurrentFolder = myPreviousFolders.get(previousFolderLocation);
			myPreviousFolders.remove(previousFolderLocation);
		} catch (IndexOutOfBoundsException e){
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void goToHomeFolder() {
		myCurrentFolder = myPreviousFolders.get(0);
		myPreviousFolders.removeAll(myPreviousFolders);
	}
	
	public double getProjectVersion() {
		return myProjectVersion.getVersion();
	}
	
	public Settings getSettings() {
		return mySettings;
	}

	public void loadSettingsFromFile(File file) throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			String[] parts = line.split("\\s+");
			String userName = parts[0];
			String userEmail = parts[1];
			mySettings.setUserName(userName);
			mySettings.setUserEmail(userEmail);
			reader.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IOException();
		}
	}
	
	public void saveSettingsToFile(File file) throws IOException {
		try {
            FileWriter writer = new FileWriter(file);
            writer.write(mySettings.getUserName() + " " + mySettings.getUserEmail());
            writer.close();
        } catch (IOException ex) {
        	throw new IOException();
        }
	}
}