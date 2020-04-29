package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class to build Content Panel with folders for GUI.
 * @author Seoungdeok Jeon
 *
 */
public class ContentPanel extends JPanel {

	private JLabel Folder1;
	private JLabel Folder2;
	private JLabel Folder3;
	private JLabel Folder4;
	private JLabel Folder5;
	
	/**
	 * Constructor for ContentPanel object.
	 * Builds content Panel with folders.
	 */
	public ContentPanel() {
		setLayout(new GridLayout(5, 1));
		Folder1 = new JLabel("Folder1");
		Folder2 = new JLabel("Folder2");
		Folder3 = new JLabel("Folder3");
		Folder4 = new JLabel("Folder4");
		Folder5 = new JLabel("Folder5");
		
		Folder1.setBorder(BorderFactory.createEtchedBorder());
		Folder2.setBorder(BorderFactory.createEtchedBorder());
		Folder3.setBorder(BorderFactory.createEtchedBorder());
		Folder4.setBorder(BorderFactory.createEtchedBorder());
		Folder5.setBorder(BorderFactory.createEtchedBorder());
		
		add(Folder1);
		add(Folder2);
		add(Folder3);
		add(Folder4);
		add(Folder5);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
