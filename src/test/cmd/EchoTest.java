package test.cmd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmd.Cat;
import cmd.Cp;
import cmd.Echo;
import directory.DirectoryTree;
import driver.JShell;
import files.Directory;
import files.TextFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoTest {

    @Test
    public void testEchoToANewFile() {
        try {
            Echo echo = new Echo();
            Directory directory = DirectoryTree.getCurrent();

            echo.setParameters("Test > file4");
            assertEquals("", echo.run());
        } catch (Exception ex) {
            Logger.getLogger(EchoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testToString() {
           System.out.println("toString");
           Echo instance = new Echo();
           String expResult = "Prints string to the shell, if an append"
                                   + " argument is passed, put the string into a new file"
                                   + " passed after append operator. i.e echo '123' > file1";
           String result = instance.toString();
           assertEquals(expResult, result);
       }

}
