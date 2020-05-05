package model;

/**
 * Class for version objects. Has methods to set/get program version.
 * Number before decimal = major program revision.
 * Number after decimal = minor program revision.
 * @author Tatiana Linardopoulou
 *
 */
public class ProjectVersion {
	
	private double myVersion = 1.0;
	
	/**
	 * Constructor for ProjectVersion object.
	 */
	public ProjectVersion() {
		
	}
	
	/**
	 * Sets project version number.
	 * @param number the version number
	 */
	public void setVersion(final double theNumber) {
		myVersion = theNumber;
		
	}
	
	/**
	 * Gets project version number.
	 * @return myProjectVersion the project version.
	 */
	public double getVersion() {
		return myVersion;
	}

}
