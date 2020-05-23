package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
				String name = (String)JOptionPane.showInputDialog(
						theFrame,
						"",
						"Create new file",
						JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"New File");

				//JOptionPane.showMessageDialog(null, jOptionPanel(), "Information",JOptionPane.DEFAULT_OPTION);

				if ((name != null) && (name.length() > 0)) {
					FileClass file = new FileClass(name);
					if (myToolBarListener != null) {
						myToolBarListener.addFileEventOccurred(file);
					}
				}
			}
		});

		add(myAddFolderBtn);
		add(myAddFileBtn);
	}

	public void setToolBarListener(ToolBarListener theListener) {
		myToolBarListener = theListener;
	}
//
//	private JPanel jOptionPanel() {
//		JPanel MainPanel = new JPanel();
//		JPanel panel = new JPanel();
//		JPanel panel2 = new JPanel();
//		MainPanel.setLayout(new BorderLayout());
//		panel.add(new JButton("Click"));
//		panel.setBorder(BorderFactory.createLineBorder(Color.black));
//		panel2.add(new JTextField(20));
//		panel2.add(new JLabel("Label"));
//		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
//		MainPanel.add(panel, BorderLayout.NORTH);
//		MainPanel.add(panel2, BorderLayout.CENTER);
//		MainPanel.setPreferredSize(new Dimension(500,500));
//		MainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//		return MainPanel;
//	}
}
