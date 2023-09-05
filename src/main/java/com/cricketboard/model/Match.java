package com.cricketboard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Match {
    @Id
    @GeneratedValue(generator = "match_id_generator")
    @GenericGenerator(name = "match_id_generator", strategy = "com.cricketboard.model.generator.MatchIdGenerator")
    private String matchId;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    @NotNull
    @Length(max = 200)
    private String venue;
    private String matchType;
    @NotNull
    private Integer umpire1;
    @NotNull
    private Integer umpire2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team1_id", referencedColumnName = "id")
    private Team team1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team2_id", referencedColumnName = "id")
    private Team team2;
}
