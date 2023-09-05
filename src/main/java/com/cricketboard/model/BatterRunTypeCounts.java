package com.cricketboard.model;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BatterRunTypeCounts {
    private List<BatterRunTypeCount> runTypeCounts;

    public Optional<BatterRunTypeCount> getFours() {
        return runTypeCounts.stream()
                .filter(runTypeCount -> runTypeCount.getRunType() == RunType.FOUR)
                .findFirst();
    }

    public Optional<BatterRunTypeCount> getSixes() {
        return runTypeCounts.stream()
                .filter(runTypeCount -> runTypeCount.getRunType() == RunType.FOUR)
                .findFirst();
    }
}
