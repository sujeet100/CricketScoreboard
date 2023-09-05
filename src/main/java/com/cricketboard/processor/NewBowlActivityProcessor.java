package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.NewBowlActivity;
import com.cricketboard.domain.Over;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.BowlService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NewBowlActivityProcessor implements ActivityProcessor {

    private final BowlService bowlService;
    private final ActivityRecordService activityRecordService;

    public NewBowlActivityProcessor(BowlService bowlService, ActivityRecordService activityRecordService) {
        this.bowlService = bowlService;
        this.activityRecordService = activityRecordService;
    }

    @Override
    public Activity processActivity(Activity activity) {
        NewBowlActivity newBowlActivity = (NewBowlActivity) activity;

        Over currentOverSummary = bowlService.getCurrentOverSummary(
                newBowlActivity.getMatchId(),
                newBowlActivity.getInningsId());

        isBowlSequenceValid(currentOverSummary, newBowlActivity);

        bowlService.saveBowl(newBowlActivity.getBowl());
        activityRecordService.saveActivityRecord(activity);
        return activity;
    }

    private static void isBowlSequenceValid(Over currentOverSummary, NewBowlActivity newBowlActivity) {
        if (!Objects.equals(currentOverSummary.nextBowlNumber(), newBowlActivity.getBowl().getBallNumber())
                || !Objects.equals(currentOverSummary.nextOverNumber(), newBowlActivity.getBowl().getOverNumber())) {
            throw new RuntimeException(
                    "Bowl sequence is not correct, Expected next over: %s, ball: %s while trying to add ball with over: %s ball: %s"
                            .formatted(
                                    currentOverSummary.nextOverNumber(),
                                    currentOverSummary.nextBowlNumber(),
                                    newBowlActivity.getBowl().getOverNumber(),
                                    newBowlActivity.getBowl().getBallNumber()));
        }
    }
}
