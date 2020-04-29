package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Class to build Main frame of GUI.
 * @author Seoungdeok Jeon
 * @author Tatiana Linardopoulou
 *
 */
public class MainFrame extends JFrame implements ActionListener {

	private ContentPanel contentPanel;
	private SidePanel sidePanel;
	private JToolBar toolBar;
    private JMenuItem myAboutMenu;
    private ProjectVersion myProjectVersion;
	
    /**
     * Constructor for Mainframe object.
     * Creates Mainframe and components.
     * @param the version the program version
     */
	public MainFrame(ProjectVersion theVersion) {
		
		myProjectVersion = theVersion;
		contentPanel = new ContentPanel();
		sidePanel = new SidePanel();
		toolBar = new JToolBar();
		setLayout(new BorderLayout());
		
		toolBar.add(new JButton("+ Folder"));
		toolBar.add(new JButton("+ File"));
		
		setJMenuBar(createMenuBar());
		add(contentPanel, BorderLayout.CENTER);
		add(sidePanel, BorderLayout.WEST);
		add(toolBar, BorderLayout.NORTH);
		
		setSize(1000, 700);
		setTitle("Organization App");
		setVisible(true);
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
		myAboutMenu = new JMenuItem("About Program");
		myAboutMenu.addActionListener(this);
		
		aboutMenu.add(myAboutMenu);
		fileMenu.add(add);
		fileMenu.add(remove);
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		return menuBar;
	}
    
	/**
	 * Creates pop-up message with info when user clicks about Program tab in About Menu.
	 * Info includes developer names and version. 
	 * @param theEvent the action event
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
		if (theEvent.getSource().equals(myAboutMenu)) {
			JOptionPane.showMessageDialog(this, "Developers:\n"
					+ "Adam Hall\n"
					+ "Seoungdeok Jeon\n"
					+ "Tatiana Linardopoulou\n\n"
					+ "Version: " + myProjectVersion.getVersion());

		}
	}	
}
