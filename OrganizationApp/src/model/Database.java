package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	}
	
	public void removeFolder(Folder theFolder) {
		myCurrentFolder.removeFolder(theFolder);
	}

	public void addFile(FileClass theFile) {
		myCurrentFolder.addFile(theFile);
	}
	
	public void removeFile(FileClass theFile) {
		myCurrentFolder.removeFile(theFile);
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
	
	/**
	 * Performs search for specified file
	 * @param theFile String representation of the File
	 * @return The Folder the File is in, null otherwise
	 */
	public File fileSearch(String theFile) {
		final File foundFile = searchHelp(myCurrentFolder, theFile);
		return foundFile;
		
	}
	
	/**
	 * Recursive helper method searches for the specified file, and returns the folder
	 * that the file resides in, or null if no file.
	 * @param theData Should be a folder.
	 * @param theFile The string that the file should match
	 * @return targetFolder The Folder the File is in, null otherwise.
	 */
	private File searchHelp(Data theData, String theFile) {
		File targetFile = null;
		
		if (Objects.nonNull(theData)) {
			if (theData instanceof model.Folder) {
				for (Data x : ((Folder) theData).getDataList()) {
					if (x instanceof model.FileClass) {
						if (x.toString().equals(theFile.toString())) {
							targetFile = ((FileClass) x).getFile();
							return targetFile;
						} 
					} else if (x instanceof model.Folder) {
						
						targetFile = searchHelp(x, theFile);
						
					}
				}
			}
		}
		return targetFile;
	}
}