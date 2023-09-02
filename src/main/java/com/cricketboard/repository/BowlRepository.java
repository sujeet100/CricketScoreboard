package com.cricketboard.repository;

import com.cricketboard.model.Bowl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BowlRepository extends JpaRepository<Bowl, Integer> {
    Optional<Bowl> findByMatchIdAndInningsIdAndOverNumberAndBallNumber(Integer matchId, Integer inningsId, Integer overNumber, Integer ballNumber);
}
