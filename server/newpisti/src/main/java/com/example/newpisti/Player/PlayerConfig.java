package com.example.newpisti.Player;

import com.example.newpisti.Score.Score;
import com.example.newpisti.Score.ScoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class PlayerConfig {

    private final long DAY_IN_MS = 1000 * 60 * 60 * 24;

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository, ScoreRepository scoreRepository){
        return args -> {
            Player player = new Player(
                    "bilimci67",
                    "bilimci67@hotmail.com",
                    "alp.4-c"
                    );
            Player player2 = new Player(
              "alperenustuncs",
              "alperenustuncs@gmail.com",
              "Alperenustun1"
            );
            Score score = new Score(5000,player);
            score.setScoreTime(new Date(System.currentTimeMillis() - (6 * DAY_IN_MS)));
            Score score2 = new Score(10000,player2, new Date(System.currentTimeMillis() - (10 * DAY_IN_MS)));
            Score score3 = new Score(20000,player, new Date(System.currentTimeMillis() - (31 * DAY_IN_MS)));
            repository.saveAll(List.of(player,player2));
            scoreRepository.saveAll(List.of(score,score2,score3));

        };
    }
}
