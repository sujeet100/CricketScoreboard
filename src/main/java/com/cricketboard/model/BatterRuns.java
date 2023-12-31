package com.cricketboard.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BatterRuns {
    private Integer batterId;
    private Long runs;
}
