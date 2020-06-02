//Settings class for our TCSS360 project
package model;

/**
 * This class contains a settings profile for a given user.
 * @author Tatiana Linardopoulou
 *
 */
public class Settings {
	/** User name field. */
	private String myUserName;
	/** User email field. */
	private String myUserEmail;
	
	/**
	 * Method that returns username.
	 * @return myUserName The user's username
	 * @author Tatiana Linardopoulou
	 */
	public String getUserName() {
		return myUserName;
	}
	
	/**
	 * Sets the user name for a given username.
	 * @param theUserName The username to be set
	 * @author Tatiana Linardopoulou
	 */
	public void setUserName(String theUserName) {
		myUserName = theUserName;
	}
	
	/**
	 * Method that returns the user's email.
	 * @return myUserEmail The user's email
	 * @author Tatiana Linardopoulou
	 */
	public String getUserEmail() {
		return myUserEmail;
	}
	/**
	 * This method sets the user's email.
	 * @param theUserEmail The email.
	 * @author Tatiana Linardopoulou
	 */
	public void setUserEmail(String theUserEmail) {
		myUserEmail = theUserEmail;
	}
	@Override
	public String toString() {
		return myUserName + " " + myUserEmail;
	}
}
