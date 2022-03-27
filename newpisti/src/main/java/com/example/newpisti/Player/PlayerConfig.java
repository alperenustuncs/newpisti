package com.example.newpisti.Player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository){
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
            
            repository.saveAll(List.of(player,player2));
        };
    }
}
