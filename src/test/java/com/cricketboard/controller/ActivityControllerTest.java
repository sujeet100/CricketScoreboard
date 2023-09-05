package com.cricketboard.controller;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.NewBowlActivity;
import com.cricketboard.model.Bowl;
import com.cricketboard.repository.BowlRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static com.cricketboard.mother.BowlMother.legalBowl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ActivityControllerTest extends AbstractContainerBaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BowlRepository bowlRepository;

    @Test
    void shouldCaptureRunScoredActivity() throws Exception {
        Bowl bowl = legalBowl().build();
        bowlRepository.save(bowl);

        String runScoredActivity = """
                {
                    "matchId": 1,
                    "inningsId": 1,
                    "startTime": "2021-01-01 10:00:00",
                    "endTime": "2021-01-01 10:00:10",
                    "activityType": "RUN_SCORED",
                    "overNumber": 1,
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
        this.mockMvc.perform(post("/activities")
                        .contentType(MediaType.APPLICATION_JSON).content(matchStartedActivity))
                .andExpect(status().isOk());
    }

    @Test
    void shouldRecordNewBowlActivity() throws Exception {
        Bowl bowl = legalBowl().build();

        NewBowlActivity newBowlActivity = new NewBowlActivity(
                1,
                1,
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

}
