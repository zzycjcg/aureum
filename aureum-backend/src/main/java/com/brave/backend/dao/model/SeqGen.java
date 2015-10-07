package com.brave.backend.dao.model;

/**
 * The Class SeqGen.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class SeqGen
{
    private String seqId;
    
    private String seqVal;
    
    /**
     * Gets the seq id.
     *
     * @return the seq id
     */
    public String getSeqId()
    {
        return seqId;
    }
    
    /**
     * Sets the seq id.
     *
     * @param seqId the new seq id
     */
    public void setSeqId(String seqId)
    {
        this.seqId = seqId;
    }
    
    /**
     * Gets the seq val.
     *
     * @return the seq val
     */
    public String getSeqVal()
    {
        return seqVal;
    }
    
    /**
     * Sets the seq val.
     *
     * @param seqVal the new seq val
     */
    public void setSeqVal(String seqVal)
    {
        this.seqVal = seqVal;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SeqGen [seqId=");
        builder.append(seqId);
        builder.append(", seqVal=");
        builder.append(seqVal);
        builder.append("]");
        return builder.toString();
    }
}
