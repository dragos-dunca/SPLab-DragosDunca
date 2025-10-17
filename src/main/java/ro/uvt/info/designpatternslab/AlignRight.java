package ro.uvt.info.designpatternslab;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(String text) {
        int consoleWidth = 80;
        int padding = Math.max(0, consoleWidth - text.length());
        System.out.println(" ".repeat(padding) + text);
    }
}

