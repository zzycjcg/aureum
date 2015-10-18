package com.brave.backend.util;

/**
 * The Class PagingQueryUtil.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public abstract class PagingQueryUtil
{
    /**
     * Calculate index.
     *
     * @param numPerPage the num per page
     * @param page the page
     * @return the int[]
     */
    public static int[] calculateIndex(int numPerPage, int page)
    {
        int start = (page - 1) * numPerPage + 1;
        if (start <= 0)
        {
            start = 1;
        }
        int end = start + numPerPage;
        if (end <= 0)
        {
            end = 1;
        }
        int[] result = new int[2];
        result[0] = start;
        result[1] = end;
        return result;
    }
    
    /**
     * Calculate pages.
     *
     * @param numPerPage the num per page
     * @param count the count
     * @return the int
     */
    public static int calculatePages(int numPerPage, int count)
    {
        if (count <= 0)
        {
            return 0;
        }
        if (numPerPage <= 0)
        {
            numPerPage = 1;
        }
        int divide = count / numPerPage;
        return count % numPerPage == 0 ? divide : divide + 1;
    }
    
    /**
     * 计算起始下标.
     *
     * @param numPerPage 每页展示数量
     * @param page 要展示的页码
     * @return the int
     */
    public static int calculateStart(int numPerPage, int page)
    {
        return (page - 1) * numPerPage;
    }
    
}
