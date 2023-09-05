package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.MatchStartedActivity;
import com.cricketboard.factory.ActivityProcessorFactory;
import com.cricketboard.processor.MatchStartedActivityProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MatchServiceTest {
    private ActivityService activityService;
    @Mock
    private ActivityProcessorFactory activityProcessorFactory;
    @Mock
    private MatchStartedActivityProcessor matchStartedActivityProcessor;
    @BeforeEach
    void setUp() {
        activityService = new ActivityService(activityProcessorFactory);
    }

    @Test
    void shouldSaveActivity() {

        Activity matchStartedActivity = new MatchStartedActivity(
                "INDN000M",
                "AUSN000M",
                LocalDateTime.now(),
                "2020",
                "Chennai",
                1,
                2,
                LocalDateTime.now().minusSeconds(10),
                LocalDateTime.now(),
                ActivityType.MATCH_STARTED);

        when(activityProcessorFactory.getProcessor(ActivityType.MATCH_STARTED)).thenReturn(matchStartedActivityProcessor);

        when(matchStartedActivityProcessor.processActivity(matchStartedActivity)).thenReturn(matchStartedActivity);

        Activity actualActivity = activityService.saveActivity(matchStartedActivity);

        assertThat(actualActivity).isEqualTo(matchStartedActivity);

    }
}
