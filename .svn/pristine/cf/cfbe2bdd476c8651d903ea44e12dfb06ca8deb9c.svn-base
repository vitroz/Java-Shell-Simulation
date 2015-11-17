package cmd;

import directory.DirectoryTree;
import files.Directory;

/**
 * Class is extended by all commands
 */
abstract public class Command {
	
    public static String dirOnStack;
    private String parameters;
    protected boolean outFile = false;
    
    /**
     * Setting parameters
     * @param p 
     */
    public void setParameters(String p) {
        parameters = p;
    }

    /**
     * Getting parameters
     * @return parameters
     */
    public String getParameters() {
        return parameters == null ? "" : parameters;
    }

    /**
     * This method should be overridden by subclasses
     */
    public void execute() {
        System.out.println("You should implement this method in the "
                + "subclasses");
    }
    
    /**
     * Returning the operator given
     * @return String
     */
    public String operator () {
        String p = getParameters();
        
        if (p.contains(">") || p.contains(">>")) {
            int operatorIndex = p.indexOf(">>");
            if (operatorIndex > -1) {
                return ">>";
            }

            return ">";
        }
        
        return null;
    }

    public String outPath (String operator) {
        if (outFile) {
            String p = getParameters();
            String path = p.substring(p.lastIndexOf(operator) + 
                    operator.length());
            return path.trim();
        }
        
        return null;
    }

    
    /**
     * Getting the file name from the last file in path
     * @param path
     * @return String - file name
     */
    protected String getLastFile(String path) {
        if (path.lastIndexOf("/") > -1) {
            path = path.substring(path.lastIndexOf("/") + 1);
        }
        
        return path;
    }

    /**
     * Getting the last file name parent
     * @param path
     * @return String - file name
     */
    protected Directory getLastFileParent(String path) {
        Directory parent = DirectoryTree.getCurrent();
        
        if (path.lastIndexOf("/") > -1) {
            path = path.substring(0, path.lastIndexOf("/"));
            return DirectoryTree.getDirectory(path);
        }

        return parent;
    }

}
