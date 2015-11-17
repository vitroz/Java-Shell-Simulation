package test.cmd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmd.Cat;
import cmd.Cp;
import directory.DirectoryTree;
import driver.JShell;
import files.Directory;
import files.TextFile;

public class CpTest {
	

	@Test
	public void testCp() {
		Cp cp = new Cp();
		Cat cat = new Cat();
		
		Directory directory = DirectoryTree.getCurrent();
		TextFile file1 = directory.findFile("file1");
		
		cp.run("file1", "file4");	
		
		
		TextFile file4 = directory.findFile("file4");		
		assertEquals(file1.getContent(),file4.getContent());		
		
	}
	
	 @Test
	    public void testToString() {
	        System.out.println("toString");
	        Cp instance = new Cp();
	        String expResult = "Copy the contents of a file to a new file."
					+ "i.e cp + file1 + file2";
	        String result = instance.toString();
	        assertEquals(expResult, result);
	    }

}
