package com.brave.backend.dao.impl;

import java.util.List;

import com.brave.backend.dao.CommentDao;
import com.brave.backend.dao.model.Comment;
import com.brave.backend.dao.model.CommentQueryCondition;
import com.brave.foundation.dao.impl.BaseDaoImpl;

/**
 * The Class CommentDaoImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao
{
    
    /** {@inheritDoc} */
    
    @Override
    public List<Comment> pagingQuery(CommentQueryCondition condition)
    {
        return sqlSession.selectList(namespace + ".pagingQuery", condition);
    }
    
}
