package com.cricketboard.mapper;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.model.RunScoredActivityDetails;

public class ActivityRecordMapper {

    public static com.cricketboard.model.Activity toActivityRecord(Activity activity) {
        return new com.cricketboard.model.Activity(
                null,
                activity.getMatchId(),
                activity.getInningId(),
                activity.getStartTime(),
                activity.getEndTime(),
                activity.getActivityType(),
                getActivityDetails(activity)
        );
    }

    private static RunScoredActivityDetails getActivityDetails(Activity activity) {
        switch (activity.getActivityType()) {
            case RUN_SCORED -> {
                RunScoredActivity runScoredActivity = (RunScoredActivity) activity;
                return new RunScoredActivityDetails(
                        runScoredActivity.getOverNumber(),
                        runScoredActivity.getBallNumber(),
                        runScoredActivity.getRunsScored(),
                        runScoredActivity.getRunType());
            }
        }
        return null;
    }
}
