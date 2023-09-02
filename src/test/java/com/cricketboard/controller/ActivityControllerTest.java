package com.cricketboard.controller;

import com.cricketboard.AbstractContainerBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ActivityControllerTest extends AbstractContainerBaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCaptureRunScoredActivity() throws Exception {
        String runScoredActivity = """
                {
                    "matchId": 1,
                    "inningId": 1,
                    "startTime": "2021-01-01 10:00:00",
                    "endTime": "2021-01-01 10:00:10",
                    "activityType": "RUN_SCORED",
                    "overNumber": 1,
                    "ballNumber": 1,
                    "runsScored": 3,
                    "runtType": "NORMAL"
                }
                """;
        this.mockMvc.perform(post("/activities")
                .contentType(MediaType.APPLICATION_JSON).content(runScoredActivity))
                .andExpect(status().isOk());
    }
}
