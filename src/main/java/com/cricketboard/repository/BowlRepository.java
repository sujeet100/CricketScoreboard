package com.cricketboard.repository;

import com.cricketboard.model.BatterRuns;
import com.cricketboard.model.Bowl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BowlRepository extends JpaRepository<Bowl, Integer> {
    Optional<Bowl> findByMatchIdAndInningsIdAndOverNumberAndBallNumber(Integer matchId, Integer inningsId, Integer overNumber, Integer ballNumber);

    @Query("""
            select
            	b.strikerBatterId,
            	sum(b.run),
            	count(*)
            from
            	Bowl b
            where
            	b.matchId = ?1
            	and b.inningsId = ?2
            	and
            	(b.runType = 'REGULAR'
            	or b.runType = 'FOUR'
            	or b.runType = 'SIX')
            group by
            	b.matchId, b.strikerBatterId
            """)
    List<BatterRuns> getBattersScore(Integer matchId, Integer inningsId);
}
