package com.example.thirdline.learn

/**
 * Java继承的关键字是extends，而在Kotlin中变成了一个冒号
 * kotlin的构造函数分为 主构造函数 和 次构造函数
 * 主构造函数的特点是没有函数体，直接定义在类名的后面即可。比如Student这种写法
 * 如果想在主构造函数中编写一些逻辑，Kotlin提供了一个init结构体
 * 像java一样子类中的构造函数必须调用父类中的构造函数，但是主构造函数没有构造方法，所以Person()后面的括号表示调用哪一个构造方法
 */
class Student(val sno: String, val grade: Int) : Person(){

    init {
        println("grade is " + grade)
    }
}