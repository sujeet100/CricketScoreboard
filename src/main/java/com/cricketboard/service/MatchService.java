package com.cricketboard.service;

import com.cricketboard.domain.BatterScore;
import com.cricketboard.domain.BattingScore;
import com.cricketboard.domain.MatchDetails;
import com.cricketboard.domain.TeamScore;
import com.cricketboard.model.BatterRuns;
import com.cricketboard.model.Match;
import com.cricketboard.model.Team;
import com.cricketboard.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MatchService {

    private final MatchRepository matchRepository;

    private final BowlService bowlService;

    public MatchService(MatchRepository matchRepository, BowlService bowlService) {
        this.matchRepository = matchRepository;
        this.bowlService = bowlService;
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public BattingScore getBattingScore(String matchId, String inningsId) {
        List<BatterRuns> battersScore = bowlService.getBatterRuns(matchId, inningsId);
        Map<Integer, Long> battersBowlFaced = bowlService.getBattersBowlFaced(matchId, inningsId);

        Map<Integer, Long> batterFours = bowlService.getFours(matchId, inningsId);

        Map<Integer, Long> batterSixes = bowlService.getSixes(matchId, inningsId);

        return new BattingScore(battersScore.stream().map(s -> new BatterScore(
                        s.getBatterId(),
                        s.getRuns(),
                        battersBowlFaced.getOrDefault(s.getBatterId(), 0L),
                        batterFours.getOrDefault(s.getBatterId(), 0L),
                        batterSixes.getOrDefault(s.getBatterId(), 0L)))
                .toList());

    }

    public MatchDetails getMatchDetails(String matchId) {
        Match match = matchRepository.findById(matchId).orElseThrow();
        Team teamA = match.getTeam1();
        Team teamB = match.getTeam2();
        BattingScore firstInningBattersScore = getBattingScore(matchId, matchId + "_1");
        BattingScore secondInningBattersScore = getBattingScore(matchId, matchId + "_2");
        return new MatchDetails(
                teamA,
                teamB,
                new TeamScore(firstInningBattersScore),
                new TeamScore(secondInningBattersScore));

    }

}
