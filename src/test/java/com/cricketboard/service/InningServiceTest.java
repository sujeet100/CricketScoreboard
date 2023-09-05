package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.NewInningsActivity;
import com.cricketboard.factory.ActivityProcessorFactory;
import com.cricketboard.processor.NewInningsActivityProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InningServiceTest {
    private ActivityService activityService;
    @Mock
    private ActivityProcessorFactory activityProcessorFactory;
    @Mock
    private NewInningsActivityProcessor newInningsActivityProcessor;

    @BeforeEach
    void setUp() {
        activityService = new ActivityService(activityProcessorFactory);
    }

    @Test
    void shouldSaveActivity() {

        Activity newInningsActivity = new NewInningsActivity(
              "INDN000MAUSN000M20230904",
                "INDN000M",
                LocalDateTime.now().minusSeconds(10),
                LocalDateTime.now(),
                ActivityType.NEW_INNINGS);

        when(activityProcessorFactory.getProcessor(ActivityType.NEW_INNINGS)).thenReturn(newInningsActivityProcessor);

        when(newInningsActivityProcessor.processActivity(newInningsActivity)).thenReturn(newInningsActivity);

        Activity actualActivity = activityService.saveActivity(newInningsActivity);

        assertThat(actualActivity).isEqualTo(newInningsActivity);

    }

}
