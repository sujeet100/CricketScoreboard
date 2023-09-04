package com.cricketboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewInningsActivity extends Activity{
    private String inningId;
    private String battingTeamId;
}
