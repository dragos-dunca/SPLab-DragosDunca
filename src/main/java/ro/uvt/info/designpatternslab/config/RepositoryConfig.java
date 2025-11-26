package ro.uvt.info.designpatternslab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.uvt.info.designpatternslab.persistence.*;
import ro.uvt.info.designpatternslab.models.Book;
import ro.uvt.info.designpatternslab.models.Author;
import ro.uvt.info.designpatternslab.models.BaseElementEntity;

@Configuration
public class RepositoryConfig {

    @Bean
    public CrudRepository<Book, Integer> bookCrudRepository(BooksRepository booksRepository) {
        return new JpaAdapter<>(booksRepository);
    }

    @Bean
    public CrudRepository<Author, Integer> authorCrudRepository(AuthorsRepository authorsRepository) {
        return new JpaAdapter<>(authorsRepository);
    }

    @Bean
    public CrudRepository<BaseElementEntity, Integer> elementCrudRepository(ElementRepository elementRepository) {
        return new JpaAdapter<>(elementRepository);
    }
}