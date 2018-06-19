package com.example.msi_.unittest.robolectric

/**
 *@Author：ZC
 *@Time： 2018/6/19 17:17
 *@Description：
 **/
open class Person(){
    open var name:String? = null
    open var sex:Int = 0

    open val age:Int
         get() = 11

    open fun eat(food:String):String{
        return food
    }
}