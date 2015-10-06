package com.brave.backend.dao.impl;

import java.util.List;

import com.brave.backend.dao.MsgDao;
import com.brave.backend.dao.model.Msg;
import com.brave.backend.dao.model.MsgQueryCondition;
import com.brave.backend.dao.model.MsgWithContent;
import com.brave.foundation.dao.impl.BaseDaoImpl;

/**
 * The Class MsgDaoImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class MsgDaoImpl extends BaseDaoImpl<Msg> implements MsgDao
{
    
    /** {@inheritDoc} */
    
    @Override
    public List<MsgWithContent> pagingQuery(MsgQueryCondition condition)
    {
        return sqlSession.selectList(namespace + ".pagingQuery", condition);
    }
    
}
