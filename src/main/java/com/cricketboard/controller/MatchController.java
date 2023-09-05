package com.cricketboard.controller;

import com.cricketboard.domain.MatchDetails;
import com.cricketboard.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matchDetails/{matchId}")
    @ResponseBody
    public MatchDetails getMatchDetails(@PathVariable String matchId) {
        return matchService.getMatchDetails(matchId);
    }
}
