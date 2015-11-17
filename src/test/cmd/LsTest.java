package test.cmd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmd.Command;
import cmd.Ls;
import directory.DirectoryTree;
import driver.JShell;
import files.Directory;
import files.TextFile;

import java.util.ArrayList;


public class LsTest {

	/*
	@Before
	public void initialize() {
		
		JShell jshell = new JShell();
		jshell.init();
	    //init, creates initial setup, which right now is a root directory
		// a directory called directory1 and 3 files inside directory1.
	    }
	

	@Test
	public void testRunStringArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitialLs() throws Exception {
		fail("Not yet implemented");		
	}*/
       /* 
    @Test
    public void testListOn() {
        ArrayList<Directory> dirs = new ArrayList<>();

        Directory dir1 = mock(Directory.class);
        when(dir1.getName()).thenReturn("dir1");
        when(dir1.getParent()).thenReturn(root);
        dirs.add(dir1);
        
        DirectoryTree d = mock(DirectoryTree.class);
        when(d.getFoldersOn(mock(Directory.class))).thenReturn(dirs);
            
        Ls ls = new Ls(d);
        ls.listOn(root);
        verify(spyOnPrint).print("");
    } */
        
    @Test
    public void testToString () {
        Ls ls = new Ls();
        String expected = "Lists files/directories in the current"
                            + " working directory";
        assertEquals(expected, ls.toString());
    }

}
