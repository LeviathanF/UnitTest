package com.example.msi_.unittest.http

import com.example.msi_.unittest.bean.TUser
import com.example.msi_.unittest.bean.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

/**
 *@Author：ZC
 *@Time： 2018/6/22 13:56
 *@Description：githubApi
 **/
interface GithubApi{
    companion object {
        val BASE_URL = "https://api.github.com/"
    }

    @GET("users/{username}")
    fun getUesr(@Path("username") name:String):Observable<TUser>
}