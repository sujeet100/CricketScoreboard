package com.cricketboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchStartedActivityDetails implements  ActivityDetails{
    private String team1Id;
    private String team2Id;
    private String venue;
    private String matchType;
    private Integer umpire1;
    private Integer umpire2;
}
