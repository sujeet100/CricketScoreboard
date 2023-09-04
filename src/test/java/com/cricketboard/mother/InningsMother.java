package com.cricketboard.mother;

import com.cricketboard.model.Inning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InningsMother {
    public static Inning.InningBuilder legalInnings() {
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = date_format.format(LocalDateTime.now()).toString();
        return Inning.builder()
                .withInningId("INDN000M" + "AUSN000M" + now)
                .withBattingTeamId("INDN000M");
    }
}
