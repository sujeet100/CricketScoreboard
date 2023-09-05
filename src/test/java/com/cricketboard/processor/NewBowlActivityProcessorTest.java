package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.NewBowlActivity;
import com.cricketboard.domain.Over;
import com.cricketboard.model.Bowl;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.BowlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static com.cricketboard.mother.BowlMother.legalBowl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewBowlActivityProcessorTest {

    private NewBowlActivityProcessor newBowlActivityProcessor;
    @Mock
    private BowlService bowlService;

    @Mock
    private ActivityRecordService activityRecordService;

    @BeforeEach
    void beforeEach() {
        newBowlActivityProcessor = new NewBowlActivityProcessor(bowlService, activityRecordService);
    }

    @Test
    void shouldSaveNewBowlActivity() {
        Bowl bowl = legalBowl().build();
        Activity activity = new NewBowlActivity(
                "1",
                "1",
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(10),
                ActivityType.NEW_BOWL,
                bowl);

        when(bowlService.getCurrentOverSummary("1", "1")).thenReturn(new Over(0, 0));

        newBowlActivityProcessor.processActivity(activity);
        assertThat(activity).isNotNull();
    }

    @Test
    void shouldNotSkipABowl() {
        when(bowlService.getCurrentOverSummary("1", "1")).thenReturn(new Over(1, 1));

        Bowl bowl = legalBowl().withOverNumber(1).withBallNumber(3).build();
        Activity activity = new NewBowlActivity(
                "1",
                "1",
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(10),
                ActivityType.NEW_BOWL,
                bowl);

        assertThatThrownBy(() -> newBowlActivityProcessor.processActivity(activity))
                .hasMessage("Bowl sequence is not correct")
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldBeAValidBallSequenceWhenFirstBowlOfMatch() {
        when(bowlService.getCurrentOverSummary("1", "1")).thenReturn(new Over(0, 0));

        Bowl bowl = legalBowl().withOverNumber(2).withBallNumber(1).build();
        Activity activity = new NewBowlActivity(
                "1",
                "1",
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(10),
                ActivityType.NEW_BOWL,
                bowl);

        assertThat(newBowlActivityProcessor.processActivity(activity)).isNotNull();
    }

    @Test
    void shouldBeAValidBallSequenceWhenFirstBowlOfNextOver() {
        when(bowlService.getCurrentOverSummary("1", "1")).thenReturn(new Over(1, 6));

        Bowl bowl = legalBowl().withOverNumber(2).withBallNumber(1).build();
        Activity activity = new NewBowlActivity(
                "1",
                "1",
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(10),
                ActivityType.NEW_BOWL,
                bowl);

        assertThat(newBowlActivityProcessor.processActivity(activity)).isNotNull();
    }

}
