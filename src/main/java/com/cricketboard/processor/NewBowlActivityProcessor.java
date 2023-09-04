package com.cricketboard.processor;

import com.cricketboard.domain.Activity;
import org.springframework.stereotype.Service;

@Service
public class NewBowlActivityProcessor implements ActivityProcessor{
    @Override
    public Activity processActivity(Activity activity) {
        return null;
    }
}
