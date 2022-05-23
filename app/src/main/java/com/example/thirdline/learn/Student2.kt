package com.example.thirdline.learn

/**
 * 主构造函数中声明成val或者var的参数将自动成为该类的字段，所以name和age不能加任何关键字，否则和父类冲突
 */
class Student2(val son: String, val grade: Int, name: String, age: Int) : Person2(name, age) {

    //次构造函数是通过constructor关键字来定义的
    //所有的次构造方法都必须调用主构造方法（包括间接调用）
    constructor(name: String, age: Int) : this("", 0, name, age) {

    }
}