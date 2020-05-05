package model;

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
	
	public Database() {
		myDataList = new LinkedList<Data>();
	}
	
	public void addFolder(Folder folder) {
		myDataList.add(folder);
		System.out.println(myDataList);
	}
	
	public void removeFolder (int index) {
		myDataList.remove(index);
	}
	
	public void addFile(File file) {
		myDataList.add(file);
		System.out.println(myDataList);
	}
	
	public void removeFile (int index) {
		myDataList.remove(index);
	}
	
	public List<Data> getData(){
		return Collections.unmodifiableList(myDataList);
	}
}
