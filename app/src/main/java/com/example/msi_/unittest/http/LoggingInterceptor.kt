package com.example.msi_.unittest.http

import android.text.TextUtils
import android.util.Log
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog
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
    override fun intercept(chain: Interceptor.Chain): Response {
        XLog.init(LogLevel.ALL)
        val request = chain.request()
        val startTime = System.currentTimeMillis()
        val response = chain.proceed(request)
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        val mediaType = response.body()!!.contentType()
        XLog.d("\n")
        XLog.d("----------Start----------------")
        XLog.d("| RequestUrl:${request.url()}")
        XLog.d("| RequestHeaders:\n" + request.headers())

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
                XLog.d("| RequestParams:\n")
                try {
                    XLog.json(sb.toString())
                } finally {
                    XLog.d(sb.toString())
                }
            }
        }
        XLog.d("| ResponseHeaders:\n"+response.headers())
        XLog.d("-----body start-----")
        val content = response.body()!!.string()
        try {
            XLog.json(content)
        } catch (e:Exception){
            XLog.e(e)
        }finally {
            XLog.d(content)
        }
        XLog.d("-----body end-----")
        XLog.d("\n")
        XLog.d("----------End:${duration}毫秒----------")
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType,content))
                .build()
    }
}