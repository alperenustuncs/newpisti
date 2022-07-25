package com.example.newpisti.Score;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/score")
@AllArgsConstructor
public class ScoreController {

    @Autowired
    private final ScoreService scoreService;

    @GetMapping("lastWeekHighScores")
    public List<Score> getLastWeekHighScores(){
        return scoreService.getLastWeekHighScores();
    }

    @GetMapping("lastMonthHighScores")
    public List<Score> getLastMonthHighScores(){
        return scoreService.getLastMonthHighScores();
    }

    @GetMapping("allTimeHighScores")
    public List<Score> getAllTimeHighScores(){
        return scoreService.getAllTimeHighScores();
    }

    @PostMapping("{playerId}/{score}")
    public void postScore(@PathVariable("playerId") Long id, @PathVariable("score") int score)
    {
        scoreService.addNewScore(id, score);
    }



}
