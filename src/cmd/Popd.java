package cmd;

import directory.DirectoryTree;
import files.Directory;

public class Popd extends Command {
	
	/**
     * Overriding execute so popd prints a string if it evaluates to false.
     */	
	 public void execute () {
		 if (!this.run()) {
	        System.out.println("Directory couldn't be found or doesn't exist");
	        }
	    }	
	 /**
	     * Returning the operator given
	     * @return Cwd new path with the path that was previously saved into 
	     * stack.  
	 */	    
	 
	    
	    public boolean run() {
	    	
	    if(Command.dirOnStack == null){
	    	System.out.println("Directory stack empty");
	    	return false;
	    }else{	    	
	    	System.out.println(Command.dirOnStack);
	    	return DirectoryTree.setPath(Command.dirOnStack); 
	         }
	    } 	
	    
	    @Override
	    public String toString() {
	        return "Change directory to the directory that was previously"
	        		+ "put on the stack with popd.";
	    }

}
