package com.cricketboard.factory;

import com.cricketboard.domain.ActivityType;
import com.cricketboard.processor.ActivityProcessor;
import com.cricketboard.processor.MatchStartedActivityProcessor;
import com.cricketboard.processor.NewBowlActivityProcessor;
import com.cricketboard.processor.RunsScoredActivityProcessor;
import org.springframework.stereotype.Service;

@Service
public class ActivityProcessorFactory {
    public ActivityProcessor getProcessor(ActivityType activityType){
        return switch(activityType){
            case MATCH_STARTED -> new MatchStartedActivityProcessor();
            case NEW_BOWL ->  new NewBowlActivityProcessor();
            case RUN_SCORED -> new RunsScoredActivityProcessor();
            default -> throw new RuntimeException("Invalid Activity Type");
        };
    }
}
