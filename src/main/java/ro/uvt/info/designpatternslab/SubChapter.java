package ro.uvt.info.designpatternslab;

import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String title;
    private List<Element> elements;

    public SubChapter(String title) {
        this.title = title;
        this.elements = new ArrayList<>();
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }

    public void print() {
        System.out.println("SubChapter: " + title);
        for (Element element : elements) {
            element.print();
        }
    }
}
