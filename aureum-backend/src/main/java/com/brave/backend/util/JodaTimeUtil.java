package com.brave.backend.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * The Class JodaDateTimeUtil.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public abstract class JodaTimeUtil
{
    
    /**
     * The Interface DateFormaters.
     *
     * @author zhiyong zhu at 2015-10-7
     * @since v0.0.1
     */
    public static interface DateFormats
    {
        
        /** yyyyMMddHHmmss. */
        String FORMAT_1 = "yyyyMMddHHmmss";
    }
    
    /**
     * Gets the current utc time.
     *
     * @param dateFormat the date format
     * @return the current utc time
     */
    public static String getCurrentUTCTime(String dateFormat)
    {
        return DateTime.now(DateTimeZone.UTC).toString(dateFormat);
    }
}
