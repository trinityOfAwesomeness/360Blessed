package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import application.App;

/**
 * Class to Side Panel for GUI.
 * @author Seoungdeok Jeon
 *
 */
public class SidePanel extends JPanel {

	/**
	 * Constructor for SidePanel object.
	 */
	public SidePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
