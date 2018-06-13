package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

/**
 *@Author：ZC
 *@Time： 2018/6/13 9:21
 *@Description：测试verify函数
 **/

class MockVerify{

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Mock
    lateinit var person: Person

    /**
     *测试延迟方法
     */
    @Test
    fun testPersonAfertVerify(){
        `when`(person.age).thenReturn(18)
        println(person.age)
        println(System.currentTimeMillis())
        verify(person, after(1000)).age
        println(System.currentTimeMillis())
        println(person.age)
    }

    /**
     * 测试最少使用次数函数
     */
    @Test
    fun testPersonVerifyAtLeast(){
        person.age
        person.age
        verify(person, atLeast(2)).age
    }

    /**
     * 测试最多次数
     */
    @Test
    fun testPersonVerifyAtMost(){
        person.age
        verify(person, atMost(2)).age
    }

    /**
     * 测试调用次数
     */
    @Test
    fun testPersonVerifyTimes(){
        person.age
        verify(person, times(1)).age
    }

    /**
     * 测试指定时间内的调用次数次数
     */
    @Test
    fun testPersonVerifyTimeOut(){
        person.age
        person.age
        verify(person, timeout(100).times(2)).age
    }
}