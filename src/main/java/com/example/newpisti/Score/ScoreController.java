package com.example.newpisti.Score;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/score")
@AllArgsConstructor
public class ScoreController {
    @Autowired
    private final ScoreService scoreService;


}
