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
    public ResponseEntity<?> getAll() {
        try {
            Object result = new GetAllBooksCommand(booksService).execute();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error retrieving books: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            Object result = new GetBookByIdCommand(booksService, id).execute();
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error retrieving book: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book book) {
        try {
            Book created = (Book) new CreateBookCommand(booksService, book).execute();
            return ResponseEntity.created(URI.create("/books/" + created.getId())).body(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating book: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Book book) {
        try {
            Object result = new UpdateBookCommand(booksService, id, book).execute();
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating book: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            boolean deleted = booksService.delete(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleting book: " + e.getMessage());
        }
    }
}