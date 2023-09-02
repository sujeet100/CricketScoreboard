package com.cricketboard.controller;

import com.cricketboard.domain.Activity;
import com.cricketboard.service.ActivityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/activities")
    public Activity captureActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }
}
