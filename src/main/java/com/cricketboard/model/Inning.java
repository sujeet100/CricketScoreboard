package com.cricketboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Inning {
    @Id
    @Column(name="inning_id")
    private String inningId;
    @Column(name="batting_team_id")
    private String battingTeamId;

}
