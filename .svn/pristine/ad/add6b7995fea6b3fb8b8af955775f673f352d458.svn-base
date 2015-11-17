package test.cmd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cmd.Cat;
import cmd.Cd;
import cmd.Pwd;
import directory.DirectoryFileTree;
import directory.DirectoryTree;
import driver.JShell;
import files.Directory;
import files.File;

import java.util.ArrayList;


public class CdTest {
    
	@Before
	public void initialize(){
		JShell jshell = new JShell();
	}
	
	@After
	public void destroy(){
		DirectoryTree.destroy();
	}

	@Test
	public void testCd() throws Exception {
		
            Cd cd = new Cd();
            Pwd pwd = new Pwd();

            pwd.run();
            cd.setParameters("directory1");
            cd.run();
            assertEquals(pwd.run(),"/root/directory1");	            
		
	}
	

	
	@Test
	public void testCdNoPath() throws Exception {
		
            Cd cd = new Cd();
            Pwd pwd = new Pwd();
            try{
            	pwd.run();
            	cd.setParameters("");
            	cd.run();
            }catch(Exception e){            	
            	String expected = "You should provide a path"; 
            	assertEquals(expected,e.getMessage());	
            }        
            	
	}	
	

	
	@Test
	public void cdBackToParentDirTest() throws Exception {
		
            Cd cd = new Cd();
            Pwd pwd = new Pwd();

            pwd.run();
            cd.setParameters("directory1");
            cd.run();
            assertEquals(pwd.run(),"/root/directory1");	
            cd.setParameters("..");
            cd.run();
            assertEquals(pwd.run(),"/root");
		
	}
	
    
    @Test
    public void testToString() {
        Cd instance = new Cd();
        String expResult = "The command cd changes to directory passed as"
                + " an argument. i.e cd + arg(dir)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
