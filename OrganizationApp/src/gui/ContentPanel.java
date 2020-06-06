//This class is the content panel for our TCSS360 project. 
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import application.App;
import model.Data;
import model.FileClass;
import model.Folder;

/**
 * Class to build Content Panel with folders for GUI.
 * @author Seoungdeok Jeon
 * @author Tatiana Linardopoulou
 */
public class ContentPanel extends JPanel implements ActionListener {

	/** Serial version to quiet eclipse. */
	private static final long serialVersionUID = 1L;
	/** A reference to the current folder. */
	private Folder myCurrentFolder;
	/** A reference to this. */
	private JPanel myContentPanel;
	/** A reference to the popup menu. */
	private JPopupMenu myPopupMenu;
	/** Target name for the popup menu. */
	private String mySelectedPopupMenuTargetName;
	/** A reference to the menu item. */
	private JMenuItem myMenuItem;
	/** The folder clicked listeners. */
	private FolderClickedListener myFolderClickedListener;
	/** Our folder label. */
	private JLabel myFolderLabel;
	/** Our file label. */
	private JLabel myFileLabel;


	/**
	 * Constructor for ContentPanel object.
	 * Builds content Panel with folders.
	 * @author Tatiana Linardopoulou
	 * @author Seoungdeok Jeon
	 */
	public ContentPanel() {
		myContentPanel = new JPanel();
		setLayout(new BorderLayout());
		add(myContentPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.black));
		myPopupMenu = new JPopupMenu();
		myMenuItem = new JMenuItem("Delete");
		myMenuItem.addActionListener(this);
		myPopupMenu.add(myMenuItem);
	}

	public void setCurrentFolder(Folder theCurrentFolder) {
		myCurrentFolder = theCurrentFolder;
	}

	/**
	 * Updates the contentPanel with elements in myDataList.
	 * @author Tatiana Linardopoulou
	 * @author Seoungdeok Jeon
	 */
	public void update() {
		myContentPanel.removeAll();
		myContentPanel.setLayout(new BoxLayout(myContentPanel, BoxLayout.Y_AXIS));
		for(Data data:myCurrentFolder.getDataList()) {
			if (data instanceof Folder) {
				ImageIcon folderIcon = new ImageIcon(Toolkit.getDefaultToolkit().
						getImage(App.class.getResource("/ic_folder.png")));

				// Resizing the icon
				Image image = folderIcon.getImage();
				Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
				folderIcon = new ImageIcon(newimg);

				StringBuilder sb = new StringBuilder(data.getName());
				for(int i = 0; i < 300; i++) {
					sb.append(" ");
				}
				myFolderLabel = new JLabel(sb.toString());
				
				myFolderLabel.setBorder(BorderFactory.createEtchedBorder());
				myFolderLabel.setIcon(folderIcon);

				//right click pop-up menu
				MouseListener popupListener = new PopupListener(data.getName());
				myFolderLabel.addMouseListener(popupListener);

				// show files in clicked folder
				myFolderLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Folder clickedFolder = ((Folder) data);
						if (myFolderClickedListener != null) {
							myFolderClickedListener.folderClickedEventOccurred(clickedFolder);
						}
					}
				});
				myContentPanel.add(myFolderLabel);
			} else if (data instanceof FileClass) {
				ImageIcon fileIcon = new ImageIcon(Toolkit.getDefaultToolkit().
						getImage(App.class.getResource("/ic_file.png")));

				// Resizing the icon
				Image image = fileIcon.getImage();
				Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
				fileIcon = new ImageIcon(newimg);

				StringBuilder sb = new StringBuilder(data.getName());
				for(int i = 0; i < 300; i++) {
					sb.append(" ");
				}
				myFileLabel = new JLabel(sb.toString());
				myFileLabel.setIcon(fileIcon);
				myFileLabel.setBorder(BorderFactory.createEtchedBorder());

				//right click pop-up menu
				MouseListener popupListener = new PopupListener(data.getName());
				myFileLabel.addMouseListener(popupListener);

				// open file
				myFileLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Desktop.getDesktop().open(((FileClass) data).getFile());
						} catch (Exception e1) {
							e1.printStackTrace();

						}
					}
				});
				myContentPanel.add(myFileLabel);
			}
		}
		validate();
		repaint();
	}

	public void setFolderClickedListener(FolderClickedListener theListener) {
		myFolderClickedListener = theListener;
	}

	/**
	 * Class for right click pop-up menu with delete option.
	 * @author Tatiana Linardopoulou
	 *
	 */
	class PopupListener extends MouseAdapter {
		private String name;

		public void mousePressed(MouseEvent e) {
			mySelectedPopupMenuTargetName = this.name;
			maybeShowPopup(e);
		}

		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}

		private void maybeShowPopup(MouseEvent e) {
			if (e.isPopupTrigger()) {
				myPopupMenu.show(e.getComponent(),
						e.getX(), e.getY());
			}
		}

		public PopupListener(String name) {
			this.name = name;
		}
	}

	/**
	 * Displays confirm delete window and deletes folder/file if user selects "yes".
	 * Displays updated data in content panel.
	 * 
	 * @param e the Action Event
	 * @author Seoungdeok Jeon
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(myMenuItem, "Are you sure you want to delete this item?"
				+ "\nIf you delete a Folder, all of the Files within it will also be deleted!", "WARNING!",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			for (Data data:myCurrentFolder.getDataList()) {
				String name = data.getName();
				if( mySelectedPopupMenuTargetName == name) {
					if (data instanceof FileClass)				{
						myCurrentFolder.removeFile((FileClass)data);
					}
					else {
						myCurrentFolder.removeFolder((Folder)data);
					}
				}
				update();
				revalidate();
				repaint();
			}
		}

	}
}