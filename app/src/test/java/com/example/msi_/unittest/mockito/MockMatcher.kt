package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.Mockito.*
import org.mockito.junit.MockitoRule

/**
 *@Author：ZC
 *@Time： 2018/6/13 9:42
 *@Description：
 **/

class MockMatcher{

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Mock
    lateinit var person: Person

    @Test
    fun testPersonAny(){
        `when`(person.eat(any(String::class.java))).thenReturn("a")
        println(person.eat("b"))
    }

    @Test
    fun testPersonContains(){
        `when`(person.eat(ArgumentMatchers.contains("a"))).thenReturn("b")
        println(person.eat("a"))
    }

    @Test
    fun testPersonAnyThat(){
        `when`(person.eat(argThat {
            argument -> argument!!.length%2==0
        })).thenReturn("b")
        println(person.eat("aa"))
    }
}