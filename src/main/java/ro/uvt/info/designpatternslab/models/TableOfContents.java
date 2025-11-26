package ro.uvt.info.designpatternslab.models;

public class TableOfContents {
    private String content;

    public TableOfContents(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println("Table of Contents: " + content);
    }
}
