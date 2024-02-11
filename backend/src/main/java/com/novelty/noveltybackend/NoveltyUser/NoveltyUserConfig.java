package com.novelty.noveltybackend.NoveltyUser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NoveltyUserConfig {

    @Bean
    CommandLineRunner commandLineRunner(NoveltyUserRepository repository){
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
