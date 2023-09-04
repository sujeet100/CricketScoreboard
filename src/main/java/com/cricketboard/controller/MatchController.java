package com.cricketboard.controller;

import com.cricketboard.domain.MatchDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatchController {


    @GetMapping("/matchDetails/{matchId}")
    public MatchDetails getMatchDetails() {
        return null;
    }
}
