package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.service.ActivityService;

public interface ActivityProcessor {

    public abstract Activity processActivity(Activity activity, ActivityService activityService);
}
