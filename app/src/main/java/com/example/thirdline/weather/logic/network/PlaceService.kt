package com.example.thirdline.weather.logic.network

import com.example.thirdline.ThirdLineApplication
import com.example.thirdline.weather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author chendashan
 * @date 2022/6/1
 */
interface PlaceService {

    @GET("v2/place?token=${ThirdLineApplication.WEATHER_TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}