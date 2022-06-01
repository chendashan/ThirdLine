package com.example.thirdline.weather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @author chendashan
 * @date 2022/6/1
 */
object WeatherNetwork {

    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    //定义await()函数为挂起函数和 Call<T> 的扩展函数
    private suspend fun <T> Call<T>.await(): T {
        // suspendCoroutine函数挂起当前协程，然后在普通线程中执行Lambda表达式里的代码
        //传入的参数continuation用于让协程恢复执行
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) {
                        continuation.resume(body)
                    } else {
                        continuation.resumeWithException(RuntimeException("response body is null"))
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

            })

        }
    }
}