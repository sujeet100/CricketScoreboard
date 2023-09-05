package com.cricketboard.model.generator;

import com.cricketboard.model.Match;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class MatchIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Match match = (Match) object;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        return match.getTeam1().getId() + match.getTeam2().getId() +
                dateFormat.format(((Match) object).getDate());
    }
}
