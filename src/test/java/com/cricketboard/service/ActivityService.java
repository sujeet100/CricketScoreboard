package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.repository.BowlRepository;

public class ActivityService {
    private final BowlRepository bowlRepository;

    public ActivityService(BowlRepository bowlRepository) {
        this.bowlRepository = bowlRepository;
    }

    public Activity saveActivity(Activity activity) {
        return switch (activity.getActivityType()) {
            case NEW_BOWL -> null;
            case RUN_SCORED -> {
                RunScoredActivity runScoredActivity = (RunScoredActivity) activity;
                yield bowlRepository.findByMatchIdAndInningsIdAndOverNumberAndBallNumber(
                                runScoredActivity.getMatchId(),
                                runScoredActivity.getInningId(),
                                runScoredActivity.getOverNumber(),
                                runScoredActivity.getBallNumber())
                        .map(bowl -> {
                            bowl.setRun(runScoredActivity.getRunsScored());
                            bowl.setRunType(runScoredActivity.getRunType());
                            bowlRepository.save(bowl);
                            return activity;
                        })
                        .orElseThrow(() -> new RuntimeException("Bowl not found"));
            }

            case MATCH_STARTED -> null;
            default -> null;
        };
    }
}
