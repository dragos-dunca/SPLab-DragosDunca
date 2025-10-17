package ro.uvt.info.designpatternslab;

public class Image implements Element{
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add elements to a Image.");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove elements from a Image.");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Cannot get elements from a Image.");
    }

    @Override
    public void print() {
        System.out.println("Image: " + name);
    }
}

