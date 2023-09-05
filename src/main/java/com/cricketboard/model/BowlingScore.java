package com.cricketboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class BowlingScore {
    Integer noOfBalls;
    Integer totalRuns;
    BallType ballType;
}
