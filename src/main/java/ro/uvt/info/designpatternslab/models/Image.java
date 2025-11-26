package ro.uvt.info.designpatternslab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image extends BaseElementEntity implements Element {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add elements to an Image.");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove elements from an Image.");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Cannot get elements from an Image.");
    }

    @Override
    public void print() {
        System.out.println("Image: " + name);
    }
}