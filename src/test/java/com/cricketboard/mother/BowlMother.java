package com.cricketboard.mother;

import com.cricketboard.model.BallType;
import com.cricketboard.model.Bowl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BowlMother {

    public static Bowl.BowlBuilder legalBowl() {
        return Bowl.builder()
                .withId(1)
                .withMatchId(1)
                .withInningsId(1)
                .withBowlerId(123)
                .withBallSpeed(100.1)
                .withBallType(BallType.LEGAL)
                .withFrontUmpireId(1001)
                .withLegUmpireId(1002)
                .withOverNumber(1)
                .withBallNumber(1)
                .withStrikerBatterId(345)
                .withNonStrikerBatterId(556)
                .withTimeStamp(Timestamp.valueOf(LocalDateTime.now()));
    }
}
