package model;

/**
 * Data interface which can be either folder or file.
 * 
 * @author Seoungdeok Jeon
 */
public interface Data {
	/**
	 * Method that returns the name of the Data.
	 * @return The name of the Data
	 */
	public String getName();
	/**
	 * Method that sets the name of the Data.
	 * @param name The name of file being set
	 */
	public void setName(String name);
}
