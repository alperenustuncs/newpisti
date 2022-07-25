package com.example.newpisti.Score;

import com.example.newpisti.Player.Player;
import com.example.newpisti.Player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    private final long DAY_IN_MS = 1000 * 60 * 60 * 24;

    public void addNewScore(Long id, int score) {
        Optional<Player> player = playerRepository.findById(id);
        Score scoreToBeSaved = new Score(score, player.get());
        scoreRepository.save(scoreToBeSaved);
    }

    public List<Score> getLastWeekHighScores() {
        return scoreRepository.findAllByScoreTimeBetweenOrderByScoreDesc(
                new Date(System.currentTimeMillis() - (7 * DAY_IN_MS)),new Date());

    }
    public List<Score> getLastMonthHighScores() {
        return scoreRepository.findAllByScoreTimeBetweenOrderByScoreDesc(
                new Date(System.currentTimeMillis() - (30 * DAY_IN_MS)),new Date());
    }
    public List<Score> getAllTimeHighScores() {
        return scoreRepository.findAllByOrderByScoreDesc();
    }
}
