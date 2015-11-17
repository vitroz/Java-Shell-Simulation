package cmd;



public class Exit extends Command {	
    
    public static boolean exit = false;
    
    /**
     * Executing command
     * @return String
     */
    @Override
    public void execute () {
        exit = true;
    }   
    
    /**
     * Overriding toString to describe what exit does
     * @return String
     */
    @Override
    public String toString() {
        return "Terminates the shell.";
    }

}
