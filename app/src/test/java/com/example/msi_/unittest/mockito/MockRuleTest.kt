package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Person
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 *创建者：ZC
 *创建日期： 2018/6/12 16:23
 *描述：
 **/
@RunWith(MockitoJUnitRunner::class)
class MockRuleTest{
    @Mock
    lateinit var person:Person

    @Test
    fun testIsNotNull(){
        assertNotNull(person)
    }
}