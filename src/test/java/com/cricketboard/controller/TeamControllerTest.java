package com.cricketboard.controller;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.model.Team;
import com.cricketboard.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TeamControllerTest extends AbstractContainerBaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void shouldReturnTeams() throws Exception {
        Team india = new Team("INDN00M", "India", "IND", "NATIONAL");
        Team australia = new Team("AUSN00M", "Australia", "AUS", "NATIONAL");
        teamRepository.save(india);
        teamRepository.save(australia);

        this.mockMvc.perform(get("/teams"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value("INDN00M"))
                .andExpect(jsonPath("$[0].name").value("India"))
                .andExpect(jsonPath("$[1].id").value("AUSN00M"))
                .andExpect(jsonPath("$[1].name").value("Australia"));
    }
}
