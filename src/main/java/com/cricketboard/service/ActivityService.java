package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.factory.ActivityProcessorFactory;
import com.cricketboard.processor.ActivityProcessor;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    private final ActivityProcessorFactory activityProcessorFactory;

    public ActivityService(ActivityProcessorFactory activityProcessorFactory) {
        this.activityProcessorFactory = activityProcessorFactory;
    }

    public Activity saveActivity(Activity activity) {
        ActivityProcessor activityProcessor = this.activityProcessorFactory.getProcessor(activity.getActivityType());
        return activityProcessor.processActivity(activity);
    }

}
