package ro.uvt.info.designpatternslab;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String text) {
        int consoleWidth = 80;
        int padding = Math.max(0, (consoleWidth - text.length()) / 2);
        System.out.println(" ".repeat(padding) + text);
    }
}

