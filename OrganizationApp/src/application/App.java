package application;
import javax.swing.SwingUtilities;
import gui.MainFrame;

/**
 * Class to run App.
 * @author Seoungdeok Jeon
 * @author Tatiana Linardopoulou
 *
 */
public class App {

	/**
	 * Runs GUI.
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
		
	}
}
