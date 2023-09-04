package com.cricketboard.service;

import com.cricketboard.model.Match;
import com.cricketboard.repository.MatchRepository;
import org.springframework.stereotype.Service;


@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

}
