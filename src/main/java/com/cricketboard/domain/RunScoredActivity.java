package com.cricketboard.domain;

import com.cricketboard.model.RunType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RunScoredActivity extends Activity {

    private Integer overNumber;
    private Integer ballNumber;
    private Integer runsScored;
    private RunType runType;

    public RunScoredActivity(Integer matchId, Integer inningId, LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType, Integer overNumber, Integer ballNumber, Integer runsScored, RunType runType) {
        super(matchId, inningId, startTime, endTime, activityType);
        this.overNumber = overNumber;
        this.ballNumber = ballNumber;
        this.runsScored = runsScored;
        this.runType = runType;
    }

    public RunScoredActivity() {
    }

    public void setOverNumber(Integer overNumber) {
        this.overNumber = overNumber;
    }

    public void setBallNumber(Integer ballNumber) {
        this.ballNumber = ballNumber;
    }

    public void setRunsScored(Integer runsScored) {
        this.runsScored = runsScored;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }
}
