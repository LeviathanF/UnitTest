package com.example.msi_.unittest.robolectric

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 *@Author：ZC
 *@Time： 2018/6/19 15:41
 *@Description：
 **/

class MyReceiver:BroadcastReceiver(){
    companion object {
        const val NAME:String = "name"
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
        val name = intent!!.getStringExtra(NAME)
        editor.putString(NAME,name)
        editor.apply()
    }
}