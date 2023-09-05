package com.cricketboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RunScoredActivityDetails implements ActivityDetails {
    private Integer MatchId;
    private Integer InningsId;
    private Integer overNumber;
    private Integer ballNumber;
    private Integer runsScored;
    private RunType runType;
}
