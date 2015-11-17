package test.driver;

import cmd.Ls;
import driver.Interpreter;
import exception.CommandBlankException;
import exception.CommandExistenceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class InterpreterTest {

    /**
     * Test of extractCommand with no parameters
     */
    @Test
    public void testConstructor() {
        try {
            String input = "ls -r ../foo/dir";
            String expectedParameters = "-r ../foo/dir";
            Interpreter i = new Interpreter(input);
            
            assertTrue(i.getCmd() instanceof Ls);
            assertEquals(expectedParameters, i.getCmd().getParameters());
            
        } catch (InstantiationException ex) {
            Logger.getLogger(InterpreterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterpreterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InterpreterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommandBlankException ex) {
            Logger.getLogger(InterpreterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommandExistenceException ex) {
            Logger.getLogger(InterpreterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Test of extractCommand with no parameters
     */
    @Test
    public void testLsShouldReturnLs() {
        String command = "ls";
        String expResult = "ls";
        String result = Interpreter.extractCommand(command);
        assertEquals(expResult, result);
    }

    /**
     * Test of extractCommand without parameters
     */
    @Test
    public void testExtractCommandWithoutParametersShouldReturnCommand() {
        String command = "ls";
        String expResult = "ls";
        String result = Interpreter.extractCommand(command);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of extractCommand with parameters
     */
    @Test
    public void testExtractCommandWithParametersShouldReturnCommand() {
        String input = "ls -r ../../foo";
        String expResult = "ls";
        String result = Interpreter.extractCommand(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of extractCommand with badly formatted parameters
     */
    @Test
    public void testBadlyFormattedParameters () {
        String input = "ls    -r ../../foo   ";
        String expResult = "ls";
        String result = Interpreter.extractCommand(input);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of extractParameters with parameters
     */
    @Test
    public void testExtractParametersWithParametersShouldReturnParameters() {
        String input = "ls -r ../../foo";
        String expResult = "-r ../../foo";

        String result = Interpreter.extractParameters("ls", input);

        assertEquals(expResult, result);
    }
        
    /**
     * Test of extractParameters with parameters
     */
    @Test
    public void testExtractParametersWithoutParametersShouldReturnNull() {
        String input = "ls";
        String expResult = null;

        String result = Interpreter.extractParameters("ls", input);

        assertEquals(expResult, result);

        input = "ls     ";

        result = Interpreter.extractParameters("ls", input);

        assertEquals(expResult, result);
}

    
        
    /**
     * Test of extractParameters with parameters badly formatted
     */
    @Test
    public void testBadlyFormattedParametersShouldReturnParameters () {
        String input = "ls    -r    ./";
        String expResult = "-r    ./";

        String result = Interpreter.extractParameters("ls", input);

        assertEquals(expResult, result);
    }
}
