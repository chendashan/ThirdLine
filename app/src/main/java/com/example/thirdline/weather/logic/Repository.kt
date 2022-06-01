package com.example.thirdline.weather.logic

import androidx.lifecycle.liveData
import com.example.thirdline.weather.logic.network.WeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 * @author chendashan
 * @date 2022/6/1
 */
object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = WeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        //emit()方法将包装的结果发射出去，类似于调用LiveData的setValue()方法
        emit(result)
    }
}