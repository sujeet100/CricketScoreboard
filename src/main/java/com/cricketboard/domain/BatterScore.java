package com.cricketboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BatterScore {
    private Integer batterId;
    private Long runs;
    private Long balls;
    private Long fours;
    private Long sixes;
}
