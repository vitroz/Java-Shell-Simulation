package files;

import directory.DirectoryTree;

public class TextFile extends File {

    private String content;

    public TextFile(String name, Directory parent, String content) {
        super(name, parent);
        this.content = content;
    }

    public TextFile(String name, String content) {
        this(name, DirectoryTree.getCurrent(), content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString () {
        return this.content;
    }
}
