package com.cricketboard.processor;
import com.cricketboard.domain.Activity;
import com.cricketboard.domain.NewInningsActivity;
import com.cricketboard.model.Inning;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.InningService;
import org.springframework.stereotype.Service;

@Service
public class NewInningsActivityProcessor implements ActivityProcessor {

    private final InningService inningService;
    private final ActivityRecordService activityRecordService;

    public NewInningsActivityProcessor(InningService inningService, ActivityRecordService activityRecordService) {
        this.inningService = inningService;
        this.activityRecordService = activityRecordService;
    }

    @Override
    public Activity processActivity(Activity activity) {
        NewInningsActivity newInningsActivity = (NewInningsActivity) activity;
        Inning inning = new Inning();
        inning.setInningId(newInningsActivity.getInningId());
        inning.setBattingTeamId(newInningsActivity.getBattingTeamId());
        inningService.save(inning);
        activityRecordService.saveActivityRecord(newInningsActivity);
        return newInningsActivity;
    }
}
