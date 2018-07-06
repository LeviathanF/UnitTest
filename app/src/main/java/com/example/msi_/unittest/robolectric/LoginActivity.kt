package com.example.msi_.unittest.robolectric

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.msi_.unittest.R

/**
 *@Author：ZC
 *@Time： 2018/6/19 10:09
 *@Description：
 **/
class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}