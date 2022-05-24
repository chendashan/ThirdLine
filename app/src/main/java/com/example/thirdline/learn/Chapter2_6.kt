package com.example.thirdline.learn

/**
 * @author chendashan
 * @date 2022/5/24
 */

fun main() {
    //fun261List()
    fun261Lambda()
}

fun fun261List() {
    //listOf()函数创建的是一个不可变的集合
    val list = listOf("Apple", "Banana", "Orange", "Pear")
    for (fruit in list) {
        println(fruit)
    }

    //使用mutableListOf()函数创建一个可变的集合
    val list2 = mutableListOf("Apple", "Banana", "Orange", "Pear")
    list2.add("Grape")
    for (fruit in list2) {
        println(fruit)
    }
}

fun fun261Map() {
    val map = HashMap<String, Int>()
    map["Apple"] = 1
    map["Banana"] = 2
    map["Orange"] = 3

    val map2 = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3)

    for ((fruit, number) in map) {
        println(fruit + number)
    }
}

fun fun261Lambda() {
    val list = listOf("Apple", "Banana", "Pear", "Watermelon")
    val lambda = { fruit: String -> fruit.length }
    val maxLengthFruit = list.maxByOrNull(lambda)

    list.maxByOrNull() { fruit: String -> fruit.length }

    val maxLengthFruit2 = list.maxByOrNull { it.length }

    println("max length is" + maxLengthFruit)

    val newList = list.map { it.uppercase()}

    val list2 = list.filter { it.length <= 5 }
        .map { it.uppercase() }

    for (fruit in list2) {
        println(fruit)
    }

    val any = list.any { it.length <= 5 }
    val all = list.all { it.length <= 5 }
    println("any is " + any + ", all is " + all)

}

fun newThread() {
    Thread { println("running") }.start()

    Thread(Runnable{
        println("running")
    }).start()

    Thread {
        println("running")
    }.start()


}