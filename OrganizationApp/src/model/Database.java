//Database class for TCSS360 project
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
 * @author Adam Hall
 */
public class Database {
	/** The current folder. */
	private Folder myCurrentFolder;
	/** List of previous folders. */
	private List<Folder> myPreviousFolders;
	/** The current project version. */
	private ProjectVersion myProjectVersion;
	/** The user settings. */
	private Settings mySettings;
	
	/**
	 * Constructor for Database class.
	 * @author Seoungdeok Jeon
	 */
	public Database() {
		myCurrentFolder = new Folder("");
		myPreviousFolders = new ArrayList<Folder>();
		myProjectVersion = new ProjectVersion();
		mySettings = new Settings();
	}
	
	/**
	 * Add folder method
	 * @param theFolder The Folder being added
	 * @author Seoungdeok Jeon
	 */
	public void addFolder(Folder theFolder) {
		myCurrentFolder.addFolder(theFolder);
	}
	
	/**
	 * Removes the Folder from current folder view
	 * @param theFolder
	 * @author Seoungdeok Jeon
	 */
	public void removeFolder(Folder theFolder) {
		myCurrentFolder.removeFolder(theFolder);
	}
	
	/**
	 * Adds file to the current folder.
	 * @param theFile The file being added
	 * @author Seoungdeok Jeon
	 */
	public void addFile(FileClass theFile) {
		myCurrentFolder.addFile(theFile);
	}
	
	/**
	 * Removes the File from the current folder
	 * @param theFile The file being removed
	 * @author Seoungdeok Jeon
	 */
	public void removeFile(FileClass theFile) {
		myCurrentFolder.removeFile(theFile);
	}
	
	/**
	 * Get current folder.
	 * @return the current folder
	 * @author Adam Hall
	 */
	public Folder getCurrentFolder() {
		return myCurrentFolder;
	}

	/**This method sets the current folder.
	 * @param theFolder - the folder to be set
	 * @author Adam Hall
	 */
	public void setCurrentFolder(Folder theFolder) {
		myPreviousFolders.add(myCurrentFolder);
		myCurrentFolder = theFolder;
	}
	
	/**
	 * This method sets the active folder as the previous folder
	 * @throws IndexOutOfBoundsException
	 * @author Adam Hall
	 */
	public void goToPreviousFolder() throws IndexOutOfBoundsException {
		try {
			int previousFolderLocation = myPreviousFolders.size()-1;
			myCurrentFolder = myPreviousFolders.get(previousFolderLocation);
			myPreviousFolders.remove(previousFolderLocation);
		} catch (IndexOutOfBoundsException e){
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Revert to home folder.
	 * @author Adam Hall
	 */
	public void goToHomeFolder() {
		myCurrentFolder = myPreviousFolders.get(0);
		myPreviousFolders.removeAll(myPreviousFolders);
	}
	
	/**
	 * Get the project version
	 * @return The project version
	 * @author Adam Hall
	 */
	public double getProjectVersion() {
		return myProjectVersion.getVersion();
	}
	
	/**
	 * Get the user settings
	 * @return The user's settings
	 */
	public Settings getSettings() {
		return mySettings;
	}
	
	/**
	 * This method loads settings from a File.
	 * @param file The File that contains the settings to load
	 * @throws IOException
	 * @author Adam Hall
	 */
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
	
	/**
	 * This method saves settings.
	 * @param file The File containing the settings to save
	 * @throws IOException
	 * @author Adam Hall
	 */
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
	 * @author Adam Hall
	 */
	public File fileSearch(String file) {
		File foundFile = searchHelp(myCurrentFolder, file);
		//if file not found in current folder, then search previous folders
		if (foundFile == null) {
			for (Folder f : myPreviousFolders) {
				foundFile = searchHelp(f, file);
				//safeguard from reassigning null to found file
				if (foundFile != null) {
					break;
				}
			}
		}
		return foundFile;
		
	}
	
	/**
	 * Recursive helper method searches for the specified file, and returns the folder
	 * that the file resides in, or null if no file.
	 * @param theData Should be a folder.
	 * @param theFile The string that the file should match
	 * @return targetFolder The Folder the File is in, null otherwise.
	 * @author Adam Hall
	 */
	private File searchHelp(Data theData, String file) {
		File targetFile = null;
		//if not null
		if (Objects.nonNull(theData)) {
			if (theData instanceof model.Folder) {
				//if its a folder iterate through data list
				for (Data x : ((Folder) theData).getDataList()) {
					//if file check for match, return if so
					if (x instanceof model.FileClass) {	
						if (x.toString().equals(file.toString())) {
							targetFile = ((FileClass) x).getFile();
							return targetFile;
						} 
					  //if its a Folder and targetFile isn't null, recursively search data
					} else if (x instanceof model.Folder) {
						targetFile = (targetFile == null) ? searchHelp(x, file) : targetFile;	
					}
				} 
			}
		}
		return targetFile;
	}
}