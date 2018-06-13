package com.example.msi_.unittest.bean

/**
 *@Author：ZC
 *@Time： 2018/6/13 15:46
 *@Description：
 **/
class Home(private val person: Person){
    val master:String?
     get() = person.name
}