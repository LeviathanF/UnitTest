package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

/**
 *创建者：ZC
 *创建日期： 2018/6/12 16:55
 *描述：
 **/
class MockReturnTest{

    @get:Rule
    val rule = MockitoJUnit.rule()

    @Mock
    lateinit var person:Person

    @Test
    fun testRuturn(){
        `when`(person.name).thenReturn("小明")
        `when`(person.age).thenThrow(NullPointerException("调用了性别"))

        println(person.name)

        doReturn("小小").`when`<Person>(person).name
        println(person.name)
    }

    @Test
    fun testPersonAnswer(){
        `when`(person.eat(ArgumentMatchers.anyString())).thenAnswer{invocation ->
            val args = invocation.arguments
            args[0].toString()+"真好吃"
        }
        println(person.eat("aaa"))
    }
}