package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import com.cricketboard.service.ActivityService;
import org.springframework.stereotype.Service;

@Service
public class NewBowlActivityProcessor implements ActivityProcessor{
    @Override
    public Activity processActivity(Activity activity, ActivityService activityService) {
        return null;
    }
}
