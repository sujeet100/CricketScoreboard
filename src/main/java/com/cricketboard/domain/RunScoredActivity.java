package com.cricketboard.domain;

import com.cricketboard.model.RunType;

import java.time.LocalDateTime;

public class RunScoredActivity extends Activity {

    private Integer overNumber;
    private Integer ballNumber;
    private Integer runsScored;
    private RunType runType;
    private Integer matchId;
    private Integer inningsId;

    public RunScoredActivity(Integer matchId, Integer inningsId, LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType, Integer overNumber, Integer ballNumber, Integer runsScored, RunType runType) {
        super(startTime, endTime, activityType);
        this.matchId = matchId;
        this.inningsId = inningsId;
        this.overNumber = overNumber;
        this.ballNumber = ballNumber;
        this.runsScored = runsScored;
        this.runType = runType;

    }

    public RunScoredActivity() {
    }

    public  Integer getMatchId() { return matchId; }
    public void setMatchId(Integer matchId) { this.matchId = matchId; }
    public Integer getInningsId() { return inningsId; }
    public void setInningsId(Integer inningsId) { this.inningsId = inningsId; }
    public Integer getOverNumber() {
        return overNumber;
    }
    public void setOverNumber(Integer overNumber) {
        this.overNumber = overNumber;
    }

    public Integer getBallNumber() {
        return ballNumber;
    }

    public void setBallNumber(Integer ballNumber) {
        this.ballNumber = ballNumber;
    }

    public Integer getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(Integer runsScored) {
        this.runsScored = runsScored;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }
}
