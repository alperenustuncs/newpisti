package com.example.newpisti.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository
                .findPlayerByEmail(player.getEmail());
        if(playerOptional.isPresent()){
             throw new IllegalStateException("Email taken");
        }
        playerRepository.save(player);
    }
}
