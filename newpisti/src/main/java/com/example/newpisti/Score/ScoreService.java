package com.example.newpisti.Score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

}
