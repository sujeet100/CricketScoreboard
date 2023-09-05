package com.cricketboard.mother;

import com.cricketboard.model.BallType;
import com.cricketboard.model.BowlingScore;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BowlingScoreMother {
    @NotNull
    public static List<BowlingScore> generateBowlingScores() {
        BowlingScore bowlingScore1 = new BowlingScore(4, 10, BallType.LEGAL);
        BowlingScore bowlingScore2 = new BowlingScore(2, 0, BallType.WICKET);
        return List.of(bowlingScore1, bowlingScore2);
    }
}