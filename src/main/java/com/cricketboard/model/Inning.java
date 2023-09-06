package com.cricketboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Inning {
    @Id
    @GeneratedValue(generator = "innings_id_generator")
    @GenericGenerator(name = "innings_id_generator", strategy = "com.cricketboard.model.generator.InningsIdGenerator")
    @Column(name="inning_id")
    private String inningId;
    @Column(name="match_id")
    private String matchId;
    @Column(name="batting_team_id")
    private String battingTeamId;

}
