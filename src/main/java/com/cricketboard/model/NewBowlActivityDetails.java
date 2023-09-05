package com.cricketboard.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBowlActivityDetails implements ActivityDetails{
    private String matchId;
    private String inningsId;
    private Bowl bowl;
}
