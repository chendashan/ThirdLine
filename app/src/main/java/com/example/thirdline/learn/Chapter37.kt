package com.example.thirdline.learn

fun main() {
    //funWith()
    funRun()
}

fun funWith() {
    val array = listOf("Apple", "Pear", "Banana", "Grape")
    val result = with(StringBuilder()) {
        append("start eat\n")
        for (s in array) {
            append(s).append("\n")
        }
        append("end").toString()
    }
    println(result)
}

fun funRun() {
    val array = listOf("Apple", "Pear", "Banana", "Grape")
    val result = StringBuilder().run {
        append("start eat\n")
        for (s in array) {
            append(s).append("\n")
        }
        append("end").toString()
    }
    println(result)
}

fun funApply() {
    val array = listOf("Apple", "Pear", "Banana", "Grape")
    val result = StringBuilder().apply {
        append("start eat\n")
        for (s in array) {
            append(s).append("\n")
        }
        append("end")
    }
    println(result.toString())
}