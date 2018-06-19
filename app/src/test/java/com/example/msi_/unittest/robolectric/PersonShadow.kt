package com.example.msi_.unittest.robolectric

import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements

/**
 *@Author：ZC
 *@Time： 2018/6/19 17:21
 *@Description：创建Person类的Shadow
 **/

@Implements(Person::class)
class PersonShadow() {
    val name: String
        @Implementation
        get() = "test"

    val sex: Int
        @Implementation
        get() = 1

    val age: Int
        @Implementation
        get() = 18
}