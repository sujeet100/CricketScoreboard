package com.cricketboard.repository;

import com.cricketboard.model.Inning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InningRepository extends JpaRepository<Inning, Integer> {
    Optional<Inning> findByInningId(String inningId);
}
