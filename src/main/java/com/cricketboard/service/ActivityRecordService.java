package com.cricketboard.service;

import com.cricketboard.domain.Activity;
import com.cricketboard.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import static com.cricketboard.mapper.ActivityRecordMapper.toActivityRecord;

@Service
public class ActivityRecordService {

    private final ActivityRepository activityRepository;

    public ActivityRecordService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public com.cricketboard.model.Activity saveActivityRecord(Activity activity) {
        return activityRepository.save(toActivityRecord(activity));
    }
}