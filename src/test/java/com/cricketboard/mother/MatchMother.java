package com.cricketboard.mother;

import com.cricketboard.model.Match;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MatchMother {
    public static Match.MatchBuilder legalMatch() {
        return Match.builder()
                .withTeam1Id("INDN000M")
                .withTeam2Id("AUSN000M")
                .withDate(Timestamp.valueOf(LocalDateTime.now()))
                .withVenue("Chennai")
                .withUmpire1(1)
                .withUmpire2(2);
    }
}
