package com.cricketboard.mapper;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.MatchStartedActivity;
import com.cricketboard.domain.NewInningsActivity;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.model.*;

public class ActivityRecordMapper {

    public static com.cricketboard.model.Activity toActivityRecord(Activity activity) {
        return new com.cricketboard.model.Activity(
                null,
                activity.getStartTime(),
                activity.getEndTime(),
                activity.getActivityType(),
                getActivityDetails(activity)
        );
    }

    private static ActivityDetails getActivityDetails(Activity activity) {
        switch (activity.getActivityType()) {
            case RUN_SCORED -> getRunScoredActivityDetails(activity);
            case MATCH_STARTED -> getMatchStartedActivityDetails(activity);
            case NEW_INNINGS -> getNewInningsActivityDetails(activity);
        }
        return null;
    }

    private static RunScoredActivityDetails getRunScoredActivityDetails(Activity activity) {
        RunScoredActivity runScoredActivity = (RunScoredActivity) activity;
        return new RunScoredActivityDetails(
                runScoredActivity.getMatchId(),
                runScoredActivity.getInningsId(),
                runScoredActivity.getOverNumber(),
                runScoredActivity.getBallNumber(),
                runScoredActivity.getRunsScored(),
                runScoredActivity.getRunType());
    }

    private static MatchStartedActivityDetails getMatchStartedActivityDetails(Activity activity) {
        MatchStartedActivity matchStartedActivity = (MatchStartedActivity) activity;
        return new MatchStartedActivityDetails(
                matchStartedActivity.getTeam1Id(),
                matchStartedActivity.getTeam2Id(),
                matchStartedActivity.getVenue(),
                matchStartedActivity.getMatchType(),
                matchStartedActivity.getUmpire1(),
                matchStartedActivity.getUmpire2()
        );
    }

    private static NewInningsActivityDetails getNewInningsActivityDetails(Activity activity) {
        NewInningsActivity newInningsActivity = (NewInningsActivity) activity;
        return new NewInningsActivityDetails(
                newInningsActivity.getInningId(),
                newInningsActivity.getBattingTeamId()
        );
    }
}
