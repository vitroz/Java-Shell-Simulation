package files;

public class File {

    protected String name;
    protected Directory parent;
    
    public File(String name, Directory parent) {
        this.name = name;    
        this.parent = parent;    
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Directory getParent() {
        return this.parent;
    }

    public void setParent(Directory p) {
        this.parent = p;
    }

    public String getPath() {
        return getParentPath() + "/" + name;
    }

    public String getParentPath() {
        if (parent == null) {
            return "";
        }
        
        //recursive parentPath call
        return parent.getParentPath() + "/" + parent.getName();
    }    
}
