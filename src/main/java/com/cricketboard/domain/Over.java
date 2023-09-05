package com.cricketboard.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Over {
    private final Integer overNumber;
    private final Integer currentBowlNumber;

    public Over(int overNumber, int currentBowlNumber) {
        this.overNumber = overNumber;
        this.currentBowlNumber = currentBowlNumber;
    }

    public Integer nextBowlNumber() {
        return currentBowlNumber == 6 ? 1 : currentBowlNumber + 1;
    }

    public Integer nextOverNumber() {
        return overNumber + 1;
    }
}
