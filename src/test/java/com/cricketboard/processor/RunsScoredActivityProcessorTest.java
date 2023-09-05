package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.model.BallType;
import com.cricketboard.model.Bowl;
import com.cricketboard.model.RunType;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.BowlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RunsScoredActivityProcessorTest {

    private RunsScoredActivityProcessor runsScoredActivityProcessor;

    @Mock
    private BowlService bowlService;

    @Mock
    private ActivityRecordService activityRecordService;

    @BeforeEach
    void beforeEach() {
        runsScoredActivityProcessor = new RunsScoredActivityProcessor(bowlService, activityRecordService);
    }

    @Test
    void shouldSaveRunScoredActivity() {

        when(bowlService.getBowl("1", "1", 1, 1))
                .thenReturn(Optional.of(new Bowl(
                        1,
                        "1",
                        "1",
                        1,
                        1,
                        BallType.LEGAL,
                        1,
                        120.5,
                        123,
                        456,
                        null,
                        null,
                        222,
                        333,
                        null,
                        new Timestamp(LocalDateTime.now().getNano()))));

        Activity runScoredActivity = new RunScoredActivity(
                "1",
                "1",
                LocalDateTime.now().minusSeconds(10),
                LocalDateTime.now(),
                ActivityType.RUN_SCORED,
                1,
                1,
                3,
                RunType.REGULAR);

        Activity activity = runsScoredActivityProcessor.processActivity(runScoredActivity);
        assertThat(activity).isNotNull();

    }

    @Test
    void shouldThrowExceptionIfRunsAreScoredForBowlNotRecorded() {

        when(bowlService.getBowl("1", "1", 1, 1)).thenReturn(Optional.empty());

        Activity runScoredActivity = new RunScoredActivity(
                "1",
                "1",
                LocalDateTime.now().minusSeconds(10),
                LocalDateTime.now(),
                ActivityType.RUN_SCORED,
                1,
                1,
                3,
                RunType.REGULAR);

        assertThatThrownBy(() -> runsScoredActivityProcessor.processActivity(runScoredActivity))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Bowl not found");
    }

}
