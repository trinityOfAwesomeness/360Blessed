package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import model.FileClass;
import model.Folder;

public class FolderTest {

	/** Test fixture. */
	private Folder myTestFolder;

	/**
	 * This method runs before EVERY test case. Use it to re-initialize test fixtures. 
	 */
	@Before
	public void setUp() {
		myTestFolder = new Folder("Test Folder");
	}
	
	/**
	 * Testing constructor for Folder class.
	 */
	@Test
	public void testFolder() {
		assertEquals("Test Folder", myTestFolder.getName());
		assertTrue(myTestFolder.getDataList().isEmpty());
	}

	/**
	 * Testing getName method.
	 */
	@Test
	public void testGetName() {
		assertEquals("Test Folder", myTestFolder.getName());
	}

	/**
	 * Testing setName method.
	 */
	@Test
	public void testSetName() {
		myTestFolder.setName("Test Name");
		assertEquals("Test Name", myTestFolder.getName());
	}

	/**
	 * Testing getDataList method.
	 */
	@Test
	public void testGetDataList() {
		assertTrue(myTestFolder.getDataList().isEmpty());
		myTestFolder.addFolder(new Folder("Test"));
		assertTrue(!myTestFolder.getDataList().isEmpty());
	}

	/**
	 * Testing addFolder method.
	 */
	@Test
	public void testAddFolder() {
		assertTrue(myTestFolder.getDataList().isEmpty());
		myTestFolder.addFolder(new Folder("Test"));
		assertTrue(!myTestFolder.getDataList().isEmpty());
	}

	/**
	 * Testing removeFolder method.
	 */
	@Test
	public void testRemoveFolder() {
		Folder test = new Folder("Test");
		assertTrue(myTestFolder.getDataList().isEmpty());
		myTestFolder.addFolder(test);
		assertTrue(!myTestFolder.getDataList().isEmpty());
		myTestFolder.removeFolder(test);
		assertTrue(myTestFolder.getDataList().isEmpty());
	}

	/**
	 * Testing addFile method.
	 */
	@Test
	public void testAddFile() {
		FileClass test = new FileClass(new File("project.pdf"));
		assertTrue(myTestFolder.getDataList().isEmpty());
		myTestFolder.addFile(test);
		assertTrue(!myTestFolder.getDataList().isEmpty());
	}

	/**
	 * Testing removeFile method.
	 */
	@Test
	public void testRemoveFile() {
		FileClass test = new FileClass(new File("project.pdf"));
		assertTrue(myTestFolder.getDataList().isEmpty());
		myTestFolder.addFile(test);
		assertTrue(!myTestFolder.getDataList().isEmpty());
		myTestFolder.removeFile(test);
		assertTrue(myTestFolder.getDataList().isEmpty());
	}

	/**
	 * Testing toString method.
	 */
	@Test
	public void testToString() {
		assertEquals("Test Folder", myTestFolder.getName());
	}

}
