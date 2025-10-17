package ro.uvt.info.designpatternslab;

public interface Element {
    void add(Element element);
    void remove(Element element);
    Element get(int index);
    void print();
}


