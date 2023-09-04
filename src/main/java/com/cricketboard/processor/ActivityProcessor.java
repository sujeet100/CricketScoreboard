package com.cricketboard.processor;

import com.cricketboard.domain.Activity;

public interface ActivityProcessor {

    Activity processActivity(Activity activity);
}
