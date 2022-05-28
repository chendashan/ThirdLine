package com.example.thirdline.part11

import kotlinx.coroutines.*

fun main() {

    GlobalScope.launch {
        println("codes run in coroutine scope")
    }
    Thread.sleep(1000)


    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {
        //逻辑代码
    }
    job.cancel()


    runBlocking {
        val result = async {
            5 + 5
        }.await()
        println(result)
    }
}

suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}