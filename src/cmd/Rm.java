
package cmd;

import directory.DirectoryFileTree;
import directory.DirectoryTree;
import files.Directory;
import files.File;
import files.TextFile;
import java.util.Scanner;

public class Rm extends Command {
    
    private boolean force = false;

    /**
     * Overriding execute so rm removes file
     */
    @Override
    public void execute() {
        try {
            if (! this.run()) {
                System.out.println("File doesn't exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    /**
     * Returns path and sets force to true if argument is given
     * @return String
     */
    private String getPath() {
        String parameters = getParameters();
        String path = parameters;
        
        if (parameters.contains("-f")) {
            path = path.replaceAll("-f", "").trim();
            force = true;
        }
        
        return path;
    }
    
    /**
     * Runs command and returns true if file was deleted
     * @return boolean
     * @throws java.lang.Exception
     */
    public boolean run () throws Exception {
        String path = getPath();
        File file = DirectoryTree.getFile(path);
        
        
        if (file == null) {
            throw new Exception("File doesn't exist");
        }
        
        if (! force) {
            Scanner sc = new Scanner(System.in);
            String input;
            System.out.print("\n");
            System.out.print("Are you sure you want to delete "
                    + "this file (y/n)? ");
            input = sc.nextLine().trim();
            
            if (! input.equals("y")) {
                return true;
            }
        }
        
        if (file instanceof Directory)
            return DirectoryFileTree.removeDirectory((Directory) file);
        
        return file.getParent().removeFile((TextFile) file);
        
    }
    
    /**
     * Overriding toString so it can be used with man describing rm command
     * @return String
     */    
    @Override
    public String toString() {
        return "Removing given directory"
                + "\n[-f] to force delete";
    }    
    
}