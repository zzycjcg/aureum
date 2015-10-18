package com.brave.backend.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class JsonUtilTest.
 *
 * @author zhiyong zhu at 2015-10-8
 * @since v0.0.1
 */
public class JsonUtilTest
{
    private TestObject testObject1;
    
    private List<String> strings1;
    
    private String jsonString1;
    
    private List<TestObject> testObject2;
    
    private String jsonString2;
    
    /**
     * Prepare.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Before
    public void prepare()
        throws IOException
    {
        // TEST1
        strings1 = new ArrayList<String>();
        strings1.add("string1");
        strings1.add("string2");
        testObject1 = new TestObject("test1", strings1);
        jsonString1 =
            IOUtils.toString(JsonUtilTest.class.getClassLoader().getResourceAsStream("util/testToJson1.json"));
            
        // TEST2
        List<String> temp1Strings = new ArrayList<String>();
        temp1Strings.add("string1");
        temp1Strings.add("string2");
        TestObject temp1 = new TestObject("array[1]", temp1Strings);
        List<String> temp2Strings = new ArrayList<String>();
        temp2Strings.add("string3");
        temp2Strings.add("string4");
        TestObject temp2 = new TestObject("array[2]", temp2Strings);
        testObject2 = new ArrayList<TestObject>();
        testObject2.add(temp1);
        testObject2.add(temp2);
        jsonString2 =
            IOUtils.toString(JsonUtilTest.class.getClassLoader().getResourceAsStream("util/testToJson2.json"));
    }
    
    /**
     * Test to json1.
     */
    @Test
    public void testToJson1()
    {
        Assert.assertEquals(jsonString1, JsonUtil.toJson(testObject1));
    }
    
    /**
     * Test parse object.
     */
    @Test
    public void testParseObject()
    {
        Assert.assertEquals(testObject1, JsonUtil.parseObject(jsonString1, TestObject.class));
    }
    
    /**
     * Test to json2.
     */
    @Test
    public void testToJson2()
    {
        Assert.assertEquals(jsonString2, JsonUtil.toJson(testObject2));
    }
    
    /**
     * Test parse array.
     */
    @Test
    public void testParseArray()
    {
        List<TestObject> array = JsonUtil.parseArray(jsonString2, TestObject.class);
        Assert.assertTrue(isEqualList(testObject2, array));
    }
    
    private static boolean isEqualList(List<?> c1, List<?> c2)
    {
        if (c1 == null || c1 == null)
        {
            return false;
        }
        if (c1.size() != c2.size())
        {
            return false;
        }
        for (int i = 0; i < c1.size(); i++)
        {
            if (!Objects.equals(c1.get(i), c2.get(i)))
            {
                return false;
            }
        }
        return true;
    }
    
    private static class TestObject
    {
        private String val1;
        
        private List<String> val2;
        
        @SuppressWarnings("unused")
        public TestObject()
        {
        }
        
        public TestObject(String val1, List<String> val2)
        {
            this.val1 = val1;
            this.val2 = val2;
        }
        
        @SuppressWarnings("unused")
        public String getVal1()
        {
            return val1;
        }
        
        @SuppressWarnings("unused")
        public void setVal1(String val1)
        {
            this.val1 = val1;
        }
        
        @SuppressWarnings("unused")
        public List<String> getVal2()
        {
            return val2;
        }
        
        @SuppressWarnings("unused")
        public void setVal2(List<String> val2)
        {
            this.val2 = val2;
        }
        
        public boolean equals(Object obj)
        {
            if (!(obj instanceof TestObject))
            {
                return false;
            }
            if (obj == this)
            {
                return true;
            }
            return StringUtils.equals(((TestObject)obj).val1, this.val1)
                && isEqualList(((TestObject)obj).val2, this.val2);
        }
        
    }
}
