package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.MatchStartedActivity;
import com.cricketboard.model.Match;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.MatchService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.temporal.Temporal;

@Service
public class MatchStartedActivityProcessor implements ActivityProcessor {

    private final MatchService matchService;
    private final ActivityRecordService activityRecordService;

    public MatchStartedActivityProcessor(MatchService matchService, ActivityRecordService activityRecordService) {
        this.matchService = matchService;
        this.activityRecordService = activityRecordService;
    }

    @Override
    public Activity processActivity(Activity activity) {
        MatchStartedActivity matchStartedActivity = (MatchStartedActivity) activity;
        com.cricketboard.model.Activity savedActivity = activityRecordService.saveActivityRecord(matchStartedActivity);
        Match match = new Match();
        match.setTeam1Id(matchStartedActivity.getTeam1Id());
        match.setTeam2Id(matchStartedActivity.getTeam2Id());
        match.setDate(matchStartedActivity.getDate());
        match.setVenue(matchStartedActivity.getVenue());
        match.setMatchType(matchStartedActivity.getMatchType());
        match.setUmpire1(matchStartedActivity.getUmpire1());
        match.setUmpire2(matchStartedActivity.getUmpire2());
        matchService.saveMatch(match);
        return matchStartedActivity;

    }
}