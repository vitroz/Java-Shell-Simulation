package cmd;

/**
 * Print documentation for CMD. Specify a command as an argument i.e: man + cmd
 */
public class Man extends Command {

    /**
     * Executing command
     * Overriding super class
     */	
    @Override
    public void execute() {		
        try {
            System.out.println(this.run());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Command not found");
        }
    }
    
    /**
     * Runs get command man
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public String run() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        String command = getParameters();

        // 'command' needs its first letter capitalized for the object
        // to be instantiated, and call its method aftewards.
     command = command.substring(0, 1).toUpperCase() + command.substring(1);

        Class<?> c = Class.forName("cmd." + command);
        Command cmd = (Command) c.newInstance();

        return cmd.toString();

    }

    
    /**
     * Overriding toString so it can be used with man describing man command
     * @return String
     */
    @Override
    public String toString() {
        return "Print documentation for CMD. Specify a command as"
                        + "an argument i.e: man + cmd";
    }

}