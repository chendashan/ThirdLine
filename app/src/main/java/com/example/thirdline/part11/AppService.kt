package com.example.thirdline.part11

import retrofit2.Call
import retrofit2.http.GET

interface AppService {

    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
}