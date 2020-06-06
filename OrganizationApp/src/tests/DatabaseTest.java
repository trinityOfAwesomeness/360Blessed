// Tests the Database class
package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import model.Database;
import model.FileClass;
import model.Folder;
/**
 * Testing class for our Database methods
 * @author Seoungdeok Jeon
 * @author Adam Hall
 *
 */
public class DatabaseTest {

	/** Test fixture. */
	private Database myTestDatabase;
	
	/**
	 * Set up before each test.
	 * @author Seoungdeok Jeon
	 */
	@Before
	public void setUp() {
		myTestDatabase = new Database();
	}

	/**
	 * Testing addFolder method.
	 * @author Seoungdeok Jeon
	 */
	@Test
	public void testAddFolder() {
		myTestDatabase.addFolder(new Folder("Test"));
		assertTrue(!myTestDatabase.getCurrentFolder().getDataList().isEmpty());
	}

	/**
	 * Testing removeFolder method.
	 * @author Seoungdeok Jeon
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
	 * @author Seoungdeok Jeon
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
	 * @author Seoungdeok Jeon
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
	 * @author Adam Hall
	 */
	@Test
	public void testGetCurrentFolder() {
		Folder test = new Folder("Test");
		myTestDatabase.setCurrentFolder(test);
		assertEquals(test, myTestDatabase.getCurrentFolder());
	}

	/**
	 * Testing setCurrentFolder method.
	 * @author Adam Hall
	 */
	@Test
	public void testSetCurrentFolder() {
		Folder test = new Folder("Test");
		myTestDatabase.setCurrentFolder(test);
		assertEquals(test, myTestDatabase.getCurrentFolder());
	}

	/**
	 * Testing goToPreviousFolder method.
	 * @author Adam Hall
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
	 * @author Adam Hall
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
	 * @author Adam Hall
	 */
	@Test
	public void testGetProjectVersion() {
		assertEquals(1.0, myTestDatabase.getProjectVersion(), 0.01);
	}

	/**
	 * Testing getSettings method.
	 * @author Adam Hall
	 */
	@Test
	public void testGetSettings() {
		assertEquals(null, myTestDatabase.getSettings().getUserEmail());
		assertEquals(null, myTestDatabase.getSettings().getUserName());
	}

	/**
	 * Testing fileSearch method.
	 * @author Adam Hall
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
