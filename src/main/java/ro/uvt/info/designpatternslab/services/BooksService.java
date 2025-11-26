package ro.uvt.info.designpatternslab.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab.models.Book;
import ro.uvt.info.designpatternslab.persistence.CrudRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final CrudRepository<Book, Integer> booksRepository;

    public List<Book> getAll() {
        return booksRepository.findAll();
    }

    public Book get(int id) {
        Optional<Book> book = booksRepository.findById(id);
        return book.orElse(null);
    }

    public Book create(Book book) {
        return booksRepository.save(book);
    }

    public Book update(int id, Book book) {
        if (booksRepository.findById(id).isPresent()) {
            book.setId(id);
            return booksRepository.save(book);
        }
        return null;
    }

    public boolean delete(int id) {
        if (booksRepository.findById(id).isPresent()) {
            booksRepository.deleteById(id);
            return true;
        }
        return false;
    }
}