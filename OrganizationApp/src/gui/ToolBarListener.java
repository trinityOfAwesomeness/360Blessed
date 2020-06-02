//Tool bar listener class for our TCSS360 project
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
	/** Listens for add folder button. */
	public void addFolderEventOccurred(Folder theFolder);
	/** Listens for add file button. */
	public void addFileEventOccurred(FileClass theFile);
	/** Listens for go back button. */
	public void goBackEventOccurred();
	/** Listens for go home button. */
	public void goHomeEventOccurred();
}
