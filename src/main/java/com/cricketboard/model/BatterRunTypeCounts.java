package com.cricketboard.model;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BatterRunTypeCounts {
    private List<BatterRunTypeCount> runTypeCounts;

    public Map<Integer, Long> getFours() {
        return runTypeCounts.stream()
                .filter(runTypeCount -> runTypeCount.getRunType() == RunType.FOUR)
                .collect(Collectors.toMap(BatterRunTypeCount::getBatterId, BatterRunTypeCount::getCount));
    }

    public Map<Integer, Long> getSixes() {
        return runTypeCounts.stream()
                .filter(runTypeCount -> runTypeCount.getRunType() == RunType.FOUR)
                .collect(Collectors.toMap(BatterRunTypeCount::getBatterId, BatterRunTypeCount::getCount));
    }
}
