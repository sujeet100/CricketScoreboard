package com.cricketboard.service;

import com.cricketboard.domain.BattingScore;
import com.cricketboard.model.BatterRuns;
import com.cricketboard.model.Match;
import com.cricketboard.repository.BowlRepository;
import com.cricketboard.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final BowlRepository bowlRepository;

    public MatchService(MatchRepository matchRepository, BowlRepository bowlRepository) {
        this.matchRepository = matchRepository;
        this.bowlRepository = bowlRepository;
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public BattingScore getBattingScore(Integer matchId) {
        List<BatterRuns> firstInningBattersScore = bowlRepository.getBatterRuns(matchId, 1);
        return null;
    }

}
