package com.cricketboard.model.generator;

import com.cricketboard.model.Inning;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class InningsIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Inning inning = (Inning) object;
        return inning.getInningId();
    }
}
