package ro.uvt.info.designpatternslab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Section extends BaseElementEntity implements Element {
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "section_id")
    private List<BaseElementEntity> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element element) {
        if (element instanceof BaseElementEntity) {
            children.add((BaseElementEntity) element);
        }
    }

    @Override
    public void remove(Element element) {
        if (element instanceof BaseElementEntity) {
            children.remove((BaseElementEntity) element);
        }
    }

    @Override
    public Element get(int index) {
        return (Element) children.get(index);
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (BaseElementEntity child : children) {
            if (child instanceof Element) {
                ((Element) child).print();
            }
        }
    }
}