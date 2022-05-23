package com.example.thirdline

import com.example.thirdline.learn.CellPhone

fun main() {
    println("Learn Kotlin")

    fun243()

    val phone1 = CellPhone("Xiaomi", 1999.5)
    val phone2 = CellPhone("Xiaomi", 1999.5)
    println(phone1)
    println(phone1 == phone2)

}

fun fun243() {
    //区间  ..是创建两端闭区间的关键字，相当于数学中的[1, 10]
    val range = 1..10

    //for循环取消了for-i循环，使用for-in循环
    for(i in 1..10) {
        println(i)
    }

    //until关键字，表示区间左闭右开，相当于数学中的[0, 10)
    val ru = 0 until 10

    //step关键字，递增的步数，相当于for-i中的 i = i + 2
    for(i in 0 until 10 step 2) {
        println(i)
    }

    //downTo关键字，降序区间，相当于for(i = 5; i >= 1; i--)
    for (i in 5 downTo 1) {
        println(i)
    }

}