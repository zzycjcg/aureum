package com.brave.backend.dao;

import java.util.List;

import com.brave.backend.dao.model.Comment;
import com.brave.backend.dao.model.CommentQueryCondition;
import com.github.zzycjcg.foundation.dao.BaseDao;

/**
 * The Interface CommentDao.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public interface CommentDao extends BaseDao<Comment>
{
    
    /**
     * Paging query.
     *
     * @param condition the condition
     * @return the list
     */
    List<Comment> pagingQuery(CommentQueryCondition condition);
}
