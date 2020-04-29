package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
