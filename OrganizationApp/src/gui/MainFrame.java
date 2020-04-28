package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainFrame extends JFrame {

	private ContentPanel contentPanel;
	private SidePanel sidePanel;
	private JToolBar toolBar;
	
	public MainFrame() {
		
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
	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		JMenuItem add = new JMenuItem("add");
		JMenuItem remove = new JMenuItem("remove");
		fileMenu.add(add);
		fileMenu.add(remove);
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		return menuBar;
	}
}
