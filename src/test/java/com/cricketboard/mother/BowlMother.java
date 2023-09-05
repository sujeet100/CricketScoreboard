package com.cricketboard.mother;

import com.cricketboard.model.BallType;
import com.cricketboard.model.Bowl;
import com.cricketboard.model.RunType;

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

    public static Bowl.BowlBuilder bowlWithRegularRuns(int over, int bowl, int runs) {
        return legalBowl().withId(over * 6 + bowl)
                .withOverNumber(over)
                .withBallNumber(bowl)
                .withRun(runs)
                .withRunType(RunType.REGULAR);
    }

    public static Bowl.BowlBuilder bowlWithFourRuns(int over, int bowl) {
        return bowlWithRegularRuns(over, bowl, 4).withRunType(RunType.FOUR);
    }

    public static Bowl.BowlBuilder bowlWithSixRuns(int over, int bowl) {
        return bowlWithRegularRuns(over, bowl, 6).withRunType(RunType.SIX);
    }

    public static Bowl.BowlBuilder bowlWithLegByeRuns(int over, int bowl, int runs) {
        return legalBowl().withId(over * 6 + bowl)
                .withOverNumber(over)
                .withBallNumber(bowl)
                .withRun(runs)
                .withRunType(RunType.LEGBYE);
    }
}
