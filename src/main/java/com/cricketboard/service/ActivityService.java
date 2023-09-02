package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.domain.RunScoredActivity;
import com.cricketboard.repository.ActivityRepository;
import com.cricketboard.repository.BowlRepository;
import org.springframework.stereotype.Service;

import static com.cricketboard.mapper.ActivityRecordMapper.toActivityRecord;

@Service
public class ActivityService {
    private final BowlRepository bowlRepository;
    private final ActivityRepository activityRepository;

    public ActivityService(BowlRepository bowlRepository, ActivityRepository activityRepository) {
        this.bowlRepository = bowlRepository;
        this.activityRepository = activityRepository;
    }

    public Activity saveActivity(Activity activity) {
        return switch (activity.getActivityType()) {
            case NEW_BOWL -> null;
            case RUN_SCORED -> {
                RunScoredActivity runScoredActivity = (RunScoredActivity) activity;
                yield bowlRepository.findByMatchIdAndInningsIdAndOverNumberAndBallNumber(
                                runScoredActivity.getMatchId(),
                                runScoredActivity.getInningsId(),
                                runScoredActivity.getOverNumber(),
                                runScoredActivity.getBallNumber())
                        .map(bowl -> {
                            bowl.setRun(runScoredActivity.getRunsScored());
                            bowl.setRunType(runScoredActivity.getRunType());
                            bowlRepository.save(bowl);
                            saveActivityRecord(runScoredActivity);
                            return activity;
                        })
                        .orElseThrow(() -> new RuntimeException("Bowl not found"));
            }

            case MATCH_STARTED -> null;
            default -> null;
        };
    }

    private com.cricketboard.model.Activity saveActivityRecord(Activity activity) {
        return activityRepository.save(toActivityRecord(activity));
    }

}
