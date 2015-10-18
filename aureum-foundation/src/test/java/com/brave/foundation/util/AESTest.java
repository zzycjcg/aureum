package com.brave.foundation.util;

import org.junit.Assert;
import org.junit.Test;

public class AESTest
{
    @Test
    public void encrtpt()
    {
        System.out.println(AESUtil.decrypt("d35decd1a5c7321faa3672b50261a062", AESUtil.DEFAULT_KEY));
        System.out.println(AESUtil.encrypt("brave123", AESUtil.DEFAULT_KEY));
        Assert.assertEquals("4619a817510e3c0118ca7f5250166bde", AESUtil.encrypt("abc%^&WSX--", AESUtil.DEFAULT_KEY));
    }
    
    @Test
    public void decrypt()
    {
        Assert.assertEquals("abc%^&WSX--", AESUtil.decrypt("4619a817510e3c0118ca7f5250166bde", AESUtil.DEFAULT_KEY));
    }
}
