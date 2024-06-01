package com.novelty.noveltybackend.Author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class AuthorConfig {


    @Bean
    CommandLineRunner authorCommandLineRunner(AuthorRepository repository){
        return args -> {
            repository.saveAll(List.of(
                    new Author("Test Author 1", "Test Author 1 Bio"),
                    new Author("Test Author 2", "Test Author 2 Bio")
            ));
        };
    }
}
