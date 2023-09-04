package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.factory.ActivityProcessorFactory;
import com.cricketboard.processor.ActivityProcessor;
import com.cricketboard.repository.ActivityRepository;
import com.cricketboard.repository.BowlRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import static com.cricketboard.mapper.ActivityRecordMapper.toActivityRecord;

@Service
@Getter
public class ActivityService {
    private final BowlRepository bowlRepository;
    private final ActivityRepository activityRepository;
    private final ActivityProcessorFactory activityProcessorFactory;

    public ActivityService(BowlRepository bowlRepository, ActivityRepository activityRepository, ActivityProcessorFactory activityProcessorFactory) {
        this.bowlRepository = bowlRepository;
        this.activityRepository = activityRepository;
        this.activityProcessorFactory = activityProcessorFactory;
    }

    public Activity saveActivity(Activity activity) {
        ActivityProcessor activityProcessor = this.activityProcessorFactory.getProcessor(activity.getActivityType());
        return activityProcessor.processActivity(activity, this);
    }

    public com.cricketboard.model.Activity saveActivityRecord(Activity activity) {
        return activityRepository.save(toActivityRecord(activity));
    }

}
