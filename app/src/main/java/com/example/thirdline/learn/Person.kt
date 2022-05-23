package com.example.thirdline.learn

/**
 * kotlin中任何一个非抽象类默认都是不可以被继承的，想要被继承要在前面加上open关键字
 */
open class Person {
    var name = ""
    var age = 0

    fun eat() {
        println(name + " is eating. He is " + age + " years old.")
    }

}

fun main() {
    val p = Person()
    p.name = "Jack"
    p.age = 17
    p.eat()
}