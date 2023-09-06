package com.cricketboard.repository;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    void setUp() {
        teamRepository.deleteAll();
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void shouldReturnTeams() {
        Team india = new Team("INDN00M", "India", "IND", "NATIONAL");
        Team australia = new Team("AUSN00M", "Australia", "AUS", "NATIONAL");
        teamRepository.save(india);
        teamRepository.save(australia);

        assertThat(teamRepository.findAll()).containsExactly(india, australia);
    }

}
