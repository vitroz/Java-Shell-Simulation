/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.files;

import files.TextFile;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author ehkasper
 */
public class TextFileTest {
    

    /**
     * Test of setContent method, of class TextFile.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "foo";
        
        
        TextFile instance = new TextFile("foo", "Lorem");
        instance.setContent(content);
        assertEquals(instance.getContent(), content);
    }

    /**
     * Test of toString method, of class TextFile.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TextFile instance = new TextFile("foo", "content");
        String expResult = "content";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
