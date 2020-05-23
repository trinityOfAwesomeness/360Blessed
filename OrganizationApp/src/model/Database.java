package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Main model class which interact with controller.
 * 
 * @author Seoungdeok Jeon
 */
public class Database {

	private List<Data> myDataList;
	private ProjectVersion myProjectVersion;
	private Settings mySettings;

	public Database() {
		myDataList = new LinkedList<Data>();
		myProjectVersion = new ProjectVersion();
		mySettings = new Settings();
	}


	public void addFolder(Folder folder) {
		myDataList.add(folder);
		System.out.println(myDataList);
	}

	public void addFile(FileClass file) {
		myDataList.add(file);
		System.out.println(myDataList);
	}

	public void removeData (int index) {
		myDataList.remove(index);
	}

	public List<Data> getData(){
		return Collections.unmodifiableList(myDataList);
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
            ex.printStackTrace();
        }
	}
}
