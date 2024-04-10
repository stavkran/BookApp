package com.novelty.noveltybackend.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner reportCommandLineRunner(BookRepository repository){
        return args -> {
            new NoveltyUser("TestUser1");
            new NoveltyUser("TestUser2");
            repository.saveAll(List.of(
                    new NoveltyUser("TestUser1"),
                    new NoveltyUser("TestUser2")
            ));
        };
    }
}
