package cmd;

import directory.DirectoryTree;

/**
 * The command cd changes to directory passed as an argument. i.e cd + arg(dir)
 */
public class Cd extends Command {

    /**
     * Overriding execute so cd changes directory
     */
    @Override
    public void execute () {
        try {
            if (!this.run()) {
                System.out.println("Directory couldn't be found or doesn't exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
		
    /**
     * Runs cd command and returns exception if no directory is provided
     * or true/false whether directory was found or not.
     * @return Boolean
     * @throws Exception 
     */
    public boolean run () throws Exception {
        if (getParameters().equals("")) {
            throw new Exception("You should provide a path");
        }
    	//sets the path; traverses if exists, otherwise prints message
        return DirectoryTree.setPath(getParameters());
    }   
    
    /**
     * Overriding toString so it can be used with man describing cd command
     * @return 
     */
    @Override
    public String toString() {
        return "The command cd changes to directory passed as"
                + " an argument. i.e cd + arg(dir)";
    }

}
