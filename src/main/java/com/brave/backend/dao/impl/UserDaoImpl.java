package com.brave.backend.dao.impl;

import com.brave.backend.dao.UserDao;
import com.brave.backend.dao.model.User;
import com.github.zzycjcg.foundation.dao.impl.BaseDaoImpl;

/**
 * The Class UserDaoImpl.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao
{
    /** {@inheritDoc} */
    
    @Override
    public User queryByUIDAndPwd(String uid, String password)
    {
        User user = new User();
        user.setUid(uid);
        user.setPassword(password);
        return sqlSession.selectOne(namespace + ".queryByUIDAndPwd", user);
    }
    
}
