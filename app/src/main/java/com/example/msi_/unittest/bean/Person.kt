package com.example.msi_.unittest.bean

/**
 *创建者：ZC
 *创建日期： 2018/6/12 16:04
 *描述：Person实体类
 **/
open class Person{
    open var name:String? = null
    open var sex:Int = 0

    open val age:Int
        get() = 11

    open fun eat(food:String?):String?{
        return food
    }
}