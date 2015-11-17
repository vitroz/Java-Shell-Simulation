package cmd;

import directory.DirectoryFileTree;
import directory.DirectoryTree;
import files.Directory;

	public class Pushd extends Command{
		
		/**
	     * Overriding execute so pushd prints a string if it evaluates to false.
	     */
	 @Override
	    public void execute () {
		 	if (!this.run()) {
		     System.out.println("Directory couldn't be found or doesn't exist");
		       }
	System.out.println("On directory: " + DirectoryTree.getCurrent().getPath());
	    }	
	 /**
	     * Returning the operator given
	     * @return Cwd new path with the parameters that were passed	     
	 */
	    
	    public boolean run() {
	    	 String directoryTarget = getDirectoryTarget();
	         Directory parentDirectory = getParentDirectory();
	         
	         Command.dirOnStack = DirectoryTree.getCurrent().getPath();
	         Command.dirOnStack = dirOnStack.replace("/root/", "");	         
	         
	         return DirectoryTree.setPath(this.getParameters());	              
	         
	    }
	    /**
	     * Returning the directory parent from the path given.
	     * @return directory     
	 */
	    
	 	private Directory getParentDirectory() {
	        String path = getParameters();
	        if (path.lastIndexOf("/") > -1) {
	            path = path.substring(0, path.lastIndexOf("/"));
	            return DirectoryTree.getDirectory(path);
	        }
	        
	        return DirectoryTree.getCurrent();
	    }
	 	
	 	 /**
	     * Returning the directory from the path given.
	     * @return directory     
	 */

	    private String getDirectoryTarget() {
	        String path = getParameters();
	        if (path.lastIndexOf("/") > -1) {
	            path = path.substring(path.lastIndexOf("/") + 1);
	            return path;
	        }
	        
	        return path;
	    }
	    
	    @Override
	    public String toString() {
	        return "Pushs a directory path to the stack.";
	    }

}
