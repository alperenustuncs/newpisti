package com.example.newpisti.Player;

import com.example.newpisti.Score.Score;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @OneToMany(
            mappedBy = "player",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Score> scores = new ArrayList<>();
    @CreationTimestamp
    private LocalDate signupTime;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    private Integer signupDuration;

    public Player(String alperenustuncs, String s, String alperenustun1) {
        this.username = alperenustuncs;
        this.email = s;
        this.password = alperenustun1;
    }

    public Integer getAge(){
        return Period.between(signupTime, LocalDate.now()).getYears();
    }

    public void setAge(Integer age){
        this.signupDuration = age;
    }


}
