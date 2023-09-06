package com.cricketboard.controller;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.NewBowlActivity;
import com.cricketboard.domain.NewInningsActivity;
import com.cricketboard.model.Bowl;
import com.cricketboard.model.Match;
import com.cricketboard.model.Team;
import com.cricketboard.repository.BowlRepository;
import com.cricketboard.repository.MatchRepository;
import com.cricketboard.repository.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;

import static com.cricketboard.mother.BowlMother.legalBowl;
import static com.cricketboard.mother.MatchMother.legalMatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ActivityControllerTest extends AbstractContainerBaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BowlRepository bowlRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @BeforeEach
    private void clearTeamRepository(){
        teamRepository.deleteAll();
    }

    @Test
    void shouldCaptureRunScoredActivity() throws Exception {
        Bowl bowl = legalBowl().withOverNumber(0).withBallNumber(1).build();
        bowlRepository.save(bowl);

        String runScoredActivity = """
                {
                    "matchId": "1",
                    "inningsId": "1",
                    "startTime": "2021-01-01 10:00:00",
                    "endTime": "2021-01-01 10:00:10",
                    "activityType": "RUN_SCORED",
                    "overNumber": 0,
                    "ballNumber": 1,
                    "runsScored": 3,
                    "runType": "REGULAR"
                }
                """;
        this.mockMvc.perform(post("/activities")
                        .contentType(MediaType.APPLICATION_JSON).content(runScoredActivity))
                .andExpect(status().isOk());
    }
    @Test
    void shouldCaptureNewMatchStartedActivity() throws Exception {
        Team india = new Team("INDN00M", "India", "IND", "NATIONAL");
        Team australia = new Team("AUSN00M", "Australia", "AUS", "NATIONAL");

        teamRepository.save(india);
        teamRepository.save(australia);

        String matchStartedActivity = """   
                {
                    "team1Id": "INDN00M",
                    "team2Id": "AUSN00M",
                    "date": "2023-09-04 10:00:00",
                    "matchType": "20/20",
                    "venue": "Chennai",
                    "umpire1": 1,
                    "umpire2": 2,
                    "startTime": "2023-09-04 10:00:00",
                    "endTime": "2023-09-04 10:00:10",
                    "activityType": "MATCH_STARTED"
                }
                """;
        MvcResult result = this.mockMvc.perform(post("/activities")
                        .contentType(MediaType.APPLICATION_JSON).content(matchStartedActivity))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void shouldRecordNewBowlActivity() throws Exception {
        Bowl bowl = legalBowl().build();

        NewBowlActivity newBowlActivity = new NewBowlActivity(
                "1",
                "1",
                LocalDateTime.now(),
                LocalDateTime.now(),
                ActivityType.NEW_BOWL,
                bowl);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        System.out.println(objectMapper.writeValueAsString(newBowlActivity));

        this.mockMvc.perform(post("/activities")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(newBowlActivity)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCaptureNewInningsActivity() throws Exception {
        Team india = new Team("INDN00M", "India", "IND", "NATIONAL");
        Team australia = new Team("AUSN00M", "Australia", "AUS", "NATIONAL");
        Match match = legalMatch().build();
        match.setDate(match.getDate().plusDays(1));
        match.setTeam1(india);
        match.setTeam2(australia);
        Match savedMatch = matchRepository.save(match);
        NewInningsActivity newInningsActivity = new NewInningsActivity(
                savedMatch.getMatchId() + "1",
                india.getId(),
                savedMatch.getMatchId(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                ActivityType.NEW_INNINGS
        );

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        System.out.println(objectMapper.writeValueAsString(newInningsActivity));

        MvcResult result = this.mockMvc.perform(post("/activities")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(newInningsActivity)))
                .andExpect(status().isOk()).andReturn();

    }

}
