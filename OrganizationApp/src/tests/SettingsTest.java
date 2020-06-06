//Test class for our TCSS360 project
package tests;

import static org.junit.Assert.*;

import org.junit.Test;


import model.Settings;

/**
 * This class tests the functionality for our Settings Class.
 * @author Tatiana Linardopoulou
 *
 */
public class SettingsTest {

	private Settings mySettings;
	
	/**
	 * Test getting user name.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testGetUserName() {
		mySettings = new Settings();
		mySettings.setUserName("Darth Vader");
		assertEquals("Darth Vader", mySettings.getUserName());
		
	}

	/**
	 * Test setting user name.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testSetUserName() {
		mySettings = new Settings();
		mySettings.setUserName("Jean-Luc Picard");
		assertEquals("Jean-Luc Picard", mySettings.getUserName());
	}
	
	/**
	 * Test getting user email.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testGetUserEmail() {
		mySettings = new Settings();
		mySettings.setUserEmail("DarthVader@starwars.com");
		assertEquals("DarthVader@starwars.com", mySettings.getUserEmail());
	}

	/**
	 * Test setting user email.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testSetUserEmail() {
		mySettings = new Settings();
		mySettings.setUserEmail("picard@starfleet.com");
		assertEquals("picard@starfleet.com", mySettings.getUserEmail());
	}

	/**
	 * Test getting toString.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testToString() {
		mySettings = new Settings();
		mySettings.setUserName("Jean-Luc Picard");
		mySettings.setUserEmail("picard@starfleet.com");
		assertEquals("Jean-Luc Picard picard@starfleet.com", mySettings.toString());
	}

}
