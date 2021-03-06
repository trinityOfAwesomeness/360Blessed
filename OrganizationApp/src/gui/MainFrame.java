//View class for our TCSS360 project.
package gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import controller.Controller;
import model.FileClass;
import model.Folder;

/**
 * Class to build Main frame of GUI.
 * It interacts with controller.
 * 
 * @author Seoungdeok Jeon
 * @author Tatiana Linardopoulou
 * @author Adam H Hall
 */
public class MainFrame extends JFrame {

	/** Automatic serial version to quiet eclipse. */
	private static final long serialVersionUID = 1L;
	/** Instance of our controller. */
	private Controller myController;
	/** Instance of our content panel. */
	private ContentPanel myContentPanel;
	/** Instance of our TopPanel. */
	private TopPanel myTopPanel;

	/**
	 * Constructor for Mainframe object.
	 * Creates Mainframe and components.
	 * @param the version the program version
	 * @author Seoungdeok Jeon
	 * @author Tatiana Linardopoulou
	 * @author Adam Hall
	 */
	public MainFrame() {
		myController = new Controller();
		myContentPanel = new ContentPanel();
		myTopPanel = new TopPanel(this);
		setLayout(new BorderLayout());

		myContentPanel.setCurrentFolder(myController.getCurrentFolder());


		myContentPanel.setFolderClickedListener(new FolderClickedListener() {
			@Override
			/**
			 * @author Adam Hall
			 */
			public void folderClickedEventOccurred(Folder folder) {
				myController.setCurrentFolder(folder);
				myContentPanel.setCurrentFolder(myController.getCurrentFolder());
				myContentPanel.update();
			}
		});

		// Since MainFrame is the only view class that can interact with the controller,
		// it adds functionality here for tool bar.
		myTopPanel.getToolBar().setToolBarListener(new ToolBarListener() {
			@Override
			/**
			 * @author Adam Hall
			 */
			public void addFolderEventOccurred(Folder folder) {
				myController.addFolder(folder);
				myContentPanel.update();
			}

			@Override
			/**
			 * @author Adam Hall
			 */
			public void addFileEventOccurred(FileClass file) {
				myController.addFile(file);
				myContentPanel.update();
			}
			@Override
			/**
			 * @author Adam Hall
			 */
			public void goBackEventOccurred() {
				try {
					myController.goToPreviousFolder();
					myContentPanel.setCurrentFolder(myController.getCurrentFolder());
					myContentPanel.update();
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(MainFrame.this, "Can't go back anymore!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			@Override
			/**
			 * @author Adam Hall
			 */
			public void goHomeEventOccurred() {
				try {
					myController.goToHomeFolder();
					myContentPanel.setCurrentFolder(myController.getCurrentFolder());
					myContentPanel.update();
					repaint();
					revalidate();
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(MainFrame.this, "You are seeing the main page!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		myTopPanel.setTopPanelListener(new TopPanelListener() {
			@Override
			/**
			 * @author Tatiana Linardopoulou
			 */
			public void editNameEventOccurred(String name) {
				myController.getSettings().setUserName(name);
			}
			@Override
			/**
			 * @author Tatiana Linardopoulou
			 */
			public void editEmailEventOccurred(String email) {
				myController.getSettings().setUserEmail(email);
			}
			@Override
			/**
			 * @author Adam Hall
			 */
			public void editSearchEventOccurred(String theFile)  {
			    final File foundFile = myController.findFile(theFile);
			    if (foundFile != null) {
			    	if (Desktop.isDesktopSupported()) {
			    		Desktop desktop = Desktop.getDesktop();
			    		if (foundFile.exists()) {
			    			try {
								desktop.open(foundFile);
							} catch (IOException e) {
								System.out.println("Failed to open file");
							}
			    		}
			    	}
			    			    	
			    } else {
				JOptionPane.showMessageDialog(null, "File Not Found!", "Error",
						JOptionPane.ERROR_MESSAGE);
			    }
			} 

		});

		setJMenuBar(createMenuBar());
		add(myContentPanel, BorderLayout.CENTER);
		add(myTopPanel, BorderLayout.NORTH);


		setTitle("Organization App");
		setVisible(true);
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Constructor for menuBar object.
	 * Creates menuBar and adds menu bar components.
	 * @return menuBar the menu bar
	 * @author Seoungdeok James
	 * @author Tatiana Linardopoulou
	 * @author Adam Hall
	 */
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu aboutMenu = new JMenu("About");
		JMenuItem aboutProgram = new JMenuItem("About Program");
		JMenu settingsMenu = new JMenu("Settings");
		JMenuItem importSettings = new JMenuItem("Import Settings...");
		JMenuItem exportSettings = new JMenuItem("Export Settings...");


		aboutProgram.addActionListener(new ActionListener() {
			@Override
			/**
			 * @author Tatiana Linardopoulou
			 */
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Developers:\n"
						+ "Adam Hall\n"
						+ "Seoungdeok Jeon\n"
						+ "Tatiana Linardopoulou\n\n"
						+ "Version: " + myController.getProjectVersion());
			}
		});

		importSettings.addActionListener(new ActionListener() {
			/**
			 * @author Tatiana Linardopoulou
			 */
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						myController.loadSettingsFromFile(fileChooser.getSelectedFile());
						myTopPanel.update(myController.getSettings().getUserName(),
								myController.getSettings().getUserEmail());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not load settings from file.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		exportSettings.addActionListener(new ActionListener() {
			/**
			 * @author Tatiana Linardopoulou
			 */
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						myController.saveSettingsToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not save settings to file.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		aboutMenu.add(aboutProgram);
		menuBar.add(settingsMenu);
		settingsMenu.add(importSettings);
		settingsMenu.add(exportSettings);
		menuBar.add(aboutMenu);
		menuBar.add(settingsMenu);
		return menuBar;
	}
}