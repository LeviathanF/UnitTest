package com.example.msi_.unittest.robolectric

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msi_.unittest.R

/**
 *@Author：ZC
 *@Time： 2018/6/19 14:57
 *@Description：
 **/

class SimpleFragment:Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_simple,container)
    }
}