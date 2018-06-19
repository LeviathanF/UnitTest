package com.example.msi_.unittest.robolectric

import android.content.Intent
import android.preference.PreferenceManager
import com.example.msi_.unittest.BuildConfig
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowApplication
import org.junit.Assert.*
import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.ShadowPackageManager

/**
 *@Author：ZC
 *@Time： 2018/6/19 15:52
 *@Description：
 **/
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,sdk = [23])
class MyReceiverTest{

    private val action = "MyReceiver"

    @Before
    fun setUp(){}

    /**
     * 检查Receiver是否注册
     */
    @Test
    fun testRegister(){
        val shadowApplication = ShadowApplication.getInstance()
        assertNotNull(shadowApplication)
        val intent = Intent(action)

        assertTrue(shadowApplication.hasReceiverForIntent(intent))
    }

    /**
     * 广播测试
     */
    @Test
    fun testReceiver(){
        val intent = Intent(action)
        intent.putExtra(MyReceiver.NAME,"test")
        val myReceiver = MyReceiver()
        myReceiver.onReceive(RuntimeEnvironment.application,intent)

        val preferences = PreferenceManager.getDefaultSharedPreferences(org.robolectric.RuntimeEnvironment.application)
        assertEquals(preferences.getString(MyReceiver.NAME,""),"test")
    }
}