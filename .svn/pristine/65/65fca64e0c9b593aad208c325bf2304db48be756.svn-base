package cmd;

import directory.DirectoryFileTree;
import files.Directory;
import files.File;
import files.TextFile;


/**
 * Copy the contents of a file to a new file, i.e cp + file1 + file2
 */
public class Cp extends Command {
	

    /**
     * Executing command
     * Overriding super class
     */
    @Override
    public void execute() {
        try {
            if (!this.run(getSource(), getTarget())) {
                System.out.println("File couldn't be found or doesn't exist");
            }
        } catch (Exception ex) {
            System.out.println("File(s) couldn't be found or doesn't exist");
        }
    }
    
    /**
     * Method responsible for returning the source file
     * @return String with path given
     */
    private String getSource() throws Exception {
        String[] path = getParameters().split(" ");
        if (path.length > 0)
            return path[0];
        
        throw new Exception("File couldn't be found");
    }

    /**
     * Method responsible for returning the target file
     * @return String with path given
     */
    private String getTarget() throws Exception {
        String[] path = getParameters().split(" ");
        if (path.length > 1)
            return path[1];
        
        throw new Exception("File couldn't be found");
    }

    /**
     * Given source and target copies file if exists
     * @param source
     * @param target
     * @return void
     */
    public boolean run (String source, String target) {
        TextFile file = null;

        Directory sourceParent = getLastFileParent(source);
        Directory targetParent = getLastFileParent(target);

        String sourceFileName = getLastFile(source);
        String targetFileName = getLastFile(target);

        for (File f : DirectoryFileTree.getFilesOf(sourceParent)) {
            if (f.getName().equals(sourceFileName)) {
                TextFile fileCopy = (TextFile) f;
                file = new TextFile(targetFileName, targetParent,
                        fileCopy.getContent());
                break;
            }
        }

        if (! (file instanceof TextFile)) {
            return false;
        }

        targetParent.addFile(file);
        
        return true;
    }

    /**
     * Overriding toString so it can be used with man describing cd command
     * @return String
     */
    @Override
    public String toString() {
        return "Copy the contents of a file to a new file."
                        + "i.e cp + file1 + file2";
    }
}