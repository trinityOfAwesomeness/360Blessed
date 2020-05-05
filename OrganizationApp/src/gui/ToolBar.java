package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import model.File;
import model.Folder;

public class ToolBar extends JToolBar{

	private JButton myAddFolderBtn;
	private JButton myAddFileBtn;
	private ToolBarListener myToolBarListener;
	
	public ToolBar(JFrame theFrame) {
		myAddFolderBtn = new JButton("+ Folder");
		myAddFileBtn = new JButton("+ File");
		
		// The actual functionality for this button is in the MainFrame, 
		// which can interact with the controller. 
		myAddFolderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)JOptionPane.showInputDialog(
				                    theFrame,
				                    "",
				                    "Create new folder",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null,
				                    "New Folder");
				Folder folder = new Folder(name);
				
				if (myToolBarListener != null) {
					myToolBarListener.addFolderEventOccurred(folder);
				}
			}
		});
		
		myAddFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)JOptionPane.showInputDialog(
				                    theFrame,
				                    "",
				                    "Create new file",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null,
				                    "New File");
				File file = new File(name);
				
				if (myToolBarListener != null) {
					myToolBarListener.addFileEventOccurred(file);
				}
			}
		});
		
		add(myAddFolderBtn);
		add(myAddFileBtn);
	}
	
	public void setToolBarListener(ToolBarListener theListener) {
		this.myToolBarListener = theListener;
	}
}
