package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Home
import com.example.msi_.unittest.bean.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.junit.Assert.*
import org.mockito.InjectMocks
import org.mockito.Mockito.inOrder

/**
 *@Author：ZC
 *@Time： 2018/6/13 15:35
 *@Description：
 **/

class MockitoSpyTest{

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Mock
    lateinit var person: Person

    @Test
    fun testIsNull(){
        assertNotNull(person)
    }

    @Test
    fun testSpy(){
        println(person.age)
    }

    @Test
    fun testPersonInOrder(){
        person.sex = 0
        person.name = "test"

        val inOrder = inOrder(person)

        inOrder.verify(person).sex = 0
        inOrder.verify(person).name = "test"
    }


}