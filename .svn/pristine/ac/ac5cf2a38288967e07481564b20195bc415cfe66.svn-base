/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.files;

import directory.DirectoryTree;
import files.Directory;
import files.TextFile;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author ehkasper
 */
public class DirectoryTest {
    Directory root;
    
    public DirectoryTest() {
    }
    
    @Before
    public void setUp() {
        root = mock(Directory.class);
        DirectoryTree.createDirectoryTree(root);
    }

    @After
    public void tearDown() {
        DirectoryTree.destroy();
    }

    
    @Test
    public void testContructors() {
        Directory root = new Directory();
        assertEquals(root.getName(), "root");
        assertEquals(root.getParent(), null);
        
        Directory m = mock(Directory.class);
        
        Directory regular = new Directory("foo", m);
        assertEquals(regular.getName(), "foo");
        assertEquals(regular.getParent(), m);
    }
    
    /**
     * Test of addFile method, of class Directory.
     */
    @Test
    public void testAddFile() {
        System.out.println("addFile");

        TextFile file1 = mock(TextFile.class);
        when(file1.getName()).thenReturn("file1");

        Directory instance = new Directory("dir1", root);
        instance.addFile(file1);
        assertEquals(1, instance.content.size());
        assertTrue(instance.content.contains(file1));
    }

        
    /**
     * Test of addFile method, of class Directory, when file already exists.
     */
    @Test
    public void testAddFileThatAlreadyExists() {
        System.out.println("addFileThatAlreadyExists");

        TextFile file1 = mock(TextFile.class);
        when(file1.getName()).thenReturn("file1");
        TextFile file2 = mock(TextFile.class);
        when(file2.getName()).thenReturn("file2");

        Directory instance = new Directory("dir1", root);
        
        instance.addFile(file1);
        
        assertEquals(1, instance.content.size());
        assertTrue(instance.content.contains(file1));

        instance.addFile(file2);
        
        assertEquals(2, instance.content.size());
        assertTrue(instance.content.contains(file2));

        instance.addFile(file1);
        
        assertEquals(2, instance.content.size());
    }

    /**
     * Test of removeFile method, of class Directory.
     */
    @Test
    public void testRemoveFile() {
        System.out.println("removeFile");
        
        TextFile file1 = mock(TextFile.class);
        when(file1.getName()).thenReturn("file1");
        
        TextFile file2 = mock(TextFile.class);
        when(file2.getName()).thenReturn("file2");
        
        TextFile file3 = mock(TextFile.class);
        when(file3.getName()).thenReturn("file3");

        TextFile f = file3;
        Directory instance = new Directory("dir1", root);
        instance.content.add(file1);
        instance.content.add(file2);
        instance.content.add(file3);
        
        assertEquals(3, instance.content.size());
        
        instance.removeFile(f);
        assertEquals(2, instance.content.size());
        assertFalse(instance.content.contains(file3));
    }

    /**
     * Test of removeFile method, of class Directory, when file does not exist.
     */
    @Test
    public void testRemoveFileThatDoesNotExist() {
        System.out.println("removeFile That doesnt exist");
        
        TextFile file1 = mock(TextFile.class);
        when(file1.getName()).thenReturn("file1");
        
        TextFile file2 = mock(TextFile.class);
        when(file2.getName()).thenReturn("file2");
        
        TextFile file3 = mock(TextFile.class);
        when(file3.getName()).thenReturn("file3");

        TextFile f = file3;
        Directory instance = new Directory("dir1", root);
        instance.content.add(file1);
        instance.content.add(file2);
        
        assertEquals(2, instance.content.size());
        assertFalse(instance.content.contains(file3));
        
        instance.removeFile(f);
        
        assertEquals(2, instance.content.size());
        assertFalse(instance.content.contains(file3));
    }

    /**
     * Test of findFile method, of class Directory.
     */
    @Test
    public void testFindFile() {
        System.out.println("findFile");
        
        TextFile file1 = mock(TextFile.class);
        when(file1.getName()).thenReturn("file1");
        
        TextFile file2 = mock(TextFile.class);
        when(file2.getName()).thenReturn("file2");
        
        TextFile file3 = mock(TextFile.class);
        when(file3.getName()).thenReturn("file3");
                
        Directory instance = new Directory("dir1", root);
        instance.content.add(file1);
        instance.content.add(file2);
        instance.content.add(file3);

        String filename = "file2";
        TextFile result = instance.findFile(filename);
        
        assertEquals(file2, result);
    }
    
}
