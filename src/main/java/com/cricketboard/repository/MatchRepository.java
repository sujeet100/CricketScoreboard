package com.cricketboard.repository;

import com.cricketboard.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, String> {
    Optional<Match> findByMatchId(String matchId);
}
