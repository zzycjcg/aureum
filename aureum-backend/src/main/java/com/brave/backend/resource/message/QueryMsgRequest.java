package com.brave.backend.resource.message;

/**
 * The Class QueryMsgRequest.
 */
public class QueryMsgRequest extends CommonRequest
{
    
    /** The page. */
    private int page;
    
    /** The num per page. */
    private int numPerPage;
    
    /** 指定用户，为空时查询全部用户. */
    private String uid;
    
    /** 是否逆序，默认根据时间逆序排列. */
    private boolean desc = true;
    
    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage()
    {
        return page;
    }
    
    /**
     * Sets the page.
     *
     * @param page the new page
     */
    public void setPage(int page)
    {
        this.page = page;
    }
    
    /**
     * Gets the num per page.
     *
     * @return the num per page
     */
    public int getNumPerPage()
    {
        return numPerPage;
    }
    
    /**
     * Sets the num per page.
     *
     * @param numPerPage the new num per page
     */
    public void setNumPerPage(int numPerPage)
    {
        this.numPerPage = numPerPage;
    }
    
    /**
     * Gets the uid.
     *
     * @return the uid
     */
    public String getUid()
    {
        return uid;
    }
    
    /**
     * Sets the uid.
     *
     * @param uid the new uid
     */
    public void setUid(String uid)
    {
        this.uid = uid;
    }
    
    /**
     * Checks if is desc.
     *
     * @return true, if is desc
     */
    public boolean isDesc()
    {
        return desc;
    }
    
    /**
     * Sets the desc.
     *
     * @param desc the new desc
     */
    public void setDesc(boolean desc)
    {
        this.desc = desc;
    }
    
}
