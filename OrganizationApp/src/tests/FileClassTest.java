//FileClass test for our TCSS360 project
package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import model.FileClass;
/**
 * This class tests the FileClass methods
 * @author Tatiana Linardopoulou
 *
 */
public class FileClassTest {

	/** Test fixture. */
	private FileClass myTestFile;
	private File file = new File("project.pdf");
	/**
	 * This method runs before EVERY test case. Use it to re-initialize test fixtures. 
	 */
	@Before
	public void setUp() {
		myTestFile = new FileClass(file);
	}

	/**
	 * Testing constructor for FileClass.
	 */
	@Test
	public void testFileClass() {
		assertEquals(file, myTestFile.getFile());
		assertEquals("project.pdf", myTestFile.getName());
	}
	
	/**
	 * Testing getFile method.
	 */
	@Test
	public void testGetFile() {
		assertEquals(file, myTestFile.getFile());
	}

	/**
	 * Testing getName method.
	 */
	@Test
	public void testGetName() {
		assertEquals("project.pdf", myTestFile.getName());
	}
	
	/**
	 * Testing setName method.
	 */
	@Test
	public void testSetName() {
		myTestFile.setName("project.doc");
		assertEquals("project.doc", myTestFile.getName());
	}
	
	/**
	 * Testing toString method.
	 */
	@Test
	public void testToString() {
		assertEquals("project.pdf", myTestFile.toString());
	}
	

}
