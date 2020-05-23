package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.Controller;
import model.File;
import model.Folder;
import model.ProjectVersion;

/**
 * Class to build Main frame of GUI.
 * It interacts with controller.
 * 
 * @author Seoungdeok Jeon
 * @author Tatiana Linardopoulou
 */
public class MainFrame extends JFrame {

	private Controller myController;
	private ContentPanel myContentPanel;
	private SidePanel mySidePanel;
	private ToolBar myToolBar;
    private ProjectVersion myProjectVersion;
	
    /**
     * Constructor for Mainframe object.
     * Creates Mainframe and components.
     * @param the version the program version
     */
	public MainFrame(ProjectVersion theVersion) {
		
		myController = new Controller();
		myProjectVersion = theVersion;
		myContentPanel = new ContentPanel();
		mySidePanel = new SidePanel();
		myToolBar = new ToolBar(this);
		setLayout(new BorderLayout());
		
		myContentPanel.setData(myController.getData());
		
		// Since MainFrame is the only view class that can interact with the controller,
		// it adds functionality for tool bar.
		myToolBar.setToolBarListener(new ToolBarListener() {
			@Override
			public void addFolderEventOccurred(Folder folder) {
				myController.addFolder(folder);
				myContentPanel.update();
			}

			@Override
			public void addFileEventOccurred(File file) {
				myController.addFile(file);
				myContentPanel.update();
			}
		});
		
		
		setJMenuBar(createMenuBar());
		add(myContentPanel, BorderLayout.CENTER);
		add(mySidePanel, BorderLayout.WEST);
		add(myToolBar, BorderLayout.NORTH);
		

		setTitle("Organization App");
		setVisible(true);
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Constructor for menuBar object.
	 * Creates menuBar and adds menu bar components.
	 * @return menuBar the menu bar
	 */
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		JMenuItem add = new JMenuItem("add");
		JMenuItem remove = new JMenuItem("remove");
		JMenuItem aboutProgram = new JMenuItem("About Program");
		aboutProgram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Developers:\n"
						+ "Adam Hall\n"
						+ "Seoungdeok Jeon\n"
						+ "Tatiana Linardopoulou\n\n"
						+ "Version: " + myProjectVersion.getVersion());
			}
		});
		
		aboutMenu.add(aboutProgram);
		fileMenu.add(add);
		fileMenu.add(remove);
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		return menuBar;
	}

}
