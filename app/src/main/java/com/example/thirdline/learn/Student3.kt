package com.example.thirdline.learn

/**
 * 一种非常特殊的情况：类中只有次构造函数，没有主构造函数，这种十分少见
 * 在次构造方法中用super调用了父类的构造方法
 */
class Student3 : Person2 {
    constructor(name: String, age: Int) : super(name, age) {

    }
}