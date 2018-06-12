package com.example.msi_.unittest.jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;

/**
 * 创建者：ZC
 * 创建日期： 2018/6/12 14:50
 * 描述：assertThat测试
 **/
public class AssertThatDemo {

    @Rule
    public MyRule rule = new MyRule();

    /**
     * 测试是否值为空
     */
    @Test
    public void testNullValue(){
        assertThat(null, CoreMatchers.nullValue());
    }

    /**
     * 测试是否符合字符串标准
     */
    @Test
    public void testFormatString() throws Exception {
        assertThat("Hello World", CoreMatchers
                .both(CoreMatchers.startsWith("He"))
                .and(CoreMatchers.endsWith("ld")));
    }

    @Test
    public void testIsMobliePhone() throws Exception{
        assertThat("18602547485",new IsMobilePhoneMatcher());
    }
}
