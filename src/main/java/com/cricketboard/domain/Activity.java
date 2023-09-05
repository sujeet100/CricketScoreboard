package com.cricketboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "activityType",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RunScoredActivity.class, name = "RUN_SCORED"),
        @JsonSubTypes.Type(value = NewBowlActivity.class, name = "NEW_BOWL"),
        @JsonSubTypes.Type(value = MatchStartedActivity.class, name="MATCH_STARTED"),
        @JsonSubTypes.Type(value = NewInningsActivity.class, name="NEW_INNINGS")
})
public abstract class Activity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private ActivityType activityType;

    public Activity(LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
    }

    public Activity() {
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
