package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Person
import org.mockito.Mockito.mock
import org.junit.Assert.*
import org.junit.Test

/**
 *创建者：ZC
 *创建日期： 2018/6/12 16:16
 *描述：测试Mock
 **/

class MockTest{

    @Test
    fun testIsNotNull(){
        var person = mock<Person>(Person::class.java)
        assertNotNull(person)
    }
}