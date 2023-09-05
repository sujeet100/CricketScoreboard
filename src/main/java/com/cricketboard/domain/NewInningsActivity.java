package com.cricketboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class NewInningsActivity extends Activity{
    private String inningId;
    private String battingTeamId;
    public NewInningsActivity(String inningId, String battingTeamId, LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType) {
        super(startTime, endTime, activityType);
    }
}
