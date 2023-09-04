package com.cricketboard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Match {
    @Id
    @GeneratedValue(generator = "match_id_generator")
    @GenericGenerator(name="match_id_generator", strategy = "com.cricketboard.model.generator.MatchIdGenerator")
    private String matchId;
    @NotNull
    @Column(name="team1_id")
    private String team1Id;
    @NotNull
    @Column(name="team2_id")
    private String team2Id;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;
    @NotNull
    @Length(max = 200)
    private String venue;
    private String matchType;
    @NotNull
    private Integer umpire1;
    @NotNull
    private Integer umpire2;
}
