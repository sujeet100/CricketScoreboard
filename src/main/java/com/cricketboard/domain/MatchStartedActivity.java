package com.cricketboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MatchStartedActivity extends  Activity{

    private String team1Id;
    private String team2Id;
    private Timestamp date;
    private String matchType;
    private String venue;
    private Integer umpire1;
    private Integer umpire2;

    public MatchStartedActivity(LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType) {
        super(startTime, endTime, activityType);
    }

}
