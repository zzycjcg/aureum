package com.brave.backend.dao;

import com.brave.backend.dao.model.User;
import com.github.zzycjcg.foundation.dao.BaseDao;

/**
 * The Interface UserDao.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public interface UserDao extends BaseDao<User>
{
    /**
     * Query by uid and pwd.
     *
     * @param uid the uid
     * @param password the password
     * @return the user
     */
    User queryByUIDAndPwd(String uid, String password);
}
