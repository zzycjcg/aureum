package com.brave.backend.dao;

/**
 * The Interface SeqGenDao.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public interface SeqGenDao
{
    
    /**
     * Next val.
     *
     * @param seqId the seq id
     * @return the string
     */
    String nextVal(String seqId);
    
    /**
     * Current val.
     *
     * @param seqId the seq id
     * @return the string
     */
    String currentVal(String seqId);
    
    /**
     * Sets the val.
     *
     * @param seqId the new val
     * @param seqVal the seq val
     */
    void setVal(String seqId, String seqVal);
}
