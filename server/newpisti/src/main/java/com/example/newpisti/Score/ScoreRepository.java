package com.example.newpisti.Score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllByOrderByScoreDesc(); // all time high scores
    List<Score> findAllByScoreTimeBetweenOrderByScoreDesc(Date from, Date to); // find scores from date "from" to date "to"
}
