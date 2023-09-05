package com.cricketboard.service;

import com.cricketboard.domain.Over;
import com.cricketboard.model.BowlingScore;
import com.cricketboard.mother.BowlingScoreMother;
import com.cricketboard.repository.BowlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BowlServiceTest {

    @Mock
    private BowlRepository bowlRepository;

    private BowlService bowlService;

    @BeforeEach
    void setUp() {
        bowlService = new BowlService(bowlRepository);
    }

    @Test
    void shouldReturnCurrentOverSummary() {

        when(bowlRepository.getCurrentOverSummary("1", "1")).thenReturn(new Over(1, 1));

        Over currentOverSummary = bowlService.getCurrentOverSummary("1", "1");

        assertThat(currentOverSummary).isEqualTo(new Over(1, 1));
    }

    @Test
    void shouldReturnCurrentOverSummaryWhenNoBowlsAreBowledInMatchYet() {

        when(bowlRepository.getCurrentOverSummary("1", "1")).thenReturn(null);

        Over currentOverSummary = bowlService.getCurrentOverSummary("1", "1");

        assertThat(currentOverSummary).isEqualTo(new Over(0, 0));
    }

    @Test
    void shouldReturnCorrectBowlingScore() {
        final List<BowlingScore> bowlingScores = BowlingScoreMother.generateBowlingScores();
        when(bowlRepository.getBowlingScore("1", "1", 11)).thenReturn(bowlingScores);

        com.cricketboard.domain.BowlingScore bowlingScore =
                new com.cricketboard.domain.BowlingScore("1.0", 0, 10, 2);

        com.cricketboard.domain.BowlingScore actualBowlingScore = bowlService.getBowlingScore("1","1",11);
        assertThat(actualBowlingScore).isEqualTo(bowlingScore);

    }

}
