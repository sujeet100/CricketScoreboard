package com.cricketboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BatterRuns {
    private Integer batterId;
    private Integer runs;
    private Integer balls;
}
