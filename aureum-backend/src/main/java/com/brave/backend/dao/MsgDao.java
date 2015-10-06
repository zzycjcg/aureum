package com.brave.backend.dao;

import java.util.List;

import com.brave.backend.dao.model.Msg;
import com.brave.backend.dao.model.MsgQueryCondition;
import com.brave.backend.dao.model.MsgWithContent;
import com.brave.foundation.dao.BaseDao;

public interface MsgDao extends BaseDao<Msg>
{
    List<MsgWithContent> pagingQuery(MsgQueryCondition condition);
}
