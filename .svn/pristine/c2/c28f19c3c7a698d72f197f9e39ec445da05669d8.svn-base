package cmd;

import files.Directory;
import files.TextFile;


public class Cat extends Command {
    
    /**
     * Overriding execute so cat shows file content
     */
    @Override
    public void execute () {
        if (getParameters().equals("")) {
            System.out.println("File not given");
            return;
        }
        
        TextFile textFile = this.run();
        if (textFile instanceof TextFile) {
            System.out.println(textFile.getContent());
        } else {
            System.out.println("File couldn't be found");
        }
    }


    /**
     * Returning TextFile so it's possible to read its content
     * @return TextFile
     */
    public TextFile run () {
        String fileTarget = getLastFile(getParameters());
        Directory parentDirectory = getLastFileParent(getParameters());
        
        TextFile textFile = parentDirectory.findFile(fileTarget);
        
        if (textFile instanceof TextFile) {
            return textFile;
        }
        
        return null;
    }


    /**
     * Overriding toString so it can be used with man describing cat command
     * @return String - description
     */
    @Override
    public  String toString() {
        return "The command cat display a file's content"
                    + " (i.e cat + arg(file)";
    }    
}
