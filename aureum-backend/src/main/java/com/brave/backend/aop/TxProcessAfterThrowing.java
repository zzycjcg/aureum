package com.brave.backend.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class TxProcessAfterThrowing.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class TxProcessAfterThrowing
{
    private static Logger logger = LoggerFactory.getLogger(TxProcessAfterThrowing.class);
    
    /**
     * Logging.
     *
     * @param jp the jp
     * @param e the e
     */
    public void logging(JoinPoint jp, Throwable e)
    {
        logger.error("Handling tx failed. Args is {}", Arrays.toString(jp.getArgs()), e);
    }
}
