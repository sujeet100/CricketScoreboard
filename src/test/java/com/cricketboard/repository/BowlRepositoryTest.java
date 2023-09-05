package com.cricketboard.repository;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.cricketboard.mother.BowlMother.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BowlRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private BowlRepository bowlRepository;

    @Test
    void shouldFindBowlByMatchIdAndInningsIdAndOverNumberAndBallNumber() {
        Bowl bowl = legalBowl().build();
        bowlRepository.save(bowl);

        Optional<Bowl> actual = bowlRepository.findByMatchIdAndInningsIdAndOverNumberAndBallNumber(1, 1, 1, 1);

        assertThat(actual).isPresent();
    }

    @Test
    void shouldReturnBatterRuns() {
        Bowl bowl1 = bowlWithRegularRuns(1, 1, 3).withStrikerBatterId(345).build();
        Bowl bowl2 = bowlWithLegByeRuns(1, 2, 1).withStrikerBatterId(345).build();
        Bowl bowl3 = bowlWithLegByeRuns(1, 3, 1).withStrikerBatterId(456).build();
        Bowl bowl4 = bowlWithRegularRuns(1, 4, 1).withStrikerBatterId(456).build();
        bowlRepository.save(bowl1);
        bowlRepository.save(bowl2);
        bowlRepository.save(bowl3);
        bowlRepository.save(bowl4);

        List<BatterRuns> actual = bowlRepository.getBatterRuns(1, 1);

        assertThat(actual).containsExactlyInAnyOrder(
                new BatterRuns(345, 3L),
                new BatterRuns(456, 1L)
        );
    }

    @Test
    void shouldReturnBatterBowsFaced() {
        Bowl bowl1 = bowlWithRegularRuns(1, 1, 3).withStrikerBatterId(345).build();
        Bowl bowl2 = bowlWithRegularRuns(1, 2, 1).withStrikerBatterId(345).build();
        Bowl bowl3 = bowlWithLegByeRuns(1, 3, 1).withStrikerBatterId(456).build();
        Bowl bowl4 = bowlWithRegularRuns(1, 4, 1).withStrikerBatterId(456).build();
        bowlRepository.save(bowl1);
        bowlRepository.save(bowl2);
        bowlRepository.save(bowl3);
        bowlRepository.save(bowl4);

        List<BatterBowls> actual = bowlRepository.getBatterBowlsFaced(1, 1);

        assertThat(actual).containsExactlyInAnyOrder(
                new BatterBowls(345, 2L),
                new BatterBowls(456, 2L)
        );
    }

    @Test
    void shouldReturnBatterRunTypeCount() {
        Bowl bowl1 = bowlWithFourRuns(1, 1).withStrikerBatterId(345).build();
        Bowl bowl2 = bowlWithRegularRuns(1, 2, 1).withStrikerBatterId(345).build();

        Bowl bowl3 = bowlWithLegByeRuns(1, 3, 1).withStrikerBatterId(456).build();
        Bowl bowl4 = bowlWithRegularRuns(1, 4, 1).withStrikerBatterId(456).build();

        Bowl bowl5 = bowlWithSixRuns(1, 5).withStrikerBatterId(456).build();
        Bowl bowl6 = bowlWithRegularRuns(1, 6, 2).withStrikerBatterId(456).build();


        bowlRepository.save(bowl1);
        bowlRepository.save(bowl2);
        bowlRepository.save(bowl3);
        bowlRepository.save(bowl4);
        bowlRepository.save(bowl5);
        bowlRepository.save(bowl6);

        List<BatterRunTypeCount> actual = bowlRepository.getBatterRunTypeCounts(1, 1);

        assertThat(actual).containsExactlyInAnyOrder(
                new BatterRunTypeCount(345, RunType.FOUR, 1L),
                new BatterRunTypeCount(456, RunType.REGULAR, 2L),
                new BatterRunTypeCount(456, RunType.LEGBYE, 1L),
                new BatterRunTypeCount(345, RunType.REGULAR, 1L),
                new BatterRunTypeCount(456, RunType.SIX, 1L)
        );
    }
}
