package com.example.msi_.unittest.http

import android.util.Log
import com.example.msi_.unittest.BuildConfig
import com.example.msi_.unittest.bean.TUser
import com.example.msi_.unittest.bean.User
import io.reactivex.Observer
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowLog
import java.util.concurrent.ScheduledFuture

/**
 *@Author：ZC
 *@Time： 2018/6/22 16:35
 *@Description：
 **/

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,sdk = [23])
class ResponeTest{

    val tag = "ResponeTest"
    @Before
    fun setUp(){
        ShadowLog.stream = System.out
        initRxJava2()
    }

    private fun initRxJava2(){
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler{Schedulers.trampoline()}
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setMainThreadSchedulerHandler{Schedulers.trampoline()}
    }


    @Test fun getUserTest(){
        GithubService.createGithubService()
                .getUesr("simplezhli")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<TUser>{
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: TUser) {
                        Log.d(tag,"${t.name}")
                    }

                    override fun onError(e: Throwable) {
                        Log.d(tag,e.message)
                    }

                })

    }
}