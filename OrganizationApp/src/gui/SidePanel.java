package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SidePanel extends JPanel {

	public SidePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
