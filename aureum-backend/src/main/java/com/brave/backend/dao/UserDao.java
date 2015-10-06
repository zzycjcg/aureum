package com.brave.backend.dao;

import com.brave.backend.dao.model.User;
import com.brave.foundation.dao.BaseDao;

public interface UserDao extends BaseDao<User>
{
    User verifyUserPassword(String uid, String password);
}
