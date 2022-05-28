package com.example.thirdline.part5

import kotlin.reflect.KProperty

class Delegate {

    var propValue: Any? = null

    operator fun getValue(myClass: MyClass, prop: KProperty<*>) : Any? {
        return propValue
    }
}