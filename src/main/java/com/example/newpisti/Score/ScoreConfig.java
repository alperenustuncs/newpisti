package com.example.newpisti.Score;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class ScoreConfig {
    @Bean
    CommandLineRunner commandLineRunner(ScoreRepository scoreRepository){
        return args -> {
            System.out.println("scoreconfigden commandline");
        };
    }
}
