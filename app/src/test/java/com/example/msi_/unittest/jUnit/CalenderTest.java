package com.example.msi_.unittest.jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;

/**
 * @Author：ZC
 * @Time： 2018/6/26 9:09
 * @Description：
 **/
public class CalenderTest {

    @Before
    public void setUp(){
        System.out.println("测试开始");
    }

    @After
    public void afert(){
        System.out.println("测试结束");
    }
}
