package com.cricketboard.repository;

import com.cricketboard.domain.Over;
import com.cricketboard.model.BatterBowls;
import com.cricketboard.model.BatterRunTypeCount;
import com.cricketboard.model.BatterRuns;
import com.cricketboard.model.Bowl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BowlRepository extends JpaRepository<Bowl, String> {
    Optional<Bowl> findByMatchIdAndInningsIdAndOverNumberAndBallNumber(String matchId, String inningsId, Integer overNumber, Integer ballNumber);

    @Query("""
            select
            	new com.cricketboard.model.BatterRuns(
            	    b.strikerBatterId,
            	    sum(b.run)
            	)
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
            	b.strikerBatterId
            """)
    List<BatterRuns> getBatterRuns(String matchId, String inningsId);

    @Query("""
            select
            	new com.cricketboard.model.BatterBowls(
            	    b.strikerBatterId,
            	    count(*)
            	)
            from
            	Bowl b
            where
            	b.matchId = ?1
            	and b.inningsId = ?2
            	and
            	b.ballType = 'LEGAL'
            group by
            	b.strikerBatterId
            """)
    List<BatterBowls> getBatterBowlsFaced(String matchId, String inningsId);

    @Query("""
            select
            	new com.cricketboard.model.BatterRunTypeCount(
            	    b.strikerBatterId,
            	    b.runType,
            	    count(*)
            	)
            from
            	Bowl b
            where
            	b.matchId = ?1
            	and b.inningsId = ?2
            group by
            	b.strikerBatterId,
            	b.runType
            """)
    List<BatterRunTypeCount> getBatterRunTypeCounts(String matchId, String inningsId);

    @Query("""
            select
            	new com.cricketboard.domain.Over(
            	    b.overNumber,
            	    max(b.ballNumber)
            	)
            from
            	Bowl b
            where
            	b.matchId = ?1
            	and b.inningsId = ?2
            	and b.overNumber = (
            	    select
            	        max(b.overNumber)
            	    from
            	        Bowl b
            	    where
            	        b.matchId = ?1
            	        and b.inningsId = ?2
            	)
            group by overNumber
            """)
    Over getCurrentOverSummary(String matchId, String inningsId);
}
