package com.example.newpisti.Player;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/player")
@AllArgsConstructor
public class PlayerController {

    @Autowired
    private final PlayerService playerService;

    @GetMapping
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @PostMapping
    public void registerNewPlayer(@RequestBody Player player){
        playerService.addNewPlayer(player);
    }

    @DeleteMapping(path="{playerId}")
    public void deletePlayer(@PathVariable("playerId") Long id){
        playerService.deletePlayer(id);
    }

    @PutMapping(path="{playerId}")
    public void updatePlayer(@PathVariable("playerId") Long id, @RequestBody Player player){playerService.updatePlayer(id,player);}
}
