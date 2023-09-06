package com.cricketboard.processor;

import com.cricketboard.domain.MatchStartedActivity;
import com.cricketboard.domain.Over;
import com.cricketboard.model.Match;
import com.cricketboard.model.Team;
import com.cricketboard.repository.TeamRepository;
import com.cricketboard.service.ActivityRecordService;
import com.cricketboard.service.MatchService;
import com.cricketboard.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.cricketboard.mother.MatchMother.legalMatch;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MatchStartedActivityProcessTest {
    private MatchStartedActivityProcessor matchStartedActivityProcessor;

    @Mock
    private MatchService matchService;

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private ActivityRecordService activityRecordService;

    @BeforeEach
    void beforeEach() {
        matchStartedActivityProcessor = new MatchStartedActivityProcessor(matchService, activityRecordService, teamRepository);
    }

    @Test
    void shouldSaveMatchStartedActivity(){
        Team india = new Team("INDN00M", "India", "IND", "NATIONAL");
        Team australia = new Team("AUSN00M", "Australia", "AUS", "NATIONAL");
        Match match = legalMatch().build();
        when(teamRepository.findById(String.valueOf(match.getTeam1()))).thenReturn(Optional.of(india));
        when(teamRepository.findById(String.valueOf(match.getTeam2()))).thenReturn(Optional.of(australia));
        MatchStartedActivity matchStartedActivity = new MatchStartedActivity();
        matchStartedActivity.setTeam1Id(String.valueOf(match.getTeam1()));
        matchStartedActivity.setTeam2Id(String.valueOf(match.getTeam2()));
        matchStartedActivity.setDate(LocalDateTime.parse(String.valueOf(match.getDate())));
        matchStartedActivity.setVenue(String.valueOf(match.getVenue()));
        matchStartedActivity.setMatchType(String.valueOf(match.getMatchType()));
        when(matchService.saveMatch(any())).thenReturn(match);
        assertThat(matchStartedActivityProcessor.processActivity(matchStartedActivity)).isNotNull();
    }

}
