package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.service.ActivityService;
import org.springframework.stereotype.Service;

@Service
public class RunsScoredActivityProcessor implements ActivityProcessor{
    @Override
    public Activity processActivity(Activity activity, ActivityService activityService) {
        RunScoredActivity runScoredActivity = (RunScoredActivity) activity;
        return activityService.getBowlRepository().findByMatchIdAndInningsIdAndOverNumberAndBallNumber(
                        runScoredActivity.getMatchId(),
                        runScoredActivity.getInningsId(),
                        runScoredActivity.getOverNumber(),
                        runScoredActivity.getBallNumber())
                .map(bowl -> {
                    bowl.setRun(runScoredActivity.getRunsScored());
                    bowl.setRunType(runScoredActivity.getRunType());
                    activityService.getBowlRepository().save(bowl);
                    activityService.saveActivityRecord(runScoredActivity);
                    return activity;
                })
                .orElseThrow(() -> new RuntimeException("Bowl not found"));
    }
}
