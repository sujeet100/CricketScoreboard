package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.ActivityType;
import com.cricketboard.domain.NewBowlActivity;
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
    void shouldSaveNewBowlActivity(){
        Bowl bowl = legalBowl().build();
        Activity activity = new NewBowlActivity(1,1, LocalDateTime.now(), LocalDateTime.now().plusSeconds(10), ActivityType.NEW_BOWL,bowl);
        newBowlActivityProcessor.processActivity(activity);
        assertThat(activity).isNotNull();
    }

}
