package controller;

import java.util.List;

import model.Data;
import model.Database;
import model.File;
import model.Folder;
import model.Settings;

/**
 * Class to connect View with Model.
 * 
 * @author Seoungdeok Jeon
 */
public class Controller {
	
	Database myDataBase = new Database();
	Settings mySettings = new Settings(null, null);
	
	public List<Data> getData() {
		return myDataBase.getData();
	}
	
	public void addFolder(Folder folder) {
		myDataBase.addFolder(folder);
	}
	
	public void removeFolder(int index) {
		myDataBase.removeFolder(index);
	}
	
	public void addFile(File folder) {
		myDataBase.addFile(folder);
	}
	
	public void removeFile(int index) {
		myDataBase.removeFile(index);
	}
	
	public void setName(String theName) {
		mySettings.setName(theName);
	}
	
	public void setEmail(String theEmail) {
		mySettings.setName(theEmail);
	}
	
}
