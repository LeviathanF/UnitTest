package com.example.msi_.unittest.jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

/**
 * 创建者：ZC
 * 创建日期： 2018/6/12 14:02
 * 描述：JUnit测试类
 **/
public class DateUtilTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

    /**
     * 测试所得结果是否相等
     */
    @Test
    public void testDateToString() throws ParseException {
        System.out.println("测试字符串转为时间戳");
        assertEquals("预期时间",1520215882000L,DateUtil.stringToStamp("2018-03-05 10:11:22"));
    }

    /**
     * 测试所得结果是否相等
     */
    @Test
    public void testLongToString() throws Exception{
        System.out.println("测试时间戳转为字符串");
        assertEquals("2018-03-05 10:11:22",DateUtil.stampToDate(1520215882000L));
    }

    /**
     * 测试是否能抛出异常,抛出了指定异常则表示测试通过
     * @throws Exception
     */
    @Test(expected = ParseException.class)
    public void testStringToStamp() throws Exception{
        System.out.println("测试是否能正常抛出异常");
        DateUtil.stringToStamp("aaaa");
    }
}