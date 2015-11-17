package test.cmd;

import cmd.Cat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import directory.DirectoryTree;
import driver.JShell;
import files.Directory;
import files.TextFile;

//@RunWith(MockitoJUnitRunner.class)
public class CatTest {
	
	@Before
	public void initialize(){
		JShell jshell = new JShell();
	}
	
	@After
	public void destroy(){
		DirectoryTree.destroy();
	}


    @Test
    public void testCat(){
        Cat cat = new Cat();
        
        Directory directory = DirectoryTree.getCurrent();
        TextFile file1 = directory.findFile("file1");

        String expected = "File1 - Content";
        cat.setParameters("file1");
        cat.run();

        assertEquals(file1.getContent(),expected);


    }
    
    @Test
    public void testCatOnInnexistentFile(){
        Cat cat = new Cat();
        
        Directory directory = DirectoryTree.getCurrent();
        TextFile file4 = directory.findFile("file4");
        
        cat.setParameters("file4");
        cat.run();              

        assertEquals(cat.run(),null);


    }
	
	

    /**
     * Test of run method, of class Exit.
     */
//    @Test
//    public void testRun() {
//        Printer printer = Mockito.mock(Printer.class);
//        printer.when(printer.print());
//        
//        System.out.println("run");
//        Cat instance = new Cat();
//        String[] file = { "file1.txt" };
//        instance.run(file);
//       // assertTrue(Exit.exit);
//    }

    /**
     * Test of toString method, of class Exit.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cat instance = new Cat();
        String expResult = "The command cat display a file's content"
					+ " (i.e cat + arg(file)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
