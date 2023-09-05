package com.cricketboard.repository;

import com.cricketboard.domain.Over;
import com.cricketboard.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BowlRepository extends JpaRepository<Bowl, Integer> {
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

    @Query("""
            SELECT\s
             new com.cricketboard.model.BowlingScore(
               CAST(
                 COUNT(b) AS int
               ),\s
               CAST(
                 SUM(b.run) AS int
               ),\s
               b.ballType
             )\s
           FROM\s
             Bowl b\s
           WHERE\s
             b.matchId = ?1\s
             AND b.inningsId = ?2\s
             AND b.bowlerId = ?3\s
           GROUP BY\s
             b.ballType
                               
            """)
    //@Query("SELECT COUNT(b), SUM(b.run), b.ballType FROM Bowl b WHERE b.matchId = ?1 AND b.inningsId = ?2 AND b.bowlerId = ?3 GROUP BY b.ballType")
    List<BowlingScore> getBowlingScore(String matchId, String inningsId, Integer bowlerId);



}
