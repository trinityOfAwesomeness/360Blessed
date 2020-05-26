package model;

public class Settings {
	private String myUserName;
	private String myUserEmail;
	
	public String getUserName() {
		return myUserName;
	}

	public void setUserName(String theUserName) {
		myUserName = theUserName;
	}

	public String getUserEmail() {
		return myUserEmail;
	}

	public void setUserEmail(String theUserEmail) {
		myUserEmail = theUserEmail;
	}
	
	public String toString() {
		return myUserName + " " + myUserEmail;
	}
}
