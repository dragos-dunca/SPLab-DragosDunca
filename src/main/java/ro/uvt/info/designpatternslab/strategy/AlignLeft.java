package ro.uvt.info.designpatternslab.strategy;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(String text) {
        System.out.println(text);
    }
}

