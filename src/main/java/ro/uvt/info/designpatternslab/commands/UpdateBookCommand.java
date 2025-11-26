package ro.uvt.info.designpatternslab.commands;

import ro.uvt.info.designpatternslab.models.Book;
import ro.uvt.info.designpatternslab.services.BooksService;

public class UpdateBookCommand implements Command {
    private final BooksService service;
    private final int id;
    private final Book book;

    public UpdateBookCommand(BooksService service, int id, Book book) {
        this.service = service;
        this.id = id;
        this.book = book;
    }

    @Override
    public Object execute() {
        return service.update(id, book);
    }
}