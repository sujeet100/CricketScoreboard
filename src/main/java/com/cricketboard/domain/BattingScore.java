package com.cricketboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class BattingScore {
    private List<BatterScore> batterScores;
}
