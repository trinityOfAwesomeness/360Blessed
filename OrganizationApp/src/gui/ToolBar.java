package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import model.FileClass;
import model.Folder;

public class ToolBar extends JToolBar {

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
				// JOptionPane.showMessageDialog(null, jOptionPanel(), "Information",JOptionPane.DEFAULT_OPTION);

				JFileChooser fileChooser = new JFileChooser();
				File selectedfile = null;
				if (fileChooser.showOpenDialog(theFrame) == JFileChooser.APPROVE_OPTION) {
					selectedfile = fileChooser.getSelectedFile();
				}

				FileClass file = new FileClass(selectedfile);
				if (myToolBarListener != null) {
					myToolBarListener.addFileEventOccurred(file);
				}
			}
		});

		add(myAddFolderBtn);
		add(myAddFileBtn);
	}

	public void setToolBarListener(ToolBarListener theListener) {
		myToolBarListener = theListener;
	}

//	private JPanel jOptionPanel(JFrame theFrame) {
//		JPanel MainPanel = new JPanel();
//		MainPanel.setLayout(new BorderLayout());
//
//		JPanel loadPanel = new JPanel();
//		loadPanel.setLayout(new BorderLayout());
//		
//		JPanel panel2 = new JPanel();
//
//		JButton loadFile = new JButton("load file");
//		loadFile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fileChooser = new JFileChooser();
//				File selectedfile = null;
//				if (fileChooser.showOpenDialog(theFrame) == JFileChooser.APPROVE_OPTION) {
//					selectedfile = fileChooser.getSelectedFile();
//				}
//				FileClass file = new FileClass(selectedfile);
//			}
//		});
//		
//		loadPanel.add(loadFile);
//		loadPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//
//
//		panel2.add(new JTextField(20));
//		panel2.add(new JLabel("Label"));
//		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
//
//
//		MainPanel.add(loadPanel, BorderLayout.NORTH);
//		MainPanel.add(panel2, BorderLayout.CENTER);
//		MainPanel.setPreferredSize(new Dimension(500,500));
//		MainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//		return MainPanel;
//	}
}
