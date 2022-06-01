package com.example.thirdline.part11

import retrofit2.Call
import retrofit2.http.GET

interface AppService {

    //@GET注解表示GET请求，请求地址的相对路径就是注解中传入的参数
    @GET("get_data.json")
    //方法的返回值必须声明成Retrofit中内置的Call类型，并通过泛型来指定服务器响应的数据应该转换成什么对象
    fun getAppData(): Call<List<App>>
}