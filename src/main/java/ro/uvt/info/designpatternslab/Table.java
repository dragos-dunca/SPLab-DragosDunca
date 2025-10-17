package ro.uvt.info.designpatternslab;

public class Table implements Element{
    private String title;

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add elements to a Table.");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove elements from a Table.");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Cannot get elements from a Table.");
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }
}

