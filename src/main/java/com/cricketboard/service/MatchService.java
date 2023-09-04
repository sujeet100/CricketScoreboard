package com.cricketboard.service;

import com.cricketboard.domain.BattingScore;
import com.cricketboard.model.BatterRuns;
import com.cricketboard.repository.BowlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final BowlRepository bowlRepository;

    public MatchService(BowlRepository bowlRepository) {
        this.bowlRepository = bowlRepository;
    }

    public BattingScore getBattingScore(Integer matchId) {
        List<BatterRuns> firstInningBattersScore = bowlRepository.getBattersScore(matchId, 1);
        return null;
    }
}
