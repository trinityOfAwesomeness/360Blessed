package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.ProjectVersion;
import model.Settings;

/**
 * Tests for Settings class
 * @author Tatiana Linardopoulou
 *
 */
public class SettingsTest {
	
	/** Settings object to test.*/
	private Settings mySettingsTest;
	
	/** The name. */
	private String myName = "Darth Vader";
	
	/** The email. */
	private String myEmail = "darthvader@starwars.com";

	@Test
	public void testSettings() {
		mySettingsTest = new Settings(myName, myEmail);
		assertNotNull(mySettingsTest);
		assertEquals(myName, mySettingsTest.getName());
		assertEquals(myEmail, mySettingsTest.getEmail());
	}

	@Test
	public void testSetName() {
		mySettingsTest = new Settings(null, null);
		mySettingsTest.setName("Jean-Luc Picard");
		mySettingsTest.setEmail("picard@starfleet.com");
		assertEquals("Jean-Luc Picard", mySettingsTest.getName());
	}

	@Test
	public void testSetEmail() {
		mySettingsTest = new Settings(null, null);
		mySettingsTest.setName("Jean-Luc Picard");
		mySettingsTest.setEmail("picard@starfleet.com");
		assertEquals("picard@starfleet.com", mySettingsTest.getEmail());
	}

	@Test
	public void testGetName() {
		mySettingsTest = new Settings(null, null);
		mySettingsTest.setName("Data");
		mySettingsTest.setEmail("data@starfleet.com");
		assertEquals("Data", mySettingsTest.getName());
	}

	@Test
	public void testGetEmail() {
		mySettingsTest = new Settings(null, null);
		mySettingsTest.setName("Data");
		mySettingsTest.setEmail("data@starfleet.com");
		assertEquals("data@starfleet.com", mySettingsTest.getEmail());
	}

}
