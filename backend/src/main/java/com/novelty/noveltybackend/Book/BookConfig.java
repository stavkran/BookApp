package com.novelty.noveltybackend.Book;

import com.novelty.noveltybackend.Author.Author;
import com.novelty.noveltybackend.Author.AuthorRepository;
import com.novelty.noveltybackend.NoveltyUser.NoveltyUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Configuration
public class BookConfig {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


    @Bean
    CommandLineRunner bookCommandLineRunner(BookRepository repository, AuthorRepository authorRepository){
        return args -> {
            Author author1 = new Author("Test Author 1", "Test Author Bio 1");
            Author author2 = new Author("Test Author 2", "Test Author Bio 2");

            authorRepository.saveAll(List.of(
                    author1, author2
            ));

            repository.saveAll(List.of(
                    new Book("Test Book 1", "Test Book 1 Description", 127, formatter.parse("7-Jun-2013"), author1),
                    new Book("Test Book 2", "Test Book 2 Description", 322, formatter.parse("8-Oct-2017"), author2)
            ));
        };
    }
}
