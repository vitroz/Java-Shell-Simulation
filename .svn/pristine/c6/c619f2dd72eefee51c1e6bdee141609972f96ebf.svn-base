package cmd;

import files.Directory;
import files.TextFile;

/**
 * Prints string to the shell, if an append argument is passed, 
 * put the string into a new file
 * passed after append operator. i.e echo '123' > file1
 */
public class Echo extends Command {
    
    /**
     * Overriding execute so echo inserts string into new file
     */
    @Override
    public void execute () {
        try {
            String r = this.run();
            if (r != null) {
                System.out.println(r);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Returning the operator given
     * @return String with content or null if there's and output filetext
     * @throws java.lang.Exception
     */
    public String run () throws Exception {
        String content = getContent();
        String operator = getOperator();
        
        if (! outFile) {
            return content;
        }
        
        String pathFilename = outPath(operator);        
        Directory parent = getLastFileParent(pathFilename);        
        String filename = getLastFile(pathFilename);
        
        
        if (parent == null) {
            throw new Exception("Path not found");
        }

        if (pathFilename.equals("")) {
            throw new Exception("You have to provide an out file");
        }

        TextFile newfile = new TextFile(filename, parent, content);
        parent.addFile(newfile);

        return null;
    }
 
    /**
     * Returning the content provided
     * @return String
     */
    private String getContent() {
        String parameters = getParameters();
        
        int firstQuote = parameters.indexOf("\"");
        int lastQuote = parameters.lastIndexOf("\"");
        
        if (firstQuote > -1 && lastQuote > -1) {
            return parameters.substring(firstQuote + 1, lastQuote);
        }

        return parameters.split(" ")[0];
    }

    /**
     * Returning the operator given
     * @return String
     */
    private String getOperator() throws Exception {
        String parameters = getParameters();
        String content = getContent();
        
        parameters = parameters.replaceAll(content, "");
        parameters = parameters.replaceAll("\"\"", "");
        
        if (! parameters.equals("")) {
            if (parameters.contains(">") || parameters.contains(">>")) {
                outFile = true;

                int operatorIndex = parameters.indexOf(">>");
                if (operatorIndex > -1) {
                    return ">>";
                }

                return ">";
            }

            throw new Exception("No matches found for the operator");
        }
        
        outFile = false;
        return null;
        
    }

    /**
     * Getting the file name from whole path
     * @param path
     * @return String - file name
     */
    protected String getFileName(String path) {
        if (path.lastIndexOf("/") > -1) {
            path = path.substring(path.lastIndexOf("/") + 1);
        }
        
        return path;
    }


    
    /**
     * Overriding toString so it can be used with man describing mv command
     * @return String
     */
    @Override
    public String toString() {
        return "Prints string to the shell, if an append"
            + " argument is passed, put the string into a new file"
            + " passed after append operator. i.e echo '123' > file1";
    }   
}
