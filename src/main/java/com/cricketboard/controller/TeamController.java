package com.cricketboard.controller;

import com.cricketboard.model.Team;
import com.cricketboard.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    List<Team> getTeams() {
        return teamService.getTeams();
    }
}
