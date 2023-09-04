package com.cricketboard.repository;

import com.cricketboard.AbstractContainerBaseTest;
import com.cricketboard.model.Inning;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.cricketboard.mother.InningsMother.legalInnings;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InningsRepositoryTest extends AbstractContainerBaseTest {
    @Autowired
    private InningRepository inningRepository;
    @Test
    void shouldSaveNewInningsActivity() {
        Inning inning = legalInnings().build();
        inningRepository.save(inning);
        Optional<Inning> result = inningRepository.findByInningId(inning.getInningId());
        assert(result).isPresent();
    }
}
