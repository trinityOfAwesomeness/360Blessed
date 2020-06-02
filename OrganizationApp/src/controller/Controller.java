//Controller class for our TCSS360 project
package controller;

import java.io.File;
import java.io.IOException;
import model.Database;
import model.FileClass;
import model.Folder;
import model.Settings;

/**
 * Class to connect View with Model.
 * 
 * @author Seoungdeok Jeon
 * @author Adam Hall
 * @author Tatiana Linardopoulou
 */
public class Controller {
	
	Database myDataBase = new Database();
	Settings mySettings = new Settings();
	
	/**
	 * Add a new folder to the data list.
	 * 
	 * @param folder - new folder to be added
	 * @author Seoungdeok Jeon
	 */
	public void addFolder(Folder folder) {
		myDataBase.addFolder(folder);
	}
	
	/**
	 * Remove folder from the data list.
	 * 
	 * @param folder - folder to be removed
	 * @author Seoungdeok Jeon
	 */
	public void removeFolder(Folder folder) {
		myDataBase.removeFolder(folder);
	}	
	
	/**
	 * Add a new file to the data list.
	 * 
	 * @param file - new file to be added
	 * @author Seoungdeok Jeon
	 */
	public void addFile(FileClass file) {
		myDataBase.addFile(file);
	}
	
	/**
	 * Remove file from the data list.
	 * 
	 * @param file - file to be removed
	 * @author Seoungdeok Jeon
	 */
	public void removeFile(FileClass file) {
		myDataBase.removeFile(file);
	}
	
	/**
	 * Remove a data, which is at the given index.
	 * 
	 * @param index - the index of a data to be removed
	 * @author Seoungdeok Jeon
	 */
	
	public Folder getCurrentFolder() {
		return myDataBase.getCurrentFolder();
	}
	
	/**
	 * Sends string representation of the file to database to be searched
	 * and returns the File.
	 * @param theFile The string representation of the File
	 * @return The File.
	 * @author Seoungdeok Jeon
	 */
	public File findFile(String theFile) {
		return myDataBase.fileSearch(theFile);
	}
	
	/**
	 * This method sets the current folder.
	 * @param theFolder The Folder being set
	 * @author Seoungdeok Jeon
	 */
	public void setCurrentFolder(Folder theFolder) {
		myDataBase.setCurrentFolder(theFolder);
	}
	
	/**
	 * This method sets the previous folder as the current folder.
	 * @throws IndexOutOfBoundsException
	 * @author Adam Hall
	 */
	public void goToPreviousFolder() throws IndexOutOfBoundsException {
		myDataBase.goToPreviousFolder();
	}
	
	/**
	 * This method goes back to the home folder.
	 * @throws IndexOutOfBoundsException
	 * @author Adam Hall
	 */
	public void goToHomeFolder() throws IndexOutOfBoundsException {
		myDataBase.goToHomeFolder();
	}
	
	/**
	 * This method returns the settings
	 * @return The settings
	 * @author Adam Hall
	 */
	public Settings getSettings() {
		return myDataBase.getSettings();
	}
	
	/**
	 * This method returns the project version
	 * @return The project version
	 * @author Adam Hall
	 */
	public double getProjectVersion() {
		return myDataBase.getProjectVersion();
	}
	
	/**
	 * Loads settings from File
	 * @param file The source file
	 * @throws IOException
	 * @author Tatiana Linardopoulou
	 */
	public void loadSettingsFromFile(File file) throws IOException {
		myDataBase.loadSettingsFromFile(file);
	}
	
	/**
	 * Saves the settings to a File
	 * @param file The destination file
	 * @throws IOException
	 * @author Tatiana Linardopoulou
	 */
	public void saveSettingsToFile(File file) throws IOException {
		myDataBase.saveSettingsToFile(file);
	}
}