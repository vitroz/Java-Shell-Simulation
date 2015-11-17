package test.cmd;

import cmd.Exit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ehkasper
 */
public class ExitTest {
        

    /**
     * Test of run method, of class Exit.
     */
    @Test
    public void testRun() {
        Exit instance = new Exit();
        instance.execute();
        assertTrue(Exit.exit);
    }

    /**
     * Test of toString method, of class Exit.
     */
    @Test
    public void testToString() {
        Exit instance = new Exit();
        String expResult = "Terminates the shell.";
        String result = instance.toString();
        
        assertEquals(expResult, result);
    }
    
    
    
}
