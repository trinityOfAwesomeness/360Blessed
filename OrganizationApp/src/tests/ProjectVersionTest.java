//This class tests the version control methods in our OrganizationApp for TCSS360.
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import model.ProjectVersion;

/**
 * This class tests the functionality for our version method that populates
 * our about button in the about button using JUNIT4
 * @author Adam H Hall
 *
 */
public class ProjectVersionTest {
	
	/** The ProjectVersion object that will be used for testing. */
	private final ProjectVersion versionTest = new ProjectVersion();
	/** The version number. */
	private final Double CURRENT_VERSION = 9.9;
	
	/**
	 * This methods sets up the testing.
	 */
	@Before
	public void setUp() {
		versionTest.setVersion(CURRENT_VERSION);
	}
	
	/**
	 * This method tests the accessor method for 'getting' the version
	 * number.
	 */
	@Test
	public void testGetVersion() {
		//Created Double object due to precision issues JUNIT doesn't like with
		//assertEquals on primitives
		final Double expectedVersion = versionTest.getVersion();
		final Double incorrectVersion = -1.0;
		
		//Test for equality and inequality of getVersion method
		assertEquals("This tests failed, the version numbers should match",
					  CURRENT_VERSION, expectedVersion);
		
		assertNotEquals("This tests failed, the version numbers should not match",
						 incorrectVersion, expectedVersion);
	}
	
	/**
	 * This method tests the mutator method for 'setting' the version
	 * number.
	 */
	@Test
	public void testSetVersion() {
		final Double newVersion = 3.33;
		versionTest.setVersion(newVersion);
		
		//Test that version number was updated
		assertEquals("This test failed, the version numbers should match",
					  newVersion, (Double) versionTest.getVersion());
	}
	
}
