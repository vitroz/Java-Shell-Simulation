/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.directory;

import directory.DirectoryFileTree;
import files.Directory;
import files.File;
import files.TextFile;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author ehkasper
 */
public class DirectoryFileTreeTest {
    
    public DirectoryFileTreeTest() {
    }

    @Test
    public void testAddExistentDirectory() {
        Directory root = mock(Directory.class);
        when(root.getParent()).thenReturn(null);
        when(root.getName()).thenReturn("root");
        
        Directory dir1 = mock(Directory.class);
        when(dir1.getParent()).thenReturn(root);
        when(dir1.getName()).thenReturn("dir1");
        
        ArrayList<File> files = new ArrayList<>();
        files.add(dir1);
        
        DirectoryFileTree d = mock(DirectoryFileTree.class);
        when(DirectoryFileTree.getFilesOf(root)).thenReturn(files);
        when(DirectoryFileTree.addDirectory(dir1)).thenCallRealMethod();
        
        boolean testAddDirectory = DirectoryFileTree.addDirectory(dir1);
        assertFalse(testAddDirectory);

    }

/*
    
    @Test
    public void testGetFiles() {
        Directory root = mock(Directory.class);
        when(root.getParent()).thenReturn(null);
        when(root.getName()).thenReturn("root");
        when(root.getContent()).thenReturn( new ArrayList<TextFile>() );
        
        Directory dir1 = mock(Directory.class);
        when(dir1.getName()).thenReturn("dir1");
        when(dir1.getParent()).thenReturn(root);

        ArrayList<Directory> tree = new ArrayList<>();
        tree.add(root);
        tree.add(dir1);
        
        DirectoryFileTree d = mock(DirectoryFileTree.class);
        when(d.getTree()).thenReturn(tree);
        when(d.getFilesOf(root)).thenCallRealMethod();
        
        ArrayList<File> expected = new ArrayList<>();
        expected.add(dir1);
        
        ArrayList<File> filesOf = d.getFilesOf(root);

        assertEquals(expected, filesOf);
    }
*/    
}
