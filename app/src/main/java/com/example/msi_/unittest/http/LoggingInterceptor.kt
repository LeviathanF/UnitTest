package com.example.msi_.unittest.http

import android.text.TextUtils
import android.util.Log
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import java.net.URLDecoder

/**
 *@Author：ZC
 *@Time： 2018/6/22 14:13
 *@Description：
 **/
class LoggingInterceptor:Interceptor{
    private val tag = "http"
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val startTime = System.currentTimeMillis()
        val response = chain.proceed(request)
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        val mediaType = response.body()!!.contentType()
        Log.d(tag,"\n")
        Log.d(tag,"----------Start----------------")
        Log.d(tag,"| RequestUrl:"+request.url())
        Log.d(tag,"| RequestHeaders:\n" + request.headers())

        val method = request.method()
        if ("POST" == method){
            val sb = StringBuilder()
            if (request.body() is FormBody){
                val body = request.body() as FormBody
                for (i in 0 until body!!.size()){
                    sb.append(body.encodedName(i)+":"+(if (TextUtils.isEmpty(body.encodedValue(i)))
                            "参数为空"
                            else
                            URLDecoder.decode(body.encodedValue(i),"utf-8"))+",")
                }
                if (sb.isNotEmpty()){
                    sb.delete(sb.length-1,sb.length)
                }
                Log.d(tag,"| RequestParams:\n")
                Log.d(tag,"{+$sb+}")
            }
        }
        Log.d(tag,"| ResponseHeaders:\n"+response.headers())
        val content = response.body()!!.toString()
        Log.d(tag,"{+$content+}")

        Log.d(tag,"----------End:${duration}毫秒----------")
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType,content))
                .build()
    }
}