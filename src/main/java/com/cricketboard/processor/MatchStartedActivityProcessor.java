package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.service.ActivityService;

public class MatchStartedActivityProcessor implements ActivityProcessor{
    @Override
    public Activity processActivity(Activity activity, ActivityService activityService) {
        return null;
    }
}
