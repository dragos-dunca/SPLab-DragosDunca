package ro.uvt.info.designpatternslab;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String title;
    private List<SubChapter> subChapters;

    public Chapter(String title) {
        this.title = title;
        this.subChapters = new ArrayList<>();
    }

    public void addSubChapter(SubChapter subChapter) {
        this.subChapters.add(subChapter);
    }

    public void print() {
        System.out.println("Chapter: " + title);
        for (SubChapter subChapter : subChapters) {
            subChapter.print();
        }
    }
}

