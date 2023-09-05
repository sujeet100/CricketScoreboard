package com.cricketboard.service;

import com.cricketboard.domain.Over;
import com.cricketboard.repository.BowlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BowlServiceTest {

    @Mock
    private BowlRepository bowlRepository;

    private BowlService bowlService;

    @BeforeEach
    void setUp() {
        bowlService = new BowlService(bowlRepository);
    }

    @Test
    void shouldReturnCurrentOverSummary() {

        when(bowlRepository.getCurrentOverSummary(1, 1)).thenReturn(new Over(1, 1));

        Over currentOverSummary = bowlService.getCurrentOverSummary(1, 1);

        assertThat(currentOverSummary).isEqualTo(new Over(1, 1));
    }

    @Test
    void shouldReturnCurrentOverSummaryWhenNoBowlsAreBowledInMatchYet() {

        when(bowlRepository.getCurrentOverSummary(1, 1)).thenReturn(null);

        Over currentOverSummary = bowlService.getCurrentOverSummary(1, 1);

        assertThat(currentOverSummary).isEqualTo(new Over(0, 0));
    }
}
