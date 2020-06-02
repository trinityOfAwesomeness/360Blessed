// Folder clicked listener for our TCSS360 class
package gui;

import java.util.EventListener;

import model.Folder;
/**
 * This is an interface listener class for a Folder being clicked.
 * @author Adam H Hall
 *
 */
public interface FolderClickedListener extends EventListener {
	/** Catches a folder being clicked. */
	public void folderClickedEventOccurred(Folder folder);
}
