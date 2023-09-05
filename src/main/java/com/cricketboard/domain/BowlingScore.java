package com.cricketboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BowlingScore {
    String noOfOvers;
    Integer noOfMaidens = 0;
    Integer totalRuns = 0;
    Integer noOfWickets;
}
