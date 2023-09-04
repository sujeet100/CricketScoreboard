package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.factory.ActivityProcessorFactory;
import com.cricketboard.model.RunType;
import com.cricketboard.processor.RunsScoredActivityProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActivityServiceTest {

    private ActivityService activityService;

    @Mock
    private ActivityProcessorFactory activityProcessorFactory;

    @Mock
    private RunsScoredActivityProcessor runsScoredActivityProcessor;

    @BeforeEach
    void setUp() {
        activityService = new ActivityService(activityProcessorFactory);
    }

    @Test
    void shouldSaveActivity() {

        Activity runScoredActivity = new RunScoredActivity(
                1,
                1,
                LocalDateTime.now().minusSeconds(10),
                LocalDateTime.now(),
                ActivityType.RUN_SCORED,
                1,
                1,
                3,
                RunType.REGULAR);

        when(activityProcessorFactory.getProcessor(ActivityType.RUN_SCORED)).thenReturn(runsScoredActivityProcessor);

        when(runsScoredActivityProcessor.processActivity(runScoredActivity)).thenReturn(runScoredActivity);

        Activity actualActivity = activityService.saveActivity(runScoredActivity);

        assertThat(actualActivity).isEqualTo(runScoredActivity);

    }

}
