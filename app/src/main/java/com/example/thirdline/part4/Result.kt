package com.example.thirdline.part4

/**
 * @author chendashan
 * @date 2022/5/27
 */

sealed class Result

class Success(val msg: String) : Result()

class Error(val error: Exception) : Result()

fun getResultMsg(result: Result) : String {
    return when(result) {
        is Success ->
            result.msg
        is Error ->
            result.error.toString()
    }
}