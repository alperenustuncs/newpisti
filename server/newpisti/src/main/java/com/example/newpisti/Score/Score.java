package com.example.newpisti.Score;

import com.example.newpisti.Player.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Score {
    @Id
    @SequenceGenerator(
            name = "score_sequence",
            sequenceName = "score_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "score_sequence"
    )
    private Long id;

    @Column
    private int score;
    @CreationTimestamp
    private Date scoreTime;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;
    public Long getId() {
        return id;
    }

    public Score(int score,Player player){
        this.score = score;
        this.player = player;
    }

    public Score(int score, Player player, Date date){
        this.score = score;
        this.player = player;
        this.scoreTime = date;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
