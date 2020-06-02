//Top panel class for our GUI in our TCSS360 project
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * @author Tatiana Linardopoulou
 * Added functionality for searching for files
 * @author Adam Hall
 *
 */
public class TopPanel extends JPanel{
	/** Serial version to quiet eclipse. */
	private static final long serialVersionUID = 1L;
	/** The toolbar for the TopPanel. */
	private ToolBar myToolBar;
	/** The settings field. */
	private JPanel mySettingField;
	/** The name field for the TopPanel. */
	private JTextField nameField;
	/** The email field for the TopPanel. */
	private JTextField emailField;
	/** The search fierld for the TopPanel. */
	private JTextField searchField;
	/** The listener for the TopPanel attributes. */
	private TopPanelListener myTopPanelListener;

	/**
	 * Constructor for TopPanel
	 * @param theFrame The JFrame the TopPanel is associated with.
	 * @author Tatiana LinardoPoulou
	 * Added search field
	 * @author Adam Hall
	 */
	public TopPanel(JFrame theFrame) {
		myToolBar = new ToolBar(theFrame);
		mySettingField = new JPanel();
		nameField = new JTextField(15);
		emailField = new JTextField(15);
		searchField = new JTextField(15);
		nameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myTopPanelListener != null) {
					String name = nameField.getText();
					myTopPanelListener.editNameEventOccurred(name);
				}

			}
		});
		emailField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myTopPanelListener != null) {
					String email = nameField.getText();
					myTopPanelListener.editEmailEventOccurred(email);
				}

			}
		});
		//Used an AbstractAction to grab text field when 'enter key' detected
		Action action = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				String file = searchField.getText();
				myTopPanelListener.editSearchEventOccurred(file);
			}
		
		};
		searchField.addActionListener(action);
		
		createTopPanelField();
		setLayout(new BorderLayout());
		add(myToolBar, BorderLayout.WEST);
		add(mySettingField, BorderLayout.EAST);
	}
	
	/**
	 * Returns the ToolBar
	 * @return myToolBar The tool bar.
	 * @author Tatiana Linardopoulou
	 */
	public ToolBar getToolBar() {
		return myToolBar;
	}
	
	/**
	 * Creates the settings fields
	 * @author Tatiana Linardopoulou
	 * added search Jlabel
	 * @author Adam Hall
	 */
	public void createTopPanelField() {
		mySettingField.setLayout(new FlowLayout());
		mySettingField.add(new JLabel("Search: "));
		mySettingField.add(searchField);
		mySettingField.add(new JLabel("Name:"));
		mySettingField.add(nameField);
		mySettingField.add(new JLabel("Email address:"));
		mySettingField.add(emailField);
		
	}
	
	/**
	 * Sets the TopPanel listeners.
	 * @param theListener The Listener
	 * @author Tatiana Linardopoulou
	 */
	public void setTopPanelListener(TopPanelListener theListener) {
		myTopPanelListener = theListener;
	}
	
	/**
	 * Updates the TopPanel
	 * @param name The namefield 'name'
	 * @param email The emailfield 'name'
	 * @author Tatiana Linardopoulou
	 */
	public void update(String name, String email) {
		nameField.setText(name);
		emailField.setText(email);
		validate();
	}
}
