package com.example.thirdline.weather.logic.network

import com.example.thirdline.ThirdLineApplication
import com.example.thirdline.weather.logic.model.DailyResponse
import com.example.thirdline.weather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${ThirdLineApplication.WEATHER_TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<RealtimeResponse>

    @GET("v2.5/${ThirdLineApplication.WEATHER_TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>
}