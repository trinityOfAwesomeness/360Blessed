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
 * @author Seoungdeok Jeon
 * Added functionaility for search bar
 * @author Adam Hall
 *
 */
public class TopPanel extends JPanel{
	/** Serial version to quiet eclipse. */
	private static final long serialVersionUID = 1L;
	private ToolBar myToolBar;
	private JPanel mySettingField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField searchField;
	private TopBarListener myTopBarListener;

	public TopPanel(JFrame theFrame) {
		myToolBar = new ToolBar(theFrame);
		mySettingField = new JPanel();
		nameField = new JTextField(15);
		emailField = new JTextField(15);
		searchField = new JTextField(15);
		nameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myTopBarListener != null) {
					String name = nameField.getText();
					myTopBarListener.editNameEventOccurred(name);
				}

			}
		});
		emailField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myTopBarListener != null) {
					String email = nameField.getText();
					myTopBarListener.editEmailEventOccurred(email);
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
				myTopBarListener.editSearchEventOccurred(file);
			}
		
		};
		searchField.addActionListener(action);
		
		createSettingField();
		setLayout(new BorderLayout());
		add(myToolBar, BorderLayout.WEST);
		add(mySettingField, BorderLayout.EAST);
	}

	public ToolBar getToolBar() {
		return myToolBar;
	}

	public void createSettingField() {
		mySettingField.setLayout(new FlowLayout());
		mySettingField.add(new JLabel("Search: "));
		mySettingField.add(searchField);
		mySettingField.add(new JLabel("Name:"));
		mySettingField.add(nameField);
		mySettingField.add(new JLabel("Email address:"));
		mySettingField.add(emailField);
		
	}

	public void setTopBarListener(TopBarListener theListener) {
		myTopBarListener = theListener;
	}
	
	public void update(String name, String email) {
		nameField.setText(name);
		emailField.setText(email);
		validate();
	}
}
