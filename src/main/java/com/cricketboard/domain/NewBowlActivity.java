package com.cricketboard.domain;

import com.cricketboard.model.Bowl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class NewBowlActivity extends Activity {
    private Integer matchId;
    private Integer inningsId;
    private Bowl bowl;

    public NewBowlActivity(Integer matchId, Integer inningsId, LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType, Bowl bowl) {
        super(startTime, endTime, activityType);
        this.matchId = matchId;
        this.inningsId = inningsId;
        this.bowl = bowl;
    }
}
