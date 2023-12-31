package com.cricketboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewInningsActivity extends Activity{
    private String inningId;
    private String battingTeamId;
    private String matchId;
    public NewInningsActivity(String inningId, String battingTeamId, String matchId,
                              LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType) {
        super(startTime, endTime, activityType);
        this.inningId = inningId;
        this.battingTeamId = battingTeamId;
        this.matchId = matchId;
    }

    public NewInningsActivity() { }
}
