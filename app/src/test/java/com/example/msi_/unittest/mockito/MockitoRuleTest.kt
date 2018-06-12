package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import org.junit.Assert.*

/**
 *创建者：ZC
 *创建日期： 2018/6/12 16:30
 *描述：
 **/
class MockitoRuleTest{

    @Mock
    lateinit var person:Person

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Test
    fun testIsNotNull(){
        assertNotNull(person)
    }
}