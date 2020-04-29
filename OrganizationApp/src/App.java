import javax.swing.SwingUtilities;

import gui.MainFrame;
import gui.ProjectVersion;

/**
 * Class to run App.
 * @author Seoungdeok Jeon
 * @author Tatiana Linardopoulou
 *
 */
public class App {

	/**
	 * Runs GUI and sets Project Version.
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ProjectVersion version = new ProjectVersion();
				version.setVersion(1.1);
				new MainFrame(version);
			}
		});
		
	}
}
