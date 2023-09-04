package com.cricketboard.factory;

import com.cricketboard.domain.ActivityType;
import com.cricketboard.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityProcessorFactory {

    @Autowired
    MatchStartedActivityProcessor matchStartedActivityProcessor;

    @Autowired
    NewBowlActivityProcessor newBowlActivityProcessor;

    @Autowired
    RunsScoredActivityProcessor runsScoredActivityProcessor;

    @Autowired
    NewInningsActivityProcessor newInningsActivityProcessor;

    public ActivityProcessor getProcessor(ActivityType activityType){
        return switch(activityType){
            case MATCH_STARTED -> matchStartedActivityProcessor;
            case NEW_BOWL ->  newBowlActivityProcessor;
            case RUN_SCORED -> runsScoredActivityProcessor;
            case NEW_INNINGS -> newInningsActivityProcessor;
            default -> throw new RuntimeException("Invalid Activity Type");
        };
    }
}
