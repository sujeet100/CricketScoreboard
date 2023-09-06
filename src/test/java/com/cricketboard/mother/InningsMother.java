package com.cricketboard.mother;

import com.cricketboard.model.Inning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InningsMother {
    public static Inning.InningBuilder legalInnings() {
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = date_format.format(LocalDateTime.now()).toString();
        return Inning.builder()
                .withInningId("INDN00M" + "AUSN00M" + now + "2")
                .withBattingTeamId("INDN00M")
                .withMatchId("INDN00M" + "AUSN00M" + now);
    }
}
