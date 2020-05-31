package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import model.Database;
import model.FileClass;
import model.Folder;

public class DatabaseTest {

	/** Test fixture. */
	private Database myTestDatabase;
	
	@Before
	public void setUp() {
		myTestDatabase = new Database();
	}

	/**
	 * Testing addFolder method.
	 */
	@Test
	public void testAddFolder() {
		myTestDatabase.addFolder(new Folder("Test"));
		assertTrue(!myTestDatabase.getCurrentFolder().getDataList().isEmpty());
	}

	/**
	 * Testing removeFolder method.
	 */
	@Test
	public void testRemoveFolder() {
		Folder test = new Folder("Test");
		myTestDatabase.addFolder(test);
		assertTrue(!myTestDatabase.getCurrentFolder().getDataList().isEmpty());
		myTestDatabase.removeFolder(test);
		assertTrue(myTestDatabase.getCurrentFolder().getDataList().isEmpty());
	}

	/**
	 * Testing addFile method.
	 */
	@Test
	public void testAddFile() {
		FileClass test = new FileClass(new File("project.pdf"));
		assertTrue(myTestDatabase.getCurrentFolder().getDataList().isEmpty());
		myTestDatabase.addFile(test);
		assertTrue(!myTestDatabase.getCurrentFolder().getDataList().isEmpty());
	}

	/**
	 * Testing removeFile method.
	 */
	@Test
	public void testRemoveFile() {
		FileClass test = new FileClass(new File("project.pdf"));
		assertTrue(myTestDatabase.getCurrentFolder().getDataList().isEmpty());
		myTestDatabase.addFile(test);
		assertTrue(!myTestDatabase.getCurrentFolder().getDataList().isEmpty());
		myTestDatabase.removeFile(test);
		assertTrue(myTestDatabase.getCurrentFolder().getDataList().isEmpty());
	}

	/**
	 * Testing getCurrentFolder method.
	 */
	@Test
	public void testGetCurrentFolder() {
		Folder test = new Folder("Test");
		myTestDatabase.setCurrentFolder(test);
		assertEquals(test, myTestDatabase.getCurrentFolder());
	}

	/**
	 * Testing setCurrentFolder method.
	 */
	@Test
	public void testSetCurrentFolder() {
		Folder test = new Folder("Test");
		myTestDatabase.setCurrentFolder(test);
		assertEquals(test, myTestDatabase.getCurrentFolder());
	}

	/**
	 * Testing goToPreviousFolder method.
	 */
	@Test
	public void testGoToPreviousFolder() {
		Folder test = new Folder("Test");
		myTestDatabase.setCurrentFolder(test);
		Folder test2 = new Folder("Test2");
		myTestDatabase.setCurrentFolder(test2);
		myTestDatabase.goToPreviousFolder();
		assertEquals(test, myTestDatabase.getCurrentFolder());
	}


	/**
	 * Testing goToHomeFolder method.
	 */
	@Test
	public void testGoToHomeFolder() {
		Folder home = myTestDatabase.getCurrentFolder();
		Folder test = new Folder("Test");
		myTestDatabase.setCurrentFolder(test);
		Folder test2 = new Folder("Test2");
		myTestDatabase.setCurrentFolder(test2);
		myTestDatabase.goToHomeFolder();
		assertEquals(home, myTestDatabase.getCurrentFolder());
	}

	/**
	 * Testing getProjectVersion method.
	 */
	@Test
	public void testGetProjectVersion() {
		assertEquals(1.0, myTestDatabase.getProjectVersion(), 0.01);
	}

	/**
	 * Testing getSettings method.
	 */
	@Test
	public void testGetSettings() {
		assertEquals(null, myTestDatabase.getSettings().getUserEmail());
		assertEquals(null, myTestDatabase.getSettings().getUserName());
	}

	/**
	 * Testing fileSearch method.
	 */
	@Test
	public void testFileSearch() {
		File testFile = new File("project.pdf");
		FileClass test = new FileClass(testFile);
		assertTrue(myTestDatabase.getCurrentFolder().getDataList().isEmpty());
		myTestDatabase.addFile(test);
		assertTrue(!myTestDatabase.getCurrentFolder().getDataList().isEmpty());
		
		assertEquals(testFile,myTestDatabase.fileSearch("project.pdf"));
	}

}
