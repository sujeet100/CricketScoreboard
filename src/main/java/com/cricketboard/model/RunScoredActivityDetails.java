package com.cricketboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RunScoredActivityDetails implements ActivityDetails {

    private Integer overNumber;
    private Integer ballNumber;
    private Integer runsScored;
    private RunType runType;
}
