package com.novelty.noveltybackend.Report;

import com.novelty.noveltybackend.NoveltyUser.NoveltyUser;
import com.novelty.noveltybackend.NoveltyUser.NoveltyUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReportConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(ReportRepository repository, NoveltyUserRepository noveltyUserRepository){
        return args -> {
            NoveltyUser user1 = new NoveltyUser("TestUser1");
            NoveltyUser user2 = new NoveltyUser("TestUser2");

            noveltyUserRepository.saveAll(List.of(
                user1, user2
             ));

            repository.saveAll(List.of(
                    new Report(user1, user2, "Reason", "Comment")
            ));

        };
    }
}
