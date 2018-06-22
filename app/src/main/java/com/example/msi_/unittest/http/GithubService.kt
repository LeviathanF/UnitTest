package com.example.msi_.unittest.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.logging.Logger
import java.util.logging.LoggingMXBean
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *@Author：ZC
 *@Time： 2018/6/22 13:59
 *@Description：
 **/

object GithubService{
    private val retrofit = Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private val okHttpClient:OkHttpClient
        get() = OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .connectTimeout(20,TimeUnit.SECONDS)
                .build()

    fun createGithubService():GithubApi{
        return retrofit.create(GithubApi::class.java)
    }
}