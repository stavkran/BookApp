package com.novelty.noveltybackend.Book;

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
    CommandLineRunner bookCommandLineRunner(BookRepository repository){
        return args -> {
            repository.saveAll(List.of(
                    new Book("Test Book 1", "Test Book 1 Description", 127, formatter.parse("7-Jun-2013")),
                    new Book("Test Book 2", "Test Book 2 Description", 322, formatter.parse("8-Oct-2017"))
            ));
        };
    }
}
