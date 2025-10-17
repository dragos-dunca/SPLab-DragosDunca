package ro.uvt.info.designpatternslab;

public class TableOfContents {
    private String content;

    public TableOfContents(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println("Table of Contents: " + content);
    }
}
