package com.cricketboard.repository;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void shouldReturnTeams() {
        Team india = new Team("INDN00M", "India");
        Team australia = new Team("AUSN00M", "Australia");
        teamRepository.save(india);
        teamRepository.save(australia);

        assertThat(teamRepository.findAll()).containsExactly(india, australia);
    }

}
