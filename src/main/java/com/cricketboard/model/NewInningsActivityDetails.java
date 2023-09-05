package com.cricketboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewInningsActivityDetails implements ActivityDetails{
    private String inningId;
    private String battingTeamId;
}
