//Top panel listener interface for our TCSS360 class
package gui;

import java.util.EventListener;
/**
 * This is an interface for our TopPanel listeners
 * @author Tatiana Linardopoulou
 *
 */
public interface TopPanelListener extends EventListener {
	/** Catches changes to name field. */
	public void editNameEventOccurred(String name);
	/** Catches changes to email field. */
	public void editEmailEventOccurred(String email);
	/** Catches changes to search field. */
	public void editSearchEventOccurred(String search);
}
