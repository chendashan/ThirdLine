package com.example.thirdline.learn

/**
 * @author chendashan
 * @date 2022/6/1
 */

fun main() {
    val he = num1AndNum2(2, 5) { n1, n2 ->
        n1 + n2
    }
    println(he)

    val r1 = getGenericType<String>()
    println(r1)
}


inline fun <reified T> getGenericType() = T::class.java

inline fun num1AndNum2(n1: Int, n2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(n1, n2)
    return result
}

