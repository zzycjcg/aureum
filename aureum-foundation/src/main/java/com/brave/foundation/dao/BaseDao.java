/*
 * 文 件 名:  BaseDao.java
 * 版    权:  zhuzhiyong Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZZY
 * 修改时间:  2015年6月7日
 * 修改内容:  <修改内容>
 */
package com.brave.foundation.dao;

import java.util.List;

/**
 * The Interface BaseDao.
 *
 * @author zhiyong zhu at 2015-10-18
 * @param <T> the generic type
 * @since v0.0.1
 */
public interface BaseDao<T>
{
    
    /**
     * Insert.
     *
     * @param object the object
     */
    void insert(Object object);
    
    /**
     * Update.
     *
     * @param object the object
     * @return the int
     */
    int update(Object object);
    
    /**
     * Delete.
     *
     * @param object the object
     * @return the int
     */
    int delete(Object object);
    
    /**
     * Query list.
     *
     * @param object the object
     * @return the list
     */
    List<T> queryList(Object object);
    
    /**
     * Query all.
     *
     * @return the list
     */
    List<T> queryAll();
    
    /**
     * Query single.
     *
     * @param object the object
     * @return the t
     */
    T querySingle(Object object);
    
    /**
     * Query count.
     *
     * @param object the object
     * @return the int
     */
    int queryCount(Object object);
}
