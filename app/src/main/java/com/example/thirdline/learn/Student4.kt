package com.example.thirdline.learn

/**
 * Java中继承使用的关键字是extends，实现接口使用的关键字是implements，而Kotlin中统一使用冒号，中间用逗号进行分隔。
 */
class Student4(name: String, age: Int) : Person2(name, age), Study {
    override fun readBook() {
        println(name + " is reading")
    }

    override fun doHomeWork() {
        println(name + " doing homework")
    }
}