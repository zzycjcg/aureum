package com.brave.backend.dao;

import java.util.List;

import com.brave.backend.dao.model.Msg;
import com.brave.backend.dao.model.MsgQueryCondition;
import com.brave.foundation.dao.BaseDao;

/**
 * The Interface MsgDao.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public interface MsgDao extends BaseDao<Msg>
{
    
    /**
     * Paging query.
     *
     * @param condition the condition
     * @return the list
     */
    List<Msg> pagingQuery(MsgQueryCondition condition);
}
