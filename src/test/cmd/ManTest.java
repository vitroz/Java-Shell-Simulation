package test.cmd;

import cmd.Cat;
import org.junit.Test;

import cmd.Man;
import static org.junit.Assert.assertEquals;


public class ManTest {
	

    @Test
    public void testMan() {
        try {
            Cat cat = new Cat();
            
            Man man = new Man();
            man.setParameters("cat");
            
            assertEquals(cat.toString(), man.run());
        } catch (Exception ex) {
            System.out.println("Error testMan: " + ex);
        }
    }

    @Test
    public void testToString() {
        Man m = new Man();
        String expected = "Print documentation for CMD. Specify a command as"
				+ "an argument i.e: man + cmd";
        assertEquals(expected, m.toString());
    }
}
