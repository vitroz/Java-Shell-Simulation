package files;

import java.util.ArrayList;

public class Directory extends File {

    public ArrayList<TextFile> content = new ArrayList<>();

    public Directory() {
        super("root", null);
    }//directory()

    public Directory(String name, Directory parent) {
        super(name, parent);
    }//directory(name,parent)

    public void addFile(TextFile f) {
        if (findFile(f.getName()) == null) {
            content.add(f);
        } else {
            System.out.println("File already exists");
        }
    }
        

    public boolean removeFile(TextFile f) {
        TextFile toBeRemoved = findFile(f.getName());
        if (toBeRemoved != null) {
            return content.remove(toBeRemoved);
        }
        
        return false;
    }
    

    public ArrayList<TextFile> getContent () {
        return content;
    }
  
    public TextFile findFile(String filename) { 	
    	
        for (TextFile textfile : content) {
            if (textfile.getName().equals(filename)) {
                return textfile;
            }          
        }        
        return null;
    }
    
	
        
}//class directory
