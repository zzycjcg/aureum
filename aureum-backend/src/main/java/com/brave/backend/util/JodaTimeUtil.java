package com.brave.backend.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * The Class JodaDateTimeUtil.
 */
public abstract class JodaTimeUtil
{
    
    /**
     * The Interface DateFormaters.
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
