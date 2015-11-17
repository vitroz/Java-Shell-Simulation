package cmd;

import directory.DirectoryFileTree;
import files.Directory;
import files.File;
import files.TextFile;

public class Mv extends Command {
    
    /**
     * Overriding execute so mv moves files
     */
    @Override
    public void execute() {
        try {
            if (!this.run(getSource(), getTarget())) {
                System.out.println("File couldn't be found or doesn't exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
     * @return boolean
     * @throws java.lang.Exception
     */
    public boolean run (String source, String target) throws Exception {
        Directory sourceParent = getLastFileParent(source);
        Directory targetParent = getLastFileParent(target);

        String sourceFileName = getLastFile(source);
        String targetFileName = getLastFile(target);

        for (File f : DirectoryFileTree.getFilesOf(sourceParent)) {
            if (f.getName().equals(sourceFileName)) {
                for (File fTarget : DirectoryFileTree.getFilesOf(targetParent)) {
                    if (fTarget.getName().equals(targetFileName)) {
                        throw new Exception(targetFileName + " "
                                + "already exists");
                    }
                }

                f.setName(targetFileName);
                f.setParent(targetParent);
                if (f instanceof TextFile) {
                    targetParent.addFile((TextFile) f);
                }
                
                return true;
            }
        }

        return false;
    }

    /**
     * Overriding toString so it can be used with man describing mv command
     * @return String
     */
    @Override
    public String toString() {
        return "Move item to new directory."
                + " i.e mv + file + cwd/oldpath + newpath";
    }
    
}
