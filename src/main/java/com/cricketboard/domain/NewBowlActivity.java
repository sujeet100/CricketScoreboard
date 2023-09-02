package com.cricketboard.domain;

import java.time.LocalDateTime;

public class NewBowlActivity extends Activity {

    public NewBowlActivity(LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType) {
        super(startTime, endTime, activityType);
    }
}
