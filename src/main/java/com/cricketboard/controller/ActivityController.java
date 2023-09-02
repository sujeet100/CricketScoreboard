package com.cricketboard.controller;

import com.cricketboard.domain.Activity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    @PostMapping("/activities")
    public Activity captureActivity(@RequestBody Activity activity) {
        return activity;
    }
}
