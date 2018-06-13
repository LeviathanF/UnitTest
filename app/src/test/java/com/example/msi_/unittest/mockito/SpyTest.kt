package com.example.msi_.unittest.mockito

import com.example.msi_.unittest.bean.Home
import com.example.msi_.unittest.bean.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Spy
import org.mockito.junit.MockitoJUnit
import org.mockito.Mockito.*

/**
 *@Author：ZC
 *@Time： 2018/6/13 15:51
 *@Description：
 **/
class SpyTest{
    @Spy
    lateinit var person: Person

    @InjectMocks
    lateinit var home: Home

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Test
    fun testSpy(){
        `when`(person.name).thenReturn("b")
        println(home.master)
    }
}