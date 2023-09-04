package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.BowlService;
import org.springframework.stereotype.Service;

@Service
public class RunsScoredActivityProcessor implements ActivityProcessor {

    private final BowlService bowlService;
    private final ActivityRecordService activityRecordService;

    public RunsScoredActivityProcessor(BowlService bowlService, ActivityRecordService activityRecordService) {
        this.bowlService = bowlService;
        this.activityRecordService = activityRecordService;
    }

    @Override
    public Activity processActivity(Activity activity) {
        RunScoredActivity runScoredActivity = (RunScoredActivity) activity;
        return bowlService.getBowl(runScoredActivity.getMatchId(),
                        runScoredActivity.getInningsId(),
                        runScoredActivity.getOverNumber(),
                        runScoredActivity.getBallNumber())
                .map(bowl -> {
                    bowl.setRun(runScoredActivity.getRunsScored());
                    bowl.setRunType(runScoredActivity.getRunType());
                    bowlService.saveBowl(bowl);
                    activityRecordService.saveActivityRecord(runScoredActivity);
                    return activity;
                })
                .orElseThrow(() -> new RuntimeException("Bowl not found"));
    }

}
