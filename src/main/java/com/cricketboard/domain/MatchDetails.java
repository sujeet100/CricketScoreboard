package com.cricketboard.domain;

import com.cricketboard.model.Match;
import com.cricketboard.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchDetails {
    private Team teamA;
    private Team teamB;
    private TeamScore teamAScore;
    private TeamScore teamBScore;
}
