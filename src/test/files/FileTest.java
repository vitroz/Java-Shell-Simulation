/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.files;

import files.Directory;
import files.File;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author ehkasper
 */
public class FileTest {

    /**
     * Test of getName method, of class File.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Directory parent = mock(Directory.class);
        
        File instance = new File("foo", parent);
        String expResult = "foo";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class File.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String first = "foo";
        String second = "new_foo";
        
        Directory parent = mock(Directory.class);        
        File instance = new File(first, parent);
        assertEquals(first, instance.getName());

        instance.setName(second);

        assertEquals(second, instance.getName());
    }

    /**
     * Test of getParent method, of class File.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");

        Directory p = mock(Directory.class);
        p.setName("fooParent");
        
        File instance = new File("foo", p);

        Directory result = instance.getParent();
        assertEquals("Mocked parent and getParent must be equal", p, 
                result);
    }

    /**
     * Test of setParent method, of class File.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Directory p = mock(Directory.class);
        File instance = new File("foo", p);
        instance.setParent(p);

        assertEquals(instance.getParent(), p);
    }

    /**
     * Test of getPath method, of class File.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        
        Directory p = mock(Directory.class);
        when(p.getParentPath()).thenReturn("");
        when(p.getName()).thenReturn("foo");
        
        File instance = new File("file", p);
                
        assertEquals("/foo/file", instance.getPath());
        
    }

    /**
     * Test of getParentPath method, of class File.
     */
    @Test
    public void testGetParentPath() {
        System.out.println("getParentPath");

        Directory pParent = mock(Directory.class);
        when(pParent.getParentPath()).thenReturn("/");
        when(pParent.getName()).thenReturn("parent");

        Directory pChild = mock(Directory.class);
        when(pChild.getParentPath()).thenReturn("parent");
        when(pChild.getName()).thenReturn("child");

        File instance = new File("file", pChild);
        String expResult = "parent/child";
        String result = instance.getParentPath();
        assertEquals(expResult, result);
    }
    
}
