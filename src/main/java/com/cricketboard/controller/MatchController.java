package com.cricketboard.controller;

import com.cricketboard.domain.MatchDetails;
import com.cricketboard.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matchDetails/{matchId}")
    public MatchDetails getMatchDetails(String matchId) {
        return matchService.getMatchDetails(matchId);
    }
}
