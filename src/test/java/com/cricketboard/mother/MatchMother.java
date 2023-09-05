package com.cricketboard.mother;

import com.cricketboard.model.Match;
import com.cricketboard.model.Team;

import java.time.LocalDateTime;

public class MatchMother {
    public static Match.MatchBuilder legalMatch() {
        return Match.builder()
                .withTeam1(Team.builder().withId("INDN000M").build())
                .withTeam2(Team.builder().withId("AUSN000M").build())
                .withDate(LocalDateTime.now())
                .withVenue("Chennai")
                .withUmpire1(1)
                .withUmpire2(2);
    }
}
