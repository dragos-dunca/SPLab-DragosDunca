package ro.uvt.info.designpatternslab.models;

public interface Element {
    void add(Element element);
    void remove(Element element);
    Element get(int index);
    void print();
}


