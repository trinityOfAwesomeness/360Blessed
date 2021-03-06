//ToolBar class for our TCSS360 project
package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import application.App;
import model.FileClass;
import model.Folder;

/**
 * This class manages our ToolBar in the app's GUI.
 * @author Seoungdeok Jeon
 *
 */
public class ToolBar extends JToolBar {

	/** Default serial ID. */
	private static final long serialVersionUID = 1L;
	/** The JFrame associated with the ToolBar. */
	private JFrame myFrame;
	/** Button that adds a folder. */
	private JButton myAddFolderBtn;
	/** Button that adds a file. */
	private JButton myAddFileBtn;
	/** Button the goes back one folder. */
	private JButton myBackBtn;
	/** Button that goes to home folder. */
	private JButton myHomeBtn;
	/** Listener for ToolBar. */
	private ToolBarListener myToolBarListener;
	
	/**
	 * Constructor for the ToolBar class
	 * @param theFrame The associated JFrame.
	 * @author Seoungdeok Jeon
	 */
	public ToolBar(JFrame theFrame) {
		myFrame = theFrame;
		myAddFolderBtn = new JButton();
		myAddFileBtn = new JButton();
		myBackBtn = new JButton();
		myHomeBtn = new JButton();
		ImageIcon addFolderIcon = new ImageIcon(Toolkit.getDefaultToolkit().
				getImage(App.class.getResource("/ic_addFolder.png")));
		// Resizing the icon
		Image addFolderIconImage = addFolderIcon.getImage();
		Image resizedAddFolderIconImage = addFolderIconImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
		addFolderIcon = new ImageIcon(resizedAddFolderIconImage);
		myAddFolderBtn.setIcon(addFolderIcon);
		
		
		ImageIcon addFileIcon = new ImageIcon(Toolkit.getDefaultToolkit().
				getImage(App.class.getResource("/ic_addFile.png")));
		// Resizing the icon
		Image addFileIconImage = addFileIcon.getImage();
		Image resizedAddFileIconImage = addFileIconImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
		addFileIcon = new ImageIcon(resizedAddFileIconImage);
		myAddFileBtn.setIcon(addFileIcon);
		
		
		ImageIcon backIcon = new ImageIcon(Toolkit.getDefaultToolkit().
				getImage(App.class.getResource("/ic_back.png")));
		// Resizing the icon
		Image backIconImage = backIcon.getImage();
		Image resizedBackIconImage = backIconImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
		backIcon = new ImageIcon(resizedBackIconImage);
		myBackBtn.setIcon(backIcon);
		
		ImageIcon homeIcon = new ImageIcon(Toolkit.getDefaultToolkit().
				getImage(App.class.getResource("/ic_home.png")));
		// Resizing the icon
		Image homeIconImage = homeIcon.getImage();
		Image resizedHomeIconImage = homeIconImage.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
		homeIcon = new ImageIcon(resizedHomeIconImage);
		myHomeBtn.setIcon(homeIcon);
		
		addActionListeners();
		
		add(myHomeBtn);
		add(myBackBtn);
		add(myAddFolderBtn);
		add(myAddFileBtn);
	}
	
	/**
	 * Sets the ToolBar's listener.
	 * @param theListener The listener being set.
	 * @author Seoungdeok Jeon
	 */
	public void setToolBarListener(ToolBarListener theListener) {
		myToolBarListener = theListener;
	}
	
	/**
	 * The ToolBar's action listeners
	 * @author Seoungdeok Jeon
	 */
	public void addActionListeners() {
		// The actual functionality for this button is in the MainFrame, 
		// which can interact with the controller. 
		myAddFolderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)JOptionPane.showInputDialog(
						myFrame, "", "Create new folder",
						JOptionPane.PLAIN_MESSAGE, null, null, "New Folder");
				if ((name != null) && (name.length() > 0)) {
					Folder folder = new Folder(name);
					if (myToolBarListener != null) {
						myToolBarListener.addFolderEventOccurred(folder);
					}
				}
			}
		});

		myAddFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				File selectedfile = null;
				if (fileChooser.showOpenDialog(myFrame) == JFileChooser.APPROVE_OPTION) {
					selectedfile = fileChooser.getSelectedFile();
				}
				if(selectedfile != null) {
					FileClass file = new FileClass(selectedfile);
					if (myToolBarListener != null) {
						myToolBarListener.addFileEventOccurred(file);
					}
				}
			}
		});
		
		myBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (myToolBarListener != null) {
					myToolBarListener.goBackEventOccurred();
				}
			}
		});
		
		myHomeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (myToolBarListener != null) {
					myToolBarListener.goHomeEventOccurred();
				}
			}
		});
	}
}
