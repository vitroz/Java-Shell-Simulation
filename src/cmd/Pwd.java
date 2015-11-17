package cmd;

import directory.DirectoryTree;

public class Pwd extends Command {
    
    /**
     * Overriding execute so pwd returns path
     */    
    @Override
    public void execute () {
        System.out.println(this.run());
    }
    
    /**
     * Runs command
     * @return String with path
     */
    public String run() {
        // Returns the path  
        return DirectoryTree.getCurrent().getPath();
    }//run()

    /**
     * Overriding toString so it can be used with man describing pwd command
     * @return String
     */    
    @Override
    public String toString() {
        return "Prints current working directory";
    }

}//class Pwd()
