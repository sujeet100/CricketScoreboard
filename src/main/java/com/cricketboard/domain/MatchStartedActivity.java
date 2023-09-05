package com.cricketboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class MatchStartedActivity extends  Activity{
    private String matchId;
    private String team1Id;
    private String team2Id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private String matchType;
    private String venue;
    private Integer umpire1;
    private Integer umpire2;

    public MatchStartedActivity(String team1Id, String team2Id, LocalDateTime date, String matchType, String venue,
                                Integer umpire1, Integer umpire2, LocalDateTime startTime, LocalDateTime endTime,
                                ActivityType activityType) {
        super(startTime, endTime, activityType);
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.date = date;
        this.matchType = matchType;
        this.venue = venue;
        this.umpire1 = umpire1;
        this.umpire2 = umpire2;
    }

    public MatchStartedActivity(){
    }

}
