package gui;

import java.util.EventListener;

public interface TopBarListener extends EventListener {
	public void editNameEventOccurred(String name);
	public void editEmailEventOccurred(String email);
	public void editSearchEventOccurred(String search);
}
