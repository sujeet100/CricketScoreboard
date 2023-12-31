package com.cricketboard.domain;

import com.cricketboard.model.RunType;

import java.time.LocalDateTime;

public class RunScoredActivity extends Activity {

    private Integer overNumber;
    private Integer ballNumber;
    private Integer runsScored;
    private RunType runType;
    private String matchId;
    private String inningsId;

    public RunScoredActivity(String matchId, String inningsId, LocalDateTime startTime, LocalDateTime endTime, ActivityType activityType, Integer overNumber, Integer ballNumber, Integer runsScored, RunType runType) {
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

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getInningsId() {
        return inningsId;
    }

    public void setInningsId(String inningsId) {
        this.inningsId = inningsId;
    }

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
