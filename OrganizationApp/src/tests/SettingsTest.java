package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Settings;

/**
 * This class tests the functionality for our Settings Class.
 * @author Tatiana Linardopoulou
 * @version Spring 2020
 *
 */
public class SettingsTest {

	private Settings mySettings;
	
	@Test
	public void testGetUserName() {
		mySettings = new Settings();
		mySettings.setUserName("Darth Vader");
		assertEquals("Darth Vader", mySettings.getUserName());
		
	}

	@Test
	public void testSetUserName() {
		mySettings = new Settings();
		mySettings.setUserName("Jean-Luc Picard");
		assertEquals("Jean-Luc Picard", mySettings.getUserName());
	}

	@Test
	public void testGetUserEmail() {
		mySettings = new Settings();
		mySettings.setUserEmail("DarthVader@starwars.com");
		assertEquals("DarthVader@starwars.com", mySettings.getUserEmail());
	}

	@Test
	public void testSetUserEmail() {
		mySettings = new Settings();
		mySettings.setUserEmail("picard@starfleet.com");
		assertEquals("picard@starfleet.com", mySettings.getUserEmail());
	}

	@Test
	public void testToString() {
		mySettings = new Settings();
		mySettings.setUserName("Jean-Luc Picard");
		mySettings.setUserEmail("picard@starfleet.com");
		assertEquals("Jean-Luc Picard picard@starfleet.com", mySettings.toString());
	}

}
