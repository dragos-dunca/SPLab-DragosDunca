package ro.uvt.info.designpatternslab.commands;

import ro.uvt.info.designpatternslab.services.BooksService;

public class GetBookByIdCommand implements Command {
    private final BooksService service;
    private final int id;

    public GetBookByIdCommand(BooksService service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public Object execute() {
        return service.get(id);
    }
}