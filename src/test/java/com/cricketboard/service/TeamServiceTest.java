package com.cricketboard.service;

import com.cricketboard.model.Team;
import com.cricketboard.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;


    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void shouldReturnTeams() {
        TeamService teamService = new TeamService(teamRepository);
        when(teamRepository.findAll()).thenReturn(List.of(new Team("INDN00M", "India", "IND", "NATIONAL")));

        List<Team> teams = teamService.getTeams();
        assertThat(teams).containsExactly(new Team("INDN00M", "India", "IND", "NATIONAL"));
    }
}
