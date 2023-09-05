package com.cricketboard.service;

import com.cricketboard.domain.Over;
import com.cricketboard.model.BatterBowls;
import com.cricketboard.model.BatterRunTypeCounts;
import com.cricketboard.model.BatterRuns;
import com.cricketboard.model.Bowl;
import com.cricketboard.repository.BowlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BowlService {

    private final BowlRepository bowlRepository;

    public BowlService(BowlRepository bowlRepository) {
        this.bowlRepository = bowlRepository;
    }

    public Bowl saveBowl(Bowl bowl) {
        return bowlRepository.save(bowl);
    }

    public Optional<Bowl> getBowl(String matchId, String inningsId, Integer overNumber, Integer ballNumber) {
        return bowlRepository.findByMatchIdAndInningsIdAndOverNumberAndBallNumber(
                matchId,
                inningsId,
                overNumber,
                ballNumber);
    }

    public Over getCurrentOverSummary(String matchId, String inningsId) {
        Over currentOverSummary = bowlRepository.getCurrentOverSummary(matchId, inningsId);
        return currentOverSummary == null ? new Over(0, 0) : currentOverSummary;
    }

    public Map<Integer, Long> getBattersBowlFaced(String matchId, String inningsId) {
        return bowlRepository
                .getBatterBowlsFaced(matchId, inningsId)
                .stream()
                .collect(Collectors.toMap(BatterBowls::getBatterId, BatterBowls::getBalls));
    }

    public Map<Integer, Long> getSixes(String matchId, String inningsId) {
        return new BatterRunTypeCounts(bowlRepository.getBatterRunTypeCounts(matchId, inningsId)).getSixes();
    }

    public Map<Integer, Long> getFours(String matchId, String inningsId) {
        return new BatterRunTypeCounts(bowlRepository.getBatterRunTypeCounts(matchId, inningsId)).getFours();
    }

    public List<BatterRuns> getBatterRuns(String matchId, String inningsId) {
        return bowlRepository.getBatterRuns(matchId, inningsId);
    }
}
