package com.example.thirdline.learn

/**
 * 创建单例类方式：把class关键字换成object关键字
 * 使用时时直接 Singleton.singletonTest()
 * 这种写法虽然看上去像是静态方法的调用，但其实Kotlin在背后自动帮我们创建了一个Singleton类的实例
 */
object Singleton {
    fun singletonTest() {
        println("singletonTest is called")
    }

}