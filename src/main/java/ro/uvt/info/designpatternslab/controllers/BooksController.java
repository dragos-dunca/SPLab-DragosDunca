package ro.uvt.info.designpatternslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.uvt.info.designpatternslab.models.Book;
import ro.uvt.info.designpatternslab.commands.*;
import ro.uvt.info.designpatternslab.services.BooksService;

import java.net.URI;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @GetMapping
    public Object getAll() {
        return new GetAllBooksCommand(booksService).execute();
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {
        return new GetBookByIdCommand(booksService, id).execute();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book created = (Book) new CreateBookCommand(booksService, book).execute();
        return ResponseEntity.created(URI.create("/books/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id, @RequestBody Book book) {
        return new UpdateBookCommand(booksService, id, book).execute();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        new DeleteBookCommand(booksService, id).execute();
        return ResponseEntity.noContent().build();
    }
}

