package test.cmd;

import static org.junit.Assert.*;

import org.junit.Test;

import cmd.Pwd;
import driver.JShell;

public class PwdTest {	
	
	 @Test
	    public void testPwd() {
	        Pwd instance = new Pwd();
	        JShell jshell = new JShell();
	       
	        //Given my initial directory should be root
	        //as it was initialized by the Jshell object
	        String expResult = "/root";
	        String result = instance.run();
	        
	        assertEquals(expResult, result);
	    }


    @Test
    public void testToString() {
        Pwd instance = new Pwd();
        String expResult = "Prints current working directory";
        String result = instance.toString();
        
        assertEquals(expResult, result);
    }

	

}
