package com.example.msi_.unittest.robolectric

import com.example.msi_.unittest.BuildConfig
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.android.controller.ActivityController
import org.robolectric.android.controller.ServiceController
import org.robolectric.annotation.Config
import org.robolectric.shadow.api.Shadow
import org.robolectric.shadows.ShadowLog
import org.junit.Assert.*

/**
 *@Author：ZC
 *@Time： 2018/6/19 17:03
 *@Description：Server生命周期测试
 **/
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,sdk = [23])
class MyServerTest{
    lateinit var controller: ServiceController<MyService>
    lateinit var myService: MyService

    @Before
    fun setUp(){
        ShadowLog.stream = System.out
        controller = Robolectric.buildService(MyService::class.java)
        myService = MyService()
    }

    @Test
    fun test(){
        assertNotNull(controller)
        controller.create()
        controller.startCommand(0,0)
        controller.bind()
        controller.unbind()
        controller.destroy()
    }
}