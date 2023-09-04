package com.cricketboard.repository;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.model.Bowl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.cricketboard.mother.BowlMother.legalBowl;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BowlRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private BowlRepository bowlRepository;

    @Test
    void shouldFindBowlByMatchIdAndInningsIdAndOverNumberAndBallNumber() {
        Bowl bowl = legalBowl().build();
        bowlRepository.save(bowl);

        Optional<Bowl> actual = bowlRepository.findByMatchIdAndInningsIdAndOverNumberAndBallNumber(
                1,
                1,
                1,
                1);

        assertThat(actual).isPresent();
    }
}
