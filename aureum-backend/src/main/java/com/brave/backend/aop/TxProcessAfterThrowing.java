package com.brave.backend.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TxProcessAfterThrowing
{
    private static Logger logger = LoggerFactory.getLogger(TxProcessAfterThrowing.class);
    
    public void logging(JoinPoint jp, Throwable e)
    {
        logger.error("Handling tx failed. Args is {}", Arrays.toString(jp.getArgs()), e);
    }
}
