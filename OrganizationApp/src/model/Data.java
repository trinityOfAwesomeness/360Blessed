package model;

/**
 * Data interface which can be either folder or file.
 * 
 * @author Seoungdeok Jeon
 */
public interface Data {
	public String getName();
	public String getDateCreated();
	public String getType();
	public void setName(String name);
}
