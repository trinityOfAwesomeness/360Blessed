package controller;

import java.util.List;

import model.Data;
import model.Database;
import model.File;
import model.Folder;

/**
 * Class to connect View with Model.
 * 
 * @author Seoungdeok Jeon
 */
public class Controller {
	
	Database myDataBase = new Database();
	
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
	
}
