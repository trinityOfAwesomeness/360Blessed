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
 */
public class Controller {
	
	Database myDataBase = new Database();
	Settings mySettings = new Settings();
	
	/**
	 * Add a new folder to the data list.
	 * 
	 * @param folder - new folder to be added
	 */
	public void addFolder(Folder folder) {
		myDataBase.addFolder(folder);
	}
	
	/**
	 * Add a new file to the data list.
	 * 
	 * @param file - new file to be added
	 */
	public void addFile(FileClass file) {
		myDataBase.addFile(file);
	}
	
	/**
	 * Remove a data, which is at the given index.
	 * 
	 * @param index - the index of a data to be removed
	 */
	public void removeData(int index) {
		myDataBase.removeData(index);
	}
	
	public Folder getCurrentFolder() {
		return myDataBase.getCurrentFolder();
	}
	
	public void setCurrentFolder(Folder theFolder) {
		myDataBase.setCurrentFolder(theFolder);
	}
	
	public void goToPreviousFolder() throws IndexOutOfBoundsException {
		myDataBase.goToPreviousFolder();
	}
	
	public void goToHomeFolder() {
		myDataBase.goToHomeFolder();
	}
	
	public Settings getSettings() {
		return myDataBase.getSettings();
	}
	
	public double getProjectVersion() {
		return myDataBase.getProjectVersion();
	}

	public void loadSettingsFromFile(File file) throws IOException {
		myDataBase.loadSettingsFromFile(file);
	}
	
	public void saveSettingsToFile(File file) throws IOException {
		myDataBase.saveSettingsToFile(file);
	}
}