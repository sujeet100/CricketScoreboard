package com.cricketboard.service;

import com.cricketboard.model.Inning;
import com.cricketboard.repository.InningRepository;
import org.springframework.stereotype.Service;

@Service
public class InningService {
    public final InningRepository inningRepository;

    public InningService(InningRepository inningRepository) {
        this.inningRepository = inningRepository;
    }

    public Inning save(Inning inning) {
        return this.inningRepository.save(inning);
    }
}
