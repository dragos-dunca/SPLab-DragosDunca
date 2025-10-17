package ro.uvt.info.designpatternslab;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private List<Element> contents;

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.contents = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        contents.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        for (Element element : contents) {
            element.print();
        }
    }
}
