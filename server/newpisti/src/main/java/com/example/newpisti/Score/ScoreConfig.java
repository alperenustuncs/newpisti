package com.example.newpisti.Score;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class ScoreConfig {

    //For now all the tests are done via playerconfig
    @Bean
    CommandLineRunner commandLineRunner(ScoreRepository scoreRepository){
        return args -> {
            Score score = new Score();
        };
    }
}
