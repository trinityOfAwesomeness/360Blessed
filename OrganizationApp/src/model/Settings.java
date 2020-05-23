package model;

/**
 * Settings class.
 * 
 * @author Tatiana Linardopoulou
 */
public class Settings {
	
	private String myName;
	private String myEmail;
	
	public Settings(String theName, String theEmail) {
		this.myName = theName;
		this.myEmail = theEmail;
	}
	
	public void setName(String theName) {
		this.myName = theName;
	}
	
	public void setEmail(String theEmail) {
		this.myEmail = theEmail;
	}
	
	public String getName() {
		return this.myName;
	}
	
	public String getEmail() {
		return this.myEmail;
	}

}
