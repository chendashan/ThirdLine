package com.example.thirdline.part11

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * @author chendashan
 * @date 2022/6/1
 */
interface ExampleService {

    //动态地址类型
    @GET("{page}/get_data")
    fun getData(@Path("page") page: Int): Call<App>

    //带参数
    @GET("get_data")
    fun getDataByQuery(@Query("u") user: String, @Query("t") token: String): Call<App>

    //DELETE请求
    @DELETE("data/{id}")
    fun deleteData(@Path("id") id: String): Call<ResponseBody>

    //POST请求   @Body会自动把对象转换成json格式文本
    @POST("data/create")
    fun postData(@Body data: App): Call<ResponseBody>

    //在HTTP请求的header中指定参数
    @Headers("User-Agent: okhttp", "Cache-Control: max-age=0")
    @GET("get_data")
    fun getData(): Call<App>

    //动态指定header的值使用@Header注解
    @GET("get_data.json")
    fun getData(@Header("User-Agent") userAgent: String,
                @Header("Cache-Control") cacheControl: String): Call<App>
}