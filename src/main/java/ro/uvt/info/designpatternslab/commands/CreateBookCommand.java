package ro.uvt.info.designpatternslab.commands;

import ro.uvt.info.designpatternslab.models.Book;
import ro.uvt.info.designpatternslab.services.BooksService;

public class CreateBookCommand implements Command {
    private final BooksService service;
    private final Book book;

    public CreateBookCommand(BooksService service, Book book) {
        this.service = service;
        this.book = book;
    }

    @Override
    public Object execute() {
        return service.create(book);
    }
}

