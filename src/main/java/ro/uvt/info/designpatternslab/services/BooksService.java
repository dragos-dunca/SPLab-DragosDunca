package ro.uvt.info.designpatternslab.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab.models.Book;

import java.util.*;

@Service
public class BooksService {

    private final Map<Integer, Book> db = new HashMap<>();
    private int nextId = 1;

    public List<Book> getAll() {
        return new ArrayList<>(db.values());
    }

    public Book get(int id) {
        return db.get(id);
    }

    public Book create(Book book) {
        book.setId(nextId++);
        db.put(book.getId(), book);
        return book;
    }

    public Book update(int id, Book book) {
        book.setId(id);
        db.put(id, book);
        return book;
    }

    public void delete(int id) {
        db.remove(id);
    }
}
