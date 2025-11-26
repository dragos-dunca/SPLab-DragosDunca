package ro.uvt.info.designpatternslab.commands;

import ro.uvt.info.designpatternslab.services.BooksService;

public class GetAllBooksCommand implements Command {
    private final BooksService service;

    public GetAllBooksCommand(BooksService service) {
        this.service = service;
    }

    @Override
    public Object execute() {
        return service.getAll();
    }
}

