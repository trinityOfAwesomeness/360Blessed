package gui;

import java.util.EventListener;

import model.File;
import model.Folder;

/**
 * Interface to contain tool bar listener methods.
 * 
 * @author Seoungdeok Jeon
 */
public interface ToolBarListener extends EventListener {
	public void addFolderEventOccurred(Folder theFolder);
	public void addFileEventOccurred(File theFile);
}