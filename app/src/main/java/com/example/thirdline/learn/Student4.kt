package com.example.thirdline.learn

class Student4(name: String, age: Int) : Person2(name, age), Study {
    override fun readBook() {
        println(name + " is reading")
    }

    override fun doHomeWork() {
        println(name + " doing homework")
    }
}