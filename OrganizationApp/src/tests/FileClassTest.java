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
	 * Initializing test fixture. 
	 * @author Tatiana Linardopoulou
	 */
	@Before
	public void setUp() {
		myTestFile = new FileClass(file);
	}

	/**
	 * Testing constructor for FileClass.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testFileClass() {
		assertEquals(file, myTestFile.getFile());
		assertEquals("project.pdf", myTestFile.getName());
	}
	
	/**
	 * Testing getFile method.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testGetFile() {
		assertEquals(file, myTestFile.getFile());
	}

	/**
	 * Testing getName method.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testGetName() {
		assertEquals("project.pdf", myTestFile.getName());
	}
	
	/**
	 * Testing setName method.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testSetName() {
		myTestFile.setName("project.doc");
		assertEquals("project.doc", myTestFile.getName());
	}
	
	/**
	 * Testing toString method.
	 * @author Tatiana Linardopoulou
	 */
	@Test
	public void testToString() {
		assertEquals("project.pdf", myTestFile.toString());
	}
	

}
