package com.cricketboard.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BatterRunTypeCount {
    private Integer batterId;
    private RunType runType;
    private Long count;
}
