package com.cricketboard.domain;

import java.time.LocalDateTime;

public class NewBowlActivity extends Activity {

    public NewBowlActivity(Integer matchId, Integer inningId, LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType) {
        super(matchId, inningId, startTime, endTime, activityType);
    }
}
