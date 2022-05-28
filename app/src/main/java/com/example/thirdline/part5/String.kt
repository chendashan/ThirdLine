package com.example.thirdline.part5

fun String.lettersCount() : Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}


fun main() {
    val count = "abc12*&%#$ LKAS  JF".lettersCount()
    println(count)

    val str = "apple" * 5
    println(str)

    val money1 = Money(22, "abc")
    val money2 = Money(1000, "def")
    val result = money1 + money2
    println("money value: ${result.value} , tip: ${result.tip}")
}


operator fun String.times(n: Int) : String {
    val sb = StringBuilder()
    for (i in 1 .. n) {
        sb.append(this)
    }
    return sb.toString()
}

class Money(val value: Int, val tip: String) {
    operator fun plus(money: Money) : Money {
        val v = value + money.value
        return Money(v, "hello")
    }
}