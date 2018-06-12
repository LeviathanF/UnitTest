package com.example.msi_.unittest.jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

/**
 * 创建者：ZC
 * 创建日期： 2018/6/12 14:21
 * 描述：JUnit参数化测试
 **/
@RunWith(Parameterized.class)
public class ParamterTest {

    private String time;

    public ParamterTest(String time){
        this.time = time;
    }

    @Before
    public void setUp()throws Exception{
        System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("测试结束\n");
    }

    /**
     * 填写参数
     */
    @Parameterized.Parameters
    public static Collection primeNumbers(){
        return Arrays.asList("2017-05-01",
                "2017-05-01 16:12:11",
                "2017年5月4号 16时00分02秒");
    }

    @Test(expected = ParseException.class)
    public void testStringToStamp()throws Exception{
        System.out.println("转换日期");
        DateUtil.stringToStamp(time);
    }

}
