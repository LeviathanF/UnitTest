package com.example.msi_.unittest.robolectric

import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.msi_.unittest.BuildConfig
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.junit.Assert.*
import com.example.msi_.unittest.R
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.android.controller.ActivityController
import org.robolectric.shadow.api.Shadow
import org.robolectric.shadows.ShadowActivity
import org.robolectric.shadows.ShadowAlertDialog
import org.robolectric.shadows.ShadowDialog
import org.robolectric.shadows.ShadowToast
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

/**
 *@Author：ZC
 *@Time： 2018/6/19 9:28
 *@Description：Robolectric框架测试
 **/

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,sdk = [23])
class MainActivityTest{
    private lateinit var mainActivity:MainActivity
    private lateinit var btnJump:Button
    private lateinit var btnToast:Button
    private lateinit var btnDialog:Button
    private lateinit var btnInverse:Button
    private lateinit var cbTest:CheckBox

    @Before
    fun setUp(){
        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        btnJump = mainActivity.findViewById(R.id.btn_login) as Button
        btnToast = mainActivity.findViewById(R.id.btn_toast) as Button
        btnDialog = mainActivity.findViewById(R.id.btn_dialog) as Button
        btnInverse = mainActivity.findViewById(R.id.btn_inverse) as Button
        cbTest = mainActivity.findViewById(R.id.cb_test) as CheckBox
    }

    /**
     * 测试是否能加载Activity
     */
    @Test
    fun testMainActivity(){
        assertNotNull(mainActivity)
    }

    /**
     * 测试Activity之间跳转
     */
    @Test
    fun testActivityJump(){
        assertEquals(btnJump.text,"login")
//        触发按钮点击
        btnJump.performClick()
//        获取对应的shadow类
        val mainShadow = Shadows.shadowOf(mainActivity)
//        通过shadow类获取启动下一个Activity的Intent
        val nextIntent = mainShadow.nextStartedActivity
//        验证类名称
        assertEquals(nextIntent.component.className,LoginActivity::class.java.name)
    }

    /**
     * 测试Toast弹出
     */
    @Test
    fun testToast(){
//        获取toast
        var toast = ShadowToast.getLatestToast()
//        验证toast未弹出
        assertNull(toast)

//        点击按钮
        btnToast.performClick()
        toast = ShadowToast.getLatestToast()
        assertNotNull(toast)

//        比较Toast持续时间
        assertEquals(toast.duration,Toast.LENGTH_SHORT)
//        比较Toast展示内容
        assertEquals(ShadowToast.getTextOfLatestToast(),"Toast test")
    }

    /**
     * 测试Dialog弹出
     */
    @Test
    fun testDialog(){
        var alertDialog = ShadowAlertDialog.getLatestAlertDialog()
        assertNull(alertDialog)

        btnDialog.performClick()

        alertDialog = ShadowAlertDialog.getLatestAlertDialog()
        assertNotNull("未弹出新的AlertDialog",alertDialog)

        val shadowDialog = Shadows.shadowOf(alertDialog)
        assertEquals(shadowDialog.title,"提示")
        assertEquals(shadowDialog.message,"Hello World")
    }

    /**
     * 验证UI组件状态
     */
    @Test
    fun testCheckBox(){
        assertFalse(cbTest.isChecked)

        btnInverse.performClick()

        assertTrue(cbTest.isChecked)

        btnInverse.performClick()

        assertFalse(cbTest.isChecked)
    }

    /**
     * 验证Fragment
     */
    @Test
    fun testFragment(){
        val fragment = SimpleFragment()
        SupportFragmentTestUtil.startFragment(fragment)
        assertNotNull(fragment)
    }

    /**
     * 验证获取资源
     */
    @Test
    fun testResources(){
        val application = RuntimeEnvironment.application
        val appName = application.getString(R.string.app_name)
        assertEquals(appName,"UnitTest")
    }

    /**
     * 测试生命周期
     */
    @Test
    fun testLifeCycle(){
        val controller:ActivityController<MainActivity> = Robolectric.buildActivity(MainActivity::class.java)
        val activity =  controller.get()
        assertNull(activity.lifecycleState)

        controller.create()
        assertEquals(activity.lifecycleState,"onCreate")

        controller.start()
        assertEquals(activity.lifecycleState,"onStart")

        controller.resume()
        assertEquals(activity.lifecycleState,"onResume")

        controller.pause()
        assertEquals(activity.lifecycleState,"onPause")

        controller.stop()
        assertEquals(activity.lifecycleState,"onStop")

        controller.destroy()
        assertEquals(activity.lifecycleState,"onDestroy")
    }
}