package gui;

import java.util.EventListener;

import model.Folder;

public interface FolderClickedListener extends EventListener {
	public void folderClickedEventOccurred(Folder folder);
}
