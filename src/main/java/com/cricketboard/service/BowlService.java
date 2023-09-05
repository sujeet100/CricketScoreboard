package com.cricketboard.service;

import com.cricketboard.domain.Over;
import com.cricketboard.model.Bowl;
import com.cricketboard.repository.BowlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BowlService {

    private final BowlRepository bowlRepository;

    public BowlService(BowlRepository bowlRepository) {
        this.bowlRepository = bowlRepository;
    }

    public Bowl saveBowl(Bowl bowl) {
        return bowlRepository.save(bowl);
    }

    public Optional<Bowl> getBowl(Integer matchId, Integer inningsId, Integer overNumber, Integer ballNumber) {
        return bowlRepository.findByMatchIdAndInningsIdAndOverNumberAndBallNumber(
                matchId,
                inningsId,
                overNumber,
                ballNumber);
    }

    public Over getCurrentOverSummary(Integer matchId, Integer inningsId) {
        Over currentOverSummary = bowlRepository.getCurrentOverSummary(matchId, inningsId);
        return currentOverSummary == null ? new Over(0, 0) : currentOverSummary;
    }
}
