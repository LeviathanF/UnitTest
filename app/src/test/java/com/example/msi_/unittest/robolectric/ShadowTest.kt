package com.example.msi_.unittest.robolectric

import android.util.Log
import com.example.msi_.unittest.BuildConfig
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog
import org.robolectric.shadow.api.Shadow.extract

/**
 *@Author：ZC
 *@Time： 2018/6/19 17:24
 *@Description：
 **/
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,sdk = [23],shadows = ([PersonShadow::class]))
class ShadowTest{

    @Before
    fun setUp(){
        ShadowLog.stream = System.out
    }

    @Test
    fun test(){
        val person = Person()
        Log.d("shadow",person.name)
        Log.d("shadow",person.sex.toString())
        Log.d("shadow",person.age.toString())

        val shadow = extract<PersonShadow>(person)
        Log.d("shadow",shadow.name)
        Log.d("shadow",shadow.sex.toString())
        Log.d("shadow",shadow.age.toString())
    }
}