package com.example.msi_.unittest.robolectric

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 *@Author：ZC
 *@Time： 2018/6/19 16:29
 *@Description：
 **/
class MyService:Service(){
    companion object {
        const val TAG = "MyService"
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d(TAG,"onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"onCreate")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG,"onUnbind")
        return super.onUnbind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
}