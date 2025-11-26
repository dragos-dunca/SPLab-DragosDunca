package ro.uvt.info.designpatternslab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.uvt.info.designpatternslab.models.*;
import ro.uvt.info.designpatternslab.persistence.CrudRepository;
import ro.uvt.info.designpatternslab.strategy.AlignCenter;
import ro.uvt.info.designpatternslab.strategy.AlignLeft;
import ro.uvt.info.designpatternslab.strategy.AlignRight;

import java.util.Optional;

@SpringBootApplication
public class DesignPatternsLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsLabApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CrudRepository<Book, Integer> bookRepository) {
        return (args) -> {
            // Demo data
            System.out.println("=== Testing JPA Implementation ===");

            // Create a book
            Book book = new Book("Design Patterns Guide");

            // Add authors using the getter and ArrayList methods
            Author author = new Author("John Doe");
            book.getAuthors().add(author);

            // Add some elements
            Section chapter1 = new Section("Chapter 1");

            Paragraph p1 = new Paragraph("First paragraph");
            Paragraph p2 = new Paragraph("Second paragraph");
            Image img1 = new Image("diagram.png");

            // Add elements to section using the existing add method
            chapter1.add(p1);
            chapter1.add(p2);
            chapter1.add(img1);

            // Add section to book using the getter and ArrayList methods
            book.getElements().add(chapter1);

            // Save to database
            Book savedBook = bookRepository.save(book);
            System.out.println("Saved book with ID: " + savedBook.getId());

            // Retrieve from database
            Optional<Book> retrievedBook = bookRepository.findById(savedBook.getId());
            retrievedBook.ifPresent(b -> {
                System.out.println("Retrieved book: " + b.getTitle());
                System.out.println("Authors: " + b.getAuthors().size());
                System.out.println("Elements: " + b.getElements().size());
            });

            // Test alignment strategies
            System.out.println("\n=== Testing Alignment Strategies ===");
            p1.setAlignStrategy(new AlignCenter());
            p2.setAlignStrategy(new AlignRight());

            p1.print();
            p2.print();
        };
    }
}