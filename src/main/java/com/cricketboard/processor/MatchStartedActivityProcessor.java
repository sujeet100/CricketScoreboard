package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.MatchStartedActivity;
import com.cricketboard.model.Match;
import com.cricketboard.repository.TeamRepository;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.MatchService;
import org.springframework.stereotype.Service;

@Service
public class MatchStartedActivityProcessor implements ActivityProcessor {

    private final MatchService matchService;
    private final ActivityRecordService activityRecordService;

    private final TeamRepository teamRepository;

    public MatchStartedActivityProcessor(MatchService matchService, ActivityRecordService activityRecordService, TeamRepository teamRepository) {
        this.matchService = matchService;
        this.activityRecordService = activityRecordService;
        this.teamRepository = teamRepository;
    }

    @Override
    public Activity processActivity(Activity activity) {
        MatchStartedActivity matchStartedActivity = (MatchStartedActivity) activity;
        com.cricketboard.model.Activity savedActivity = activityRecordService.saveActivityRecord(matchStartedActivity);
        Match match = new Match();
        match.setTeam1(teamRepository.findById(matchStartedActivity.getTeam1Id())
                .orElseThrow(() -> new RuntimeException("Team not found")));
        match.setTeam2(teamRepository.findById(matchStartedActivity.getTeam2Id())
                .orElseThrow(() -> new RuntimeException("Team not found")));
        match.setDate(matchStartedActivity.getDate());
        match.setVenue(matchStartedActivity.getVenue());
        match.setMatchType(matchStartedActivity.getMatchType());
        match.setUmpire1(matchStartedActivity.getUmpire1());
        match.setUmpire2(matchStartedActivity.getUmpire2());
        Match savedMatch = matchService.saveMatch(match);
        matchStartedActivity.setMatchId(savedMatch.getMatchId());
        return matchStartedActivity;

    }
}