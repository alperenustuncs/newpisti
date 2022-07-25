package com.example.newpisti.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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

    public void deletePlayer(Long id){
       boolean exists =  playerRepository.existsById(id);
       if(!exists){
           throw new IllegalStateException("player does not exist");
       }
       playerRepository.deleteById(id);
    }

    //Todo
    //  Error checks
    @Transactional
    public void updatePlayer(Long id, Player player){

        Optional<Player> playa = playerRepository.findById(id);
        Player playerFromDatabase = playa.get();
        playerFromDatabase.setEmail(player.getEmail());
        playerFromDatabase.setUsername(player.getUsername());
        playerFromDatabase.setPassword(player.getPassword());
    }
}
