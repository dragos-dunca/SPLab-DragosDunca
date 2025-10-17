package ro.uvt.info.designpatternslab;

public class Paragraph implements Element{
    private String text;
    private AlignStrategy strategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add elements to a Paragraph.");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove elements from a Paragraph.");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Cannot get elements from a Paragraph.");
    }

    @Override
    public void print() {
        if (strategy != null) {
            strategy.render(text);
        } else {
            System.out.println(text);
        }
    }
}

