package com.example.thirdline.weather.logic

import androidx.lifecycle.liveData
import com.example.thirdline.weather.logic.network.WeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 * @author chendashan
 * @date 2022/6/1
 *
 * 仓库层的主要工作就是判断调用方请求的数据应该是从本地数据源中获取还是从网络数据源中获
    取，并将获得的数据返回给调用方。因此，仓库层有点像是一个数据获取与缓存的中间层，在
    本地没有缓存数据的情况下就去网络层获取，如果本地已经有缓存了，就直接将缓存数据返回。
 */

object Repository {

    // liveData() 自动构建并返回一个LiveData对象，然后在它的代码块中提供一个挂起函数的上下文
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