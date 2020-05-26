package gui;

import java.util.EventListener;

import model.FileClass;
import model.Folder;

/**
 * Interface to contain tool bar listener methods.
 * 
 * @author Seoungdeok Jeon
 */
public interface ToolBarListener extends EventListener {
	public void addFolderEventOccurred(Folder theFolder);
	public void addFileEventOccurred(FileClass theFile);
	public void goBackEventOccurred();
	public void goHomeEventOccurred();
}
