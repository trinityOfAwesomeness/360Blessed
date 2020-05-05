package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import application.App;
import model.Data;
import model.File;
import model.Folder;

/**
 * Class to build Content Panel with folders for GUI.
 * @author Seoungdeok Jeon
 */
public class ContentPanel extends JPanel {

	private List<Data> myDataList;
	private JPanel myContentPanel;

	/**
	 * Constructor for ContentPanel object.
	 * Builds content Panel with folders.
	 */
	public ContentPanel() {
		
		myContentPanel = new JPanel();
		
		setLayout(new BorderLayout());
		String title = String.format("%-80s%-86s%s", "Name", "Date Created", "Type"); 
		JLabel colName = new JLabel(title);
		add(colName, BorderLayout.NORTH);
		add(new JScrollPane(myContentPanel), BorderLayout.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void setData(List<Data> theDataList) {
		this.myDataList = theDataList;
	}

	/**
	 * Updates the contentPanel with elements in db.
	 */
	public void update() {
		myContentPanel.removeAll();
		myContentPanel.setLayout(new BoxLayout(myContentPanel, BoxLayout.Y_AXIS));
		for(Data data:myDataList) {
			if (data instanceof Folder) {
				ImageIcon folderIcon = new ImageIcon(Toolkit.getDefaultToolkit().
						getImage(App.class.getResource("/ic_folder.png")));

				// Resizing the icon
				Image image = folderIcon.getImage();
				Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
				folderIcon = new ImageIcon(newimg);

				JLabel folderLabel = new JLabel(data.getName());
				folderLabel.setIcon(folderIcon);
				folderLabel.setBorder(BorderFactory.createEtchedBorder());
				myContentPanel.add(folderLabel);
			} else if (data instanceof File) {
				ImageIcon fileIcon = new ImageIcon(Toolkit.getDefaultToolkit().
						getImage(App.class.getResource("/ic_file.png")));

				// Resizing the icon
				Image image = fileIcon.getImage();
				Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
				fileIcon = new ImageIcon(newimg);

				JLabel fileLabel = new JLabel(data.getName());
				fileLabel.setIcon(fileIcon);
				fileLabel.setBorder(BorderFactory.createEtchedBorder());
				myContentPanel.add(fileLabel);
			}
		}
		validate();
	}
}