package com.cricketboard.repository;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.model.Match;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.cricketboard.mother.MatchMother.legalMatch;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MatchRepositoryTest extends AbstractContainerBaseTest {
    @Autowired
    private MatchRepository matchRepository;
    @Test
    void shouldSaveMatchStartedActivity() {
        Match match = legalMatch().build();
        matchRepository.save(match);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = dateFormat.format(LocalDateTime.now()).toString();
        Optional<Match> result = matchRepository.findByMatchId(match.getTeam1().getId() + match.getTeam2().getId() + now);
        assertThat(result).isPresent();
    }
}
