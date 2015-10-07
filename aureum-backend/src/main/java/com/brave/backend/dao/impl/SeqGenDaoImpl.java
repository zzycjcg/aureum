package com.brave.backend.dao.impl;

import com.brave.backend.dao.SeqGenDao;
import com.brave.backend.dao.model.SeqGen;
import com.brave.foundation.dao.impl.BaseDaoImpl;

/**
 * The Class SeqGenDaoImpl.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class SeqGenDaoImpl extends BaseDaoImpl<SeqGen> implements SeqGenDao
{
    
    /** {@inheritDoc} */
    // TODO  事务
    @Override
    public String nextVal(String seqId)
    {
        int colNum = sqlSession.update(namespace + ".next", seqId);
        if (colNum < 1)
        {
            throw new IllegalArgumentException("No this sequence found:" + seqId);
        }
        return querySingle(seqId).getSeqVal();
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String currentVal(String seqId)
    {
        SeqGen seqGen = querySingle(seqId);
        if (seqGen == null)
        {
            throw new IllegalArgumentException("No this sequence found:" + seqId);
        }
        return seqGen.getSeqVal();
    }
    
}
